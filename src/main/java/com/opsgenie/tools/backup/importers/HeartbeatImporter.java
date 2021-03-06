package com.opsgenie.tools.backup.importers;

import com.ifountain.opsgenie.client.OpsGenieClient;
import com.ifountain.opsgenie.client.OpsGenieClientException;
import com.ifountain.opsgenie.client.model.beans.Heartbeat;
import com.ifountain.opsgenie.client.model.customer.AddHeartbeatRequest;
import com.ifountain.opsgenie.client.model.customer.ListHeartbeatsRequest;
import com.ifountain.opsgenie.client.model.customer.UpdateHeartbeatRequest;
import com.opsgenie.tools.backup.BackupUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * This class imports Heartbeats from local directory called heartbeats to Opsgenie account.
 *
 * @author Mehmet Mustafa Demir
 */
public class HeartbeatImporter extends BaseImporter<Heartbeat> {
    public HeartbeatImporter(OpsGenieClient opsGenieClient, String backupRootDirectory, boolean addEntity, boolean updateEntitiy) {
        super(opsGenieClient, backupRootDirectory, addEntity, updateEntitiy);
    }

    @Override
    protected BeanStatus checkEntities(Heartbeat oldEntity, Heartbeat currentEntity) {

        if (oldEntity.getName().equals(currentEntity.getName())) {
            return isSame(oldEntity, currentEntity) ? BeanStatus.NOT_CHANGED : BeanStatus.MODIFIED;
        }

        return BeanStatus.NOT_EXIST;
    }

    @Override
    protected Heartbeat getBean() throws IOException, ParseException {
        return new Heartbeat();
    }

    @Override
    protected String getImportDirectoryName() {
        return "heartbeats";
    }

    @Override
    protected void addBean(Heartbeat bean) throws ParseException, OpsGenieClientException, IOException {
        AddHeartbeatRequest request = new AddHeartbeatRequest();
        request.setName(bean.getName());
        if (BackupUtils.checkValidString(bean.getDescription()))
            request.setDescription(bean.getDescription());
        request.setEnabled(bean.isEnabled());
        request.setInterval(bean.getInterval());
        request.setIntervalUnit(bean.getIntervalUnit());
        getOpsGenieClient().addHeartbeat(request);
    }

    @Override
    protected void updateBean(Heartbeat bean) throws ParseException, OpsGenieClientException, IOException {
        UpdateHeartbeatRequest request = new UpdateHeartbeatRequest();
        request.setName(bean.getName());
        if (BackupUtils.checkValidString(bean.getDescription()))
            request.setDescription(bean.getDescription());
        request.setEnabled(bean.isEnabled());
        request.setInterval(bean.getInterval());
        request.setIntervalUnit(bean.getIntervalUnit());
        getOpsGenieClient().updateHeartbeat(request);
    }

    @Override
    protected List<Heartbeat> retrieveEntities() throws ParseException, OpsGenieClientException, IOException {
        ListHeartbeatsRequest request = new ListHeartbeatsRequest();
        return getOpsGenieClient().listHeartbeats(request).getHeartbeats();
    }

    @Override
    protected String getEntityIdentifierName(Heartbeat entitiy) {
        return "Heartbeat " + entitiy.getName();
    }
}
