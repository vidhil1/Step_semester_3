public class PatientVitals {

    private double[] readings;
    private int count;

    public PatientVitals(double[] initialReadings) {

        readings = new double[500];
        count = 0;

        for (double reading : initialReadings) {
            recordReading(reading);
        }
    }

    public void recordReading(double reading) {

        if (reading <= 0 || reading > 45) {
            return;
        }

        if (count < 500) {
            readings[count] = reading;
            count++;
        }
    }

    public double getAverage() {

        if (count == 0) {
            return 0;
        }

        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum = sum + readings[i];
        }

        return sum / count;
    }

    public double[] getAllReadings() {

        double[] result = new double[count];

        for (int i = 0; i < count; i++) {
            result[i] = readings[i];
        }

        return result;
    }
}
