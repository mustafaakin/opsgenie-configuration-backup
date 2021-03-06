package com.opsgenie.tools.backup;

/**
 * Config parameters for import procedure.
 *
 * @author Mehmet Mustafa Demir
 */
public class ImportConfig {
    private boolean addNewHeartbeats = true, updateExistHeartbeats = true;

    private boolean addNewUsers = true, updateExistUsers = true;

    private boolean addNewGroups = true, updateExistGroups = true;

    private boolean addNewTeams = true, updateExistTeams = true;

    private boolean addNewSchedules = true, updateExistSchedules = true;

    private boolean addNewEscalations = true, updateExistEscalations = true;

    private boolean addNewNotifications = true, updateExistNotifications = true;

    private boolean addNewTeamRoutingRules = true, updateExistTeamRoutingRules = true;

    private boolean addNewUserForwarding = true, updateExistUserForwarding = true;

    private boolean addNewScheduleOverrides = true, updateExistScheduleOverrides = true;


    public void setAllFalse() {
        addNewHeartbeats = false;
        updateExistHeartbeats = false;
        addNewUsers = false;
        updateExistUsers = false;
        addNewGroups = false;
        updateExistGroups = false;
        addNewTeams = false;
        updateExistTeams = false;
        addNewSchedules = false;
        updateExistSchedules = false;
        addNewEscalations = false;
        updateExistEscalations = false;
        addNewNotifications = false;
        updateExistNotifications = false;
        addNewTeamRoutingRules = false;
        updateExistTeamRoutingRules = false;
        addNewUserForwarding = false;
        updateExistUserForwarding = false;
        addNewScheduleOverrides = false;
        updateExistScheduleOverrides = false;
    }

    public boolean isAddNewHeartbeats() {
        return addNewHeartbeats;
    }

    public ImportConfig setAddNewHeartbeats(boolean addNewHeartbeats) {
        this.addNewHeartbeats = addNewHeartbeats;
        return this;
    }

    public boolean isUpdateExistHeartbeats() {
        return updateExistHeartbeats;
    }

    public ImportConfig setUpdateExistHeartbeats(boolean updateExistHeartbeats) {
        this.updateExistHeartbeats = updateExistHeartbeats;
        return this;
    }

    public boolean isAddNewUsers() {
        return addNewUsers;
    }

    public ImportConfig setAddNewUsers(boolean addNewUsers) {
        this.addNewUsers = addNewUsers;
        return this;
    }

    public boolean isUpdateExistUsers() {
        return updateExistUsers;
    }

    public ImportConfig setUpdateExistUsers(boolean updateExistUsers) {
        this.updateExistUsers = updateExistUsers;
        return this;
    }

    public boolean isAddNewGroups() {
        return addNewGroups;
    }

    public ImportConfig setAddNewGroups(boolean addNewGroups) {
        this.addNewGroups = addNewGroups;
        return this;
    }

    public boolean isUpdateExistGroups() {
        return updateExistGroups;
    }

    public ImportConfig setUpdateExistGroups(boolean updateExistGroups) {
        this.updateExistGroups = updateExistGroups;
        return this;
    }

    public boolean isAddNewTeams() {
        return addNewTeams;
    }

    public ImportConfig setAddNewTeams(boolean addNewTeams) {
        this.addNewTeams = addNewTeams;
        return this;
    }

    public boolean isUpdateExistTeams() {
        return updateExistTeams;
    }

    public ImportConfig setUpdateExistTeams(boolean updateExistTeams) {
        this.updateExistTeams = updateExistTeams;
        return this;
    }

    public boolean isAddNewSchedules() {
        return addNewSchedules;
    }

    public ImportConfig setAddNewSchedules(boolean addNewSchedules) {
        this.addNewSchedules = addNewSchedules;
        return this;
    }

    public boolean isUpdateExistSchedules() {
        return updateExistSchedules;
    }

    public ImportConfig setUpdateExistSchedules(boolean updateExistSchedules) {
        this.updateExistSchedules = updateExistSchedules;
        return this;
    }

    public boolean isAddNewEscalations() {
        return addNewEscalations;
    }

    public ImportConfig setAddNewEscalations(boolean addNewEscalations) {
        this.addNewEscalations = addNewEscalations;
        return this;
    }

    public boolean isUpdateExistEscalations() {
        return updateExistEscalations;
    }

    public ImportConfig setUpdateExistEscalations(boolean updateExistEscalations) {
        this.updateExistEscalations = updateExistEscalations;
        return this;
    }

    public boolean isAddNewNotifications() {
        return addNewNotifications;
    }

    public ImportConfig setAddNewNotifications(boolean addNewNotifications) {
        this.addNewNotifications = addNewNotifications;
        return this;
    }

    public boolean isUpdateExistNotifications() {
        return updateExistNotifications;
    }

    public ImportConfig setUpdateExistNotifications(boolean updateExistNotifications) {
        this.updateExistNotifications = updateExistNotifications;
        return this;
    }

    public boolean isAddNewTeamRoutingRules() {
        return addNewTeamRoutingRules;
    }

    public ImportConfig setAddNewTeamRoutingRules(boolean addNewTeamRoutingRules) {
        this.addNewTeamRoutingRules = addNewTeamRoutingRules;
        return this;
    }

    public boolean isUpdateExistTeamRoutingRules() {
        return updateExistTeamRoutingRules;
    }

    public ImportConfig setUpdateExistTeamRoutingRules(boolean updateExistTeamRoutingRules) {
        this.updateExistTeamRoutingRules = updateExistTeamRoutingRules;
        return this;
    }

    public boolean isAddNewUserForwarding() {
        return addNewUserForwarding;
    }

    public ImportConfig setAddNewUserForwarding(boolean addNewUserForwarding) {
        this.addNewUserForwarding = addNewUserForwarding;
        return this;
    }

    public boolean isUpdateExistUserForwarding() {
        return updateExistUserForwarding;
    }

    public ImportConfig setUpdateExistUserForwarding(boolean updateExistUserForwarding) {
        this.updateExistUserForwarding = updateExistUserForwarding;
        return this;
    }

    public boolean isAddNewScheduleOverrides() {
        return addNewScheduleOverrides;
    }

    public ImportConfig setAddNewScheduleOverrides(boolean addNewScheduleOverrides) {
        this.addNewScheduleOverrides = addNewScheduleOverrides;
        return this;
    }

    public boolean isUpdateExistScheduleOverrides() {
        return updateExistScheduleOverrides;
    }

    public ImportConfig setUpdateExistScheduleOverrides(boolean updateExistScheduleOverrides) {
        this.updateExistScheduleOverrides = updateExistScheduleOverrides;
        return this;
    }
}
