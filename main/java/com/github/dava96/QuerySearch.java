package com.github.dava96;

public class QuerySearch {

    private String commandName = "search";
    private String description = "Searches Youtube, Spotify, Google, Imbd and Twitch. Example: 'search youtube wolf alice'";
    private String[] queryArray;
    private String searchTerm;

    public QuerySearch(String query) {
        this.queryArray = query.split(" ");
        this.commandName = this.queryArray[0];

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
        if (this.queryArray[1].contains("youtube")) {
            return searchYoutube();
        } else if (this.queryArray[1].contains("spotify")) {
            return searchSpotify();
        } else if (this.queryArray[1].contains("google")) {
           return searchGoogle();
        } else if (this.queryArray[1].contains("imbd")) {
            return searchImbd();
        } else if (this.queryArray[1].contains(("twitchgame"))) {
            return searchTwitchGame();
        } else if (this.queryArray[1].contains("twitch")) {
            return searchTwitch();
        } else if (this.queryArray[1].contains("reddit")) {
        	return searchReddit();
		}
        return null;
    }

    public String arraySplitter() {
        String query = "";
        for (int i = 2; i < this.queryArray.length; i++) {

            query += this.queryArray[i];
            query += " ";
            this.searchTerm = query.trim();
        }
        return this.searchTerm;
    }

    public String searchYoutube() {
        String link = "https://www.youtube.com/results?search_query=";
        this.searchTerm = this.searchTerm.replaceAll("( )", "+");
        return link + this.searchTerm;
    }

    public String searchSpotify() {
        String link = "https://open.spotify.com/search/results/";
        this.searchTerm = this.searchTerm.replaceAll("( )", "%20");
        return link + this.searchTerm;
    }

    public String searchGoogle() {
        String link = "https://www.google.com/search?rlz=1C1GCEA_enGB850GB850&ei=1mP8XLqSG5yG1fAP-4OOqAw&q=";
        this.searchTerm = this.searchTerm.replaceAll("( )", "+");
        return link + this.searchTerm;
    }

    public String searchImbd() {
        String link = "https://www.imdb.com/find?ref_=nv_sr_fn&q=";
        this.searchTerm = this.searchTerm.replaceAll("( )", "+");
        return link + this.searchTerm;
    }

    public String searchTwitchGame() {
        String link = "https://www.twitch.tv/directory/game/";
        this.searchTerm = this.searchTerm.replaceAll("( )", "%20");
        return link + this.searchTerm;
    }

    public String searchTwitch() {
        String link = "https://www.twitch.tv/"; // twitch channels names don't have spaces in them
        return link + this.searchTerm;
    }

    public String searchReddit() {
    	String link = "https://www.reddit.com/search/?q=";
    	return link + this.searchTerm;
	}


}
