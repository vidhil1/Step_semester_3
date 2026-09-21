public class DataExport {

    public static void exportAll(
            Exportable[] items) {

        for (Exportable item : items) {
            System.out.println(
                    item.exportData()
            );
        }
    }

    public static int getTotalExports() {
        return ExportCounter.getTotalExports();
    }

    public static void main(String[] args) {

        ReportGenerator r =
                new ReportGenerator("Sales Q1");

        UserProfile u =
                new UserProfile("jane_doe");

        Exportable ref = r;

        exportAll(
                new Exportable[]{
                        ref,
                        u
                }
        );

        System.out.println(
                "Total Exports: "
                + getTotalExports()
        );
    }
}
