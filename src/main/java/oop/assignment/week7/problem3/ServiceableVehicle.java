public abstract class ServiceableVehicle {

    private double mileage;

    public abstract String performMaintenance();

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double km) {

        if (km < 0) {
            throw new IllegalArgumentException(
                    "Mileage cannot be negative"
            );
        }

        mileage = mileage + km;
    }
}
