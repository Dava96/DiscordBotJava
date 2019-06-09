package com.github.dava96;

import java.util.ArrayList;

public class HelpCommand {
    private CommandPrefix commandPrefix;
    private SetActivityCommand setActivityCommand;
    private QuerySearch querySearch;

    //classes

    private String helpCommand; // the name of the command
    private String[] queriedNameArray; //

    private ArrayList<String> arrayOfCommands;

    public HelpCommand(String commandName) {
        queriedNameArray = commandName.split(" ");
        this.helpCommand = queriedNameArray[0]; // sets this to help

        this.arrayOfCommands = new ArrayList<String>();

        this.commandPrefix = new CommandPrefix();
        this.setActivityCommand = new SetActivityCommand();
        this.querySearch = new QuerySearch();

        getCommandInfo();
    }

    public void getCommandInfo() {
        this.arrayOfCommands.add("Command name: " + this.setActivityCommand.getCommandName());
        this.arrayOfCommands.add("Description: " + this.setActivityCommand.getDescription());

        this.arrayOfCommands.add("Command name: " + this.commandPrefix.getCommandName());
        this.arrayOfCommands.add("Description: " + this.commandPrefix.getDescription());

        this.arrayOfCommands.add("Command name: " + this.querySearch.getCommandName());
        this.arrayOfCommands.add("Description: " + this.querySearch.getDescription());

  }

  @Override
    public String toString() {
        return "List of Commands: " + arrayOfCommands.toString();
  }

}
