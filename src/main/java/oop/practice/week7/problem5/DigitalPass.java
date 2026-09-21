public class DigitalPass implements Renewable {

    private String resourceName;

    public DigitalPass(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String renew() {
        return resourceName + " renewed";
    }
}
