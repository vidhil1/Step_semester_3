public class MobileApp
        implements RemoteControllable {

    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public String connect(String appId) {

        return appName
                + " connected to "
                + appId;
    }
}
