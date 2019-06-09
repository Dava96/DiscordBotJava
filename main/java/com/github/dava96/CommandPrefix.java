package com.github.dava96;

public class CommandPrefix {
    private String commandName = "setprefix";
    private String messagePrefix;
    private String[] prefixArray;
    private String description = "Setprefix allows the user to set the command prefix to anything they want";

    public CommandPrefix(String commandPrefix) {
        this.messagePrefix = commandPrefix;
        this.prefixArray = messagePrefix.split(" ");
        setCommandPrefix();
        this.commandName = prefixArray[0];
    }

    public CommandPrefix() {

    }

    public void setCommandPrefix() {
        this.messagePrefix = prefixArray[1];
    }

    public String getCommandPrefix() {
        return this.messagePrefix;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCommandName() {
        return this.commandName;
    }

}
