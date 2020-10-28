package dev.alexzvn.among.game;

public class GameConfig {

    protected int imposter = 1; // number of imposter min: 1, max:3

    protected boolean visualize = true;
    
    protected int killCooldown = 45; //sec

    protected int emergencyMeetings = 1; //times

    protected int emergencyCooldown = 15; //sec

    protected int discussionTime = 15; //sec

    protected int votingTime = 120; //sec

    protected int longTasks  = 1;

    protected int commonTasks = 1;

    protected int shortTasks = 2;

    public void setNumberOfImposter(int number) {
        imposter = (0 < number || number <= 3) ? number : imposter;
    }

    public void setVisualizeTask(Boolean flag) {
        visualize = flag;
    }

    public void setKillCooldown(int second) {
        killCooldown = second >= 0 ? second : killCooldown;
    }

    public void setEmergencyMeetings(int times) {
        emergencyMeetings = times >= 0 ? times : emergencyMeetings;
    }

    public void setEmergencyCooldown(int second) {
        emergencyCooldown = second >= 0 ? second : emergencyCooldown;
    }

    public void setDiscussionTime(int second) {
        discussionTime = second >= 0 ? second : discussionTime;
    }

    public void setVotingTime(int second) {
        votingTime = second >= 0 ? second : votingTime;
    }

    public void setLongTasks(int number) {
        longTasks = number >= 0 ? number : longTasks;
    }

    public void setShortTasks(int number) {
        shortTasks = number >= 0 ? number : shortTasks;
    }

    public void setCommonTasks(int number) {
        commonTasks = number >= 0 ? number : commonTasks;
    }

    public int getTotalTask() {
        return longTasks + shortTasks + commonTasks;
    }

    public boolean canVizualizeTask() {
        return visualize;
    }

    public boolean canStart(int numberOfPlayer) {
        if (numberOfPlayer < 4) {
            return false;
        }

        return true;
    }

    public int getMaximumImposters(int numberOfPlayer) {

        if (numberOfPlayer >= 8) return imposter;

        if (numberOfPlayer >= 6) return (imposter <= 2) ? imposter : 2;

        return 1;
    }

    public int getNumberOfImposter() {
        return imposter;
    }

    public int getKillCoolDown() {
        return killCooldown;
    }

    public int getEmergencyMeetings() {
        return emergencyMeetings;
    }

    public int getCommonTasks() {
        return commonTasks;
    }

    public int getShortTasks() {
        return shortTasks;
    }

    public int getLongTasks() {
        return longTasks;
    }
}
