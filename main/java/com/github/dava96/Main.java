package com.github.dava96;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    static String commandPrefix = "!"; // default prefix
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken("NDU5NTAzNzM3MjU0MzEzOTg0.XPOi5Q.lkapySgnPIqJZIGawu214SNOr6w").login().join();
        api.updateActivity(commandPrefix + "help");
        System.out.println("Logged in!");

        api.addMessageCreateListener(event -> {
            if(event.getMessageContent().startsWith(commandPrefix + "setprefix")) {
                    CommandPrefix prefix = new CommandPrefix(event.getMessageContent());
                    event.getChannel().sendMessage(prefix.getDescription());
                    event.getChannel().sendMessage("The prefix is set to " + prefix.getCommandPrefix());

                    commandPrefix = prefix.getCommandPrefix();
                    event.getApi().updateActivity(prefix.getCommandPrefix()+ "help");
                }

        });

        api.addMessageCreateListener(event -> {

            if(event.getMessageContent().toLowerCase().startsWith(commandPrefix + "search")) {
                QuerySearch search = new QuerySearch(event.getMessageContent());
                event.getChannel().sendMessage(search.checkCommand());

            }

        });


        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().contains(commandPrefix + "setgame")) {
                SetActivityCommand activity = new SetActivityCommand(event.getMessageContent());
                event.getChannel().sendMessage(activity.getDescription());
                event.getApi().updateActivity(activity.getActivityName());
                event.getChannel().sendMessage("The activity is set to: " + activity.getActivityName());
            }

        });

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().toLowerCase().startsWith(commandPrefix + "help")) {
                HelpCommand help = new HelpCommand(event.getMessageContent());
                event.getChannel().sendMessage(help.toString());
            }

        });

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

    }

}

