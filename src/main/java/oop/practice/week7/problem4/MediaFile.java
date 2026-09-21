public abstract class MediaFile {

    private static int nextId = 1001;

    private final String fileId;

    public MediaFile(String prefix) {
        this.fileId = prefix + nextId++;
    }

    public String getFileId() {
        return fileId;
    }

    public abstract String getFormatInfo();
}
