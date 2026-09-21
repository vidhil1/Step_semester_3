public class ConnectedHomeControlPanel {

    public static void connectAll(
            RemoteControllable[] items,
            String appId) {

        for (RemoteControllable item : items) {

            System.out.println(
                    item.connect(appId)
            );
        }
    }

    public static double getConsumptionIfTrackable(
            HomeDevice d) {

        if (d instanceof EnergyTrackable) {

            EnergyTrackable device =
                    (EnergyTrackable) d;

            return device.getConsumptionWatts();
        }

        return 0.0;
    }

    public static void main(String[] args) {

        WashingMachine wm =
                new WashingMachine(500.0);

        System.out.println(
                wm.activate()
        );

        System.out.println(
                wm.connect("HomeConnect")
        );

        Refrigerator fridge =
                new Refrigerator(150.0);

        System.out.println(
                getConsumptionIfTrackable(fridge)
        );

        MobileApp app =
                new MobileApp("HomeConnect App");

        System.out.println(
                app.connect("HomeConnect")
        );

        HomeDevice ref = wm;

        System.out.println(
                getConsumptionIfTrackable(ref)
        );

        connectAll(
                new RemoteControllable[]{
                        wm,
                        app
                },
                "HomeConnect"
        );
    }
}
