public class AlertNetwork {

    public static void broadcastAll(Alertable[] devices,
                                    String message) {

        for (Alertable device : devices) {
            System.out.println(device.sendAlert(message));
        }
    }

    public static String getZoneIfMotionSensor(Alertable a) {

        if (a instanceof MotionSensor) {

            MotionSensor sensor = (MotionSensor) a;

            return sensor.getZoneName();
        }

        return "Not a motion sensor";
    }
}
