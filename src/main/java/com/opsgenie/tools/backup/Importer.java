package com.opsgenie.tools.backup;

import com.ifountain.opsgenie.client.OpsGenieClient;
import com.opsgenie.tools.backup.importers.EscalationImporter;
import com.opsgenie.tools.backup.importers.GroupImporter;
import com.opsgenie.tools.backup.importers.HeartbeatImporter;
import com.opsgenie.tools.backup.importers.ImporterInterface;
import com.opsgenie.tools.backup.importers.ScheduleImporter;
import com.opsgenie.tools.backup.importers.ScheduleOverrideImporter;
import com.opsgenie.tools.backup.importers.TeamImporter;
import com.opsgenie.tools.backup.importers.TeamRoutingRuleImporter;
import com.opsgenie.tools.backup.importers.UserForwardingImporter;
import com.opsgenie.tools.backup.importers.UserImporter;
import com.opsgenie.tools.backup.importers.UserNotificationImporter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * This is base importer class. It takes {@link BackupProperties} class and {@link ImportConfig}
 * class inorder to set import settings.
 *
 * @author Mehmet Mustafa Demir
 */
public class Importer extends BaseBackup {
    private static List<ImporterInterface> importers;
    private final Logger logger = LogManager.getLogger(Importer.class);
    private ImportConfig config;

    public Importer(BackupProperties backupProperties, ImportConfig config) throws FileNotFoundException, UnsupportedEncodingException, GitAPIException {
        super(backupProperties);
        if (config == null) {
            logger.warn("Config object is null.");
            logger.warn("Default Import configs will be used.");
            this.config = new ImportConfig();
        } else {
            this.config = config;
        }
    }

    public Importer(BackupProperties backupProperties) throws FileNotFoundException, UnsupportedEncodingException, GitAPIException {
        super(backupProperties);
        logger.warn("Default Import configs will be used.");
        config = new ImportConfig();
    }

    protected void init() {
        String rootPath = getBackupProperties().getPath() + "/OpsGenieBackups";
        File backupRootFile = new File(rootPath);
        if (!backupRootFile.exists()) {
            RuntimeException e = new RuntimeException(rootPath + " direcotry is not exist");
            logger.error(rootPath + " direcotry is not exist", e);
            throw e;
        } else if (!backupRootFile.isDirectory()) {
            RuntimeException e = new RuntimeException(rootPath + " is not a directory!");
            logger.error(rootPath + " is not a directory!", e);
            throw e;
        }

        OpsGenieClient opsGenieClient = new OpsGenieClient();
        opsGenieClient.setApiKey(getBackupProperties().getApiKey());
        initializeImporters(rootPath, opsGenieClient);
    }

    private void initializeImporters(String rootPath, OpsGenieClient opsGenieClient) {
        importers = new ArrayList<ImporterInterface>();
        if (config.isAddNewHeartbeats() || config.isUpdateExistHeartbeats())
            importers.add(new HeartbeatImporter(opsGenieClient, rootPath, config.isAddNewHeartbeats(), config.isUpdateExistEscalations()));

        if (config.isAddNewUsers() || config.isUpdateExistUsers())
            importers.add(new UserImporter(opsGenieClient, rootPath, config.isAddNewUsers(), config.isUpdateExistUsers()));

        if (config.isAddNewTeams() || config.isUpdateExistTeams())
            importers.add(new TeamImporter(opsGenieClient, rootPath, config.isAddNewTeams(), config.isUpdateExistTeams()));

        if (config.isAddNewGroups() || config.isUpdateExistGroups())
            importers.add(new GroupImporter(opsGenieClient, rootPath, config.isAddNewGroups(), config.isUpdateExistGroups()));

        if (config.isAddNewSchedules() || config.isUpdateExistSchedules())
            importers.add(new ScheduleImporter(opsGenieClient, rootPath, config.isAddNewSchedules(), config.isUpdateExistSchedules()));

        if (config.isAddNewEscalations() || config.isUpdateExistEscalations())
            importers.add(new EscalationImporter(opsGenieClient, rootPath, config.isAddNewEscalations(), config.isUpdateExistEscalations()));

        if (config.isAddNewNotifications() || config.isUpdateExistNotifications())
            importers.add(new UserNotificationImporter(opsGenieClient, rootPath, config.isAddNewNotifications(), config.isUpdateExistNotifications()));

        if (config.isAddNewTeamRoutingRules() || config.isUpdateExistTeamRoutingRules())
            importers.add(new TeamRoutingRuleImporter(opsGenieClient, rootPath, config.isAddNewTeamRoutingRules(), config.isUpdateExistTeamRoutingRules()));

        if (config.isAddNewUserForwarding() || config.isUpdateExistUserForwarding())
            importers.add(new UserForwardingImporter(opsGenieClient, rootPath, config.isAddNewUserForwarding(), config.isUpdateExistUserForwarding()));

        if (config.isAddNewScheduleOverrides() || config.isUpdateExistScheduleOverrides())
            importers.add(new ScheduleOverrideImporter(opsGenieClient, rootPath, config.isAddNewScheduleOverrides(), config.isUpdateExistScheduleOverrides()));
    }

    /**
     * This is main restore(import) method. This method import opsgenie configuration from local
     * folder or remote git. If git is enabled from BackupProperties parameters it will import those
     * configurations from remote git.
     */

    public void restore() throws GitAPIException {
        if (getBackupProperties().isGitEnabled()) {
            cloneGit(getBackupProperties());
        }

        init();

        logger.info("Import operation started!");
        for (ImporterInterface importer : importers) {
            try {
                importer.restore();
            } catch (RestoreException e) {
                logger.error("Error at restoring.", e);
            }
        }
        logger.info("Import operation finished!");
    }

    public ImportConfig getConfig() {
        return config;
    }

    public Importer setConfig(ImportConfig config) {
        this.config = config;
        return this;
    }
}
