import java.sql.*;
import java.util.Scanner;

public class Insertions {
    public static void main(String[] args) {

    }

    String url = "jdbc:mysql://localhost/";
    String dbName = "storedb";  //dunno the name of the database, change when find out
    String fullURL = url + dbName;
    String userName = "root";   // default
    String password = "";       // default




    public void insertProducts() {

        String ProductName;

        Scanner prodScan = new Scanner(System.in);
        System.out.println("Enter Product Name");

        ProductName = prodScan.nextLine();

        String productInsert = "INSERT INTO storedb.Products VALUES (null, ?)";

        try (Connection connection = DriverManager.getConnection(fullURL, userName, password);
             PreparedStatement productStatement = connection.prepareStatement( productInsert );
        )
        {
            productStatement.setString(1, ProductName);

        }catch (SQLException ex) {
            System.out.println("Failed to connect to database - check MySQL is running and that you are using the correct database details");
        }
    }

    public void insertVendors() {

        String VendorName;

        Scanner vendScan = new Scanner(System.in);
        System.out.println("Enter Vendor Name");

        VendorName = vendScan.nextLine();

        String vendorInsert = "INSERT INTO storedb.Vendors VALUES (null, ?)";

        try (Connection connection = DriverManager.getConnection(fullURL, userName, password);
             PreparedStatement productStatement = connection.prepareStatement( vendorInsert );
        )
        {
            productStatement.setString(1, VendorName);

        }catch (SQLException ex) {
            System.out.println("Failed to connect to database - check MySQL is running and that you are using the correct database details");
        }


    }

    public void insertProductsAndVendors() {

        int VendId;
        int ProdId;
        double price;
        int quantity;


        Scanner names = new Scanner(System.in);
        System.out.println("Enter Product ID");
        ProdId = names.nextInt();

        System.out.println("Enter Vendor ID");
        VendId = names.nextInt();

        System.out.println("Enter Products Price (10.00 format)");
        price = names.nextDouble();

        System.out.println("Enter Quantity Stocked");
        quantity = names.nextInt();



        String productsVendorsInsert = "INSERT INTO storedb.ProductsVendors VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(fullURL, userName, password);
             PreparedStatement insertStatement = connection.prepareStatement( productsVendorsInsert );
        )
        {
            insertStatement.setInt(0, ProdId);
            insertStatement.setInt(1, VendId);
            insertStatement.setDouble(2, price);
            insertStatement.setInt(3, quantity);

        }catch (SQLException ex) {
            System.out.println("Failed to connect to database - check MySQL is running and that you are using the correct database details");
        }
    }
}