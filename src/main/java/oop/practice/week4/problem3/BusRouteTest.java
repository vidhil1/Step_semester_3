public class BusRouteTest {

    public static void main(String[] args) {

        BusRoute[] routes = {
                new BusRoute(
                        "RT205L",
                        "Airport Express",
                        3
                ),

                new BusRoute(
                        "rt201j",
                        "City Central",
                        4
                ),

                new BusRoute(
                        "RT299T",
                        "Night Service"
                )
        };

        BusRoute[] ranked =
                BusRoute.rankRoutes(routes);

        for (BusRoute route : ranked) {
            System.out.println(route.getRouteCode());
        }
    }
}
