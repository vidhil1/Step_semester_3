public class AudioFile extends MediaFile implements Playable {

    private String title;

    public AudioFile(String title) {
        super("MF-");
        this.title = title;
    }

    @Override
    public String play() {
        return "Playing audio: " + title;
    }

    @Override
    public String play(int fromSecond) {

        int minutes = fromSecond / 60;
        int seconds = fromSecond % 60;

        return "Playing audio: " + title
                + " from "
                + minutes + ":"
                + String.format("%02d", seconds);
    }

    @Override
    public String pause() {
        return "Paused audio: " + title;
    }

    @Override
    public String getFormatInfo() {
        return "Audio file, ID: " + getFileId();
    }
}
