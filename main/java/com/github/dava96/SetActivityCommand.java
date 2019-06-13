package com.github.dava96;

public class SetActivityCommand {

    private String commandName = "setgame";
    private String activityName;
    private String[] activityArray;
    private String description = "Setgame allows the user to set what the bot's activity is";

    public SetActivityCommand(String commandArguments) {
        activityArray = commandArguments.split(" ");
        this.commandName = activityArray[0];
        this.activityName = "";
        parseActivity(activityArray);
    }

    public SetActivityCommand() {

    }


    public void parseActivity(String[] activityArray) {
        String space = " ";
        String activity = "";
        for (int i = 1; i < activityArray.length; i++) {
                activity += activityArray[i];
                activity += space;
        }
        setActivityName(activity.trim());
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String setName) {
        this.activityName = setName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCommandName() {
        return this.commandName;
    }

}

