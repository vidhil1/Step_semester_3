public abstract class LibraryItem {

    private static int itemCounter = 1000;

    private final String itemId;

    public LibraryItem() {
        itemCounter++;
        itemId = "LIB-" + itemCounter;
    }

    public String getItemId() {
        return itemId;
    }

    public abstract int getLoanPeriodDays();
}
