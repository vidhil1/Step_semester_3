public class BusRoute implements Comparable<BusRoute> {

    private String routeCode;
    private String routeName;
    private int priority;

    public BusRoute(String routeCode,
                    String routeName,
                    int priority) {

        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode,
                    String routeName) {

        this(routeCode, routeName, 5);
    }

    public String getRouteCode() {
        return routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BusRoute other) {

        if (other == null) {
            return 1;
        }

        // Lower priority number comes first
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }

        // Route name comes next, ignoring case
        int nameResult =
                this.routeName.compareToIgnoreCase(other.routeName);

        if (nameResult != 0) {
            return nameResult;
        }

        // Route code is the final tie-breaker, ignoring case
        return this.routeCode.compareToIgnoreCase(other.routeCode);
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {

        if (routes == null) {
            return new BusRoute[0];
        }

        BusRoute[] result = new BusRoute[routes.length];

        for (int i = 0; i < routes.length; i++) {
            result[i] = routes[i];
        }

        // Stable insertion sort
        for (int i = 1; i < result.length; i++) {

            BusRoute current = result[i];
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
