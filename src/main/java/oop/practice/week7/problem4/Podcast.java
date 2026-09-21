public class Podcast implements Playable {

    private String showName;
    private int episodeNumber;

    public Podcast(String showName, int episodeNumber) {
        this.showName = showName;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String play() {
        return "Streaming episode "
                + episodeNumber
                + " of "
                + showName;
    }

    @Override
    public String play(int fromSecond) {
        int minutes = fromSecond / 60;
        int seconds = fromSecond % 60;

        return "Streaming episode "
                + episodeNumber
                + " of "
                + showName
                + " from "
                + minutes + ":"
                + String.format("%02d", seconds);
    }

    @Override
    public String pause() {
        return "Paused episode "
                + episodeNumber
                + " of "
                + showName;
    }
}
