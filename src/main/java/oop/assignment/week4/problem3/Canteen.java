public class Canteen implements Comparable<Canteen> {

    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode,
                   String canteenName,
                   int trustScore) {

        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode,
                   String canteenName) {

        this(canteenCode, canteenName, 3);
    }

    public String getCanteenCode() {
        return canteenCode;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public int getTrustScore() {
        return trustScore;
    }

    @Override
    public int compareTo(Canteen other) {

        // Higher trust score comes first
        if (this.trustScore != other.trustScore) {
            return Integer.compare(
                    other.trustScore,
                    this.trustScore
            );
        }

        // Code is the first tie-breaker.
        // Ignore case only for comparison.
        int codeResult =
                this.canteenCode.compareToIgnoreCase(
                        other.canteenCode
                );

        if (codeResult != 0) {
            return codeResult;
        }

        // Final tie-breaker: name length
        return Integer.compare(
                this.canteenName.length(),
                other.canteenName.length()
        );
    }

    public static Canteen[] rankCanteens(
            Canteen[] canteens) {

        if (canteens == null) {
            return new Canteen[0];
        }

        Canteen[] result =
                new Canteen[canteens.length];

        for (int i = 0; i < canteens.length; i++) {
            result[i] = canteens[i];
        }

        // Stable insertion sort
        for (int i = 1; i < result.length; i++) {

            Canteen current = result[i];
            int j = i - 1;

            while (j >= 0
                    && result[j].compareTo(current) > 0) {

                result[j + 1] = result[j];
                j--;
            }

            result[j + 1] = current;
        }

        return result;
    }
}
