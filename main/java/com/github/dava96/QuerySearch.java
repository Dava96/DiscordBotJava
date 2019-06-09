package com.github.dava96;

public class QuerySearch {

    private String commandName = "search";
    private String description = "Searches Youtube, Spotify, Google, Imbd and Twitch. Example: 'search youtube wolf alice'";
    private String[] queryArray;
    private String searchTerm;

    public QuerySearch(String query) {
        queryArray = query.split(" ");
        this.commandName = queryArray[0];

        arraySplitter();
        checkCommand();
    }

    public QuerySearch() {

    }

    public String getCommandName() {
        return this.commandName;
    }

    public String getDescription() {
        return this.description;
    }

    public String checkCommand() {
        if (queryArray[1].contains("youtube")) {
            return searchYoutube();
        } else if (queryArray[1].contains("spotify")) {
            return searchSpotify();
        } else if (queryArray[1].contains("google")) {
           return searchGoogle();
        } else if (queryArray[1].contains("imbd")) {
            return searchImbd();
        } else if (queryArray[1].contains(("twitchgame"))) {
            return searchTwitchGame();
        } else if (queryArray[1].contains("twitch")) {
            return searchTwitch();
        }

        return null;
    }

    public String arraySplitter() {
        String query = "";
        for (int i = 2; i < queryArray.length; i++) {

            query += queryArray[i];
            query += " ";
            this.searchTerm = query;
        }
        System.out.println(searchTerm);
        return searchTerm;
    }

    public String searchYoutube() {
        String link = "https://www.youtube.com/results?search_query=";
        searchTerm = searchTerm.replaceAll("( )", "+");
        return link + searchTerm;
    }

    public String searchSpotify() {
        String link = "https://open.spotify.com/search/results/";
        searchTerm = searchTerm.replaceAll("( )", "%20");
        return link + searchTerm;
    }

    public String searchGoogle() {
        String link = "https://www.google.com/search?rlz=1C1GCEA_enGB850GB850&ei=1mP8XLqSG5yG1fAP-4OOqAw&q=";
        searchTerm = searchTerm.replaceAll("( )", "+");
        return link + searchTerm;
    }

    public String searchImbd() {
        String link = "https://www.imdb.com/find?ref_=nv_sr_fn&q=";
        searchTerm = searchTerm.replaceAll("( )", "+");
        return link + searchTerm;
    }

    public String searchTwitchGame() {
        String link = "https://www.twitch.tv/directory/game/";
        searchTerm = searchTerm.replaceAll("( )", "%20");
        return link + searchTerm;
    }

    public String searchTwitch() {
        String link = "https://www.twitch.tv/";
        return link + searchTerm;
    }


}
