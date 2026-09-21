public class ProductInventoryParser {

    public static void parseInventoryRecord(
            String csvLine) {

        String[] fields =
                csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0];
        String sku = fields[1];
        String quantity = fields[2];

        System.out.println(
                "Product: "
                + product
                + " | SKU: "
                + sku
                + " | Qty: "
                + quantity
        );
    }

    public static void main(String[] args) {

        String record1 =
                "Wireless Mouse,WM-2201,150";

        String record2 =
                "Wireless Mouse,150";

        parseInventoryRecord(record1);
        parseInventoryRecord(record2);
    }
}
