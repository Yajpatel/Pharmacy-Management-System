package Pharmacy;

import java.util.*;
import java.sql.*;
import java.io.*;

public class PharmacyManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Medicine> medicineMap = new HashMap<>();
    static Connection con;

    public static void main(String[] args) throws Exception {
        String dburl = "jdbc:mysql://localhost:3306/medical";
        String dbuser = "root";
        String Pass = "";
        String driver = "com.mysql.jdbc.Driver";

        // default URL for Connection with database
        Class.forName(driver);
        con = DriverManager.getConnection(dburl, dbuser, Pass);

        // Check if it is connected with the database or not
        if (con != null) {
            System.out.println("connection successful");
        } else {
            System.out.println("connection failed");
        }

        // Method for adding data to HashMap
        HashArrayAdd();

        // Choices
        int choice;
        do {
            System.out.println("1.=>To Add Medicine");
            System.out.println("2.=>To Remove Medicine");
            System.out.println("3.=>To display Medicines Content");
            System.out.println("4.=>To Update Medicine Price");
            System.out.println("5.=>TO Update Medicine Quantity");
            System.out.println("6.=>To Update Expiry Date");
            System.out.println("7.=>To Search Medicine");
            System.out.println("8.=>To Buy Medicines  ---- && To generate Bill");
            // System.out.println("9.=>To Generate Bill");
            System.out.println("0.=><====To Exit====>");
            System.out.println("----------------------------------------------------------------");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    removeMedicine();
                    break;
                case 3:
                    displaymedicines();
                    break;
                case 4:
                    updateMedicinePrice();
                    break;
                case 5:
                    updateMedicinequantity();
                    break;
                case 6:
                    updateExpiryDate();
                    break;
                case 7:
                    searchMedicine();
                    break;
                case 8:
                    buyMedicine();
                    
                    // generatebill();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Select appropriate choice");
                    break;
            }
        } while(choice != 0);
    }

    static void HashArrayAdd() throws Exception {
        String s = "SELECT * FROM pharmacy";
        PreparedStatement pst = con.prepareStatement(s);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("sr_no");
            String name = rs.getString("name");
            String category = rs.getString("category");
            String expDate = rs.getString("exp_date");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");

            Medicine medicine = new Medicine(name, category, expDate, quantity, price);
            medicineMap.put(id, medicine);
        }
    }

    // Method to add medicine
    static void addMedicine() throws Exception {
        sc.nextLine();
        System.out.println("Enter the name of the medicine");
        String name = sc.nextLine();

        System.out.println("Enter the category of the medicine");
        String category = sc.nextLine();

        System.out.println("Enter the expiry date of the medicine");
        System.out.println("Enter the year in '2023' form");
        int year = sc.nextInt();
        System.out.println("Enter the month in '01' or '11' form");
        int month = sc.nextInt();
        System.out.println("Enter the date in '01' or '20' form");
        int day = sc.nextInt();

        System.out.println("Enter the quantity of the medicine ");
        int quantity = sc.nextInt();

        System.out.println("Enter the price of the medicine");
        double price = sc.nextDouble();

        String add = "insert into pharmacy (name, category, exp_date, quantity, price) values (?, ?, '" + year + "-" + month + "-" + day + "', ?, ?)";
        PreparedStatement pst = con.prepareStatement(add, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.setString(2, category);
        pst.setInt(3, quantity);
        pst.setDouble(4, price);
        pst.executeUpdate(); // Values added to the database

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            Medicine medicine = new Medicine(name, category, year + "-" + month + "-" + day, quantity, price);
            medicineMap.put(id, medicine);
        }

        System.out.println("Medicine added successfully");
        System.out.println("-----------------------------------------------------------");
    }

    // Method to remove medicine
    static void removeMedicine() throws Exception {
        System.out.println("Enter Medicine ID to remove Medicine");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            String sql = "delete from pharmacy where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

            medicineMap.remove(id);

            System.out.println("Medicine removed successfully");
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    // Method to display Medicines Available
    static void displaymedicines() {
        for (Map.Entry<Integer, Medicine> entry : medicineMap.entrySet()) {
            int id = entry.getKey();
            Medicine med = entry.getValue();
            System.out.println("ID: " + id);
            System.out.println("Name: " + med.getMed_name());
            System.out.println("Category: " + med.getCategory());
            System.out.println("Expiry Date: " + med.getExp_date());
            System.out.println("Quantity: " + med.getQuantity());
            System.out.println("Price: " + med.getPrice());
            System.out.println("-----------------------------------------");
        }
    }

    // Method to update Medicine price
    static void updateMedicinePrice() throws Exception {
        System.out.println("Enter ID of the medicine to update PRICE");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            System.out.println("Enter the new price:");
            double price = sc.nextDouble();

            String sql = "update pharmacy set price = ? where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.executeUpdate(); // Price updated in the database

            Medicine medicine = medicineMap.get(id);
            medicine.setPrice(price);
            System.out.println("Medicine price updated successfully.");
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    // Method to update Medicine Quantity
    static void updateMedicinequantity() throws Exception {
        System.out.println("Enter the ID of the medicine to update QUANTITY");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            System.out.println("Enter the new quantity:");
            int quantity = sc.nextInt();

            String sql = "update pharmacy set quantity = ? where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setInt(2, id);
            pst.executeUpdate();

            Medicine medicine = medicineMap.get(id);
            medicine.setQuantity(quantity);
            System.out.println("Medicine quantity updated successfully.");
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    // Method to update Expiry Date
    static void updateExpiryDate() throws Exception {
        System.out.println("Enter the ID of the medicine to update EXPIRY DATE");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            System.out.println("Enter the new expiry date (YYYY-MM-DD):");
            System.out.println("Enter the expiry date of the medicine");
            System.out.println("Enter the year in '2023' form");
            int year = sc.nextInt();
            System.out.println("Enter the month in '01' or '11' form");
            int month = sc.nextInt();
            System.out.println("Enter the date in '01' or '20' form");
            int day = sc.nextInt();

            String sql = "update pharmacy set exp_date = ? where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, year + "-" + month + "-" + day);
            pst.setInt(2, id);
            pst.executeUpdate();

            Medicine medicine = medicineMap.get(id);
            medicine.setExp_date(year + "-" + month + "-" + day);
            System.out.println("Medicine expiry date updated successfully");
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    static void searchMedicine() throws Exception {
        sc.nextLine();
        System.out.println("Enter the Name of the Medicine");
        String med = sc.nextLine();

        String sql = "select * from pharmacy where name = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, med);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            System.out.println("Not found");
        } else {
            do {
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Category: " + rs.getString(3));
                System.out.println("Expiry date: " + rs.getDate(4));
                System.out.println("Quantity: " + rs.getInt(5));
                System.out.println("Price: " + rs.getDouble(6));
                System.out.println("-------------------------------------");
            } while (rs.next());
        }
    }

    static StackDataStructure purchasedMedicines = new StackDataStructure(100);

    static void buyMedicine() throws Exception {
        sc.nextLine(); // Clear the scanner buffer
        System.out.println("Enter the ID of the medicine to buy:");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            Medicine medicine = medicineMap.get(id);

            System.out.println("Enter quantity to buy:");
            int buyQuantity = sc.nextInt();

            if (buyQuantity <= medicine.getQuantity()) {
                // Update the quantity in the database
                int newQuantity = medicine.getQuantity() - buyQuantity;
                String sql = "update pharmacy set quantity = ? where sr_no = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, newQuantity);
                pst.setInt(2, id);
                pst.executeUpdate();

                // Update the quantity in the HashMap
                medicine.setQuantity(newQuantity);

                // Add the purchased medicine to the stack for billing
                Medicine purchasedMed = new Medicine(medicine.getMed_name(), medicine.getCategory(), medicine.getExp_date(), buyQuantity, medicine.getPrice());
                purchasedMedicines.push(purchasedMed);

                System.out.println("Medicine purchased successfully");
                System.out.println("-------------------------------------------------------------");
                generatebill();
            } else {
                System.out.println("Insufficient stock. Available quantity: " + medicine.getQuantity());
            }
        } else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }


    static void generatebill()throws IOException {
        System.out.println("--------------Billling Centerr----------------");
        sc.nextLine();
        System.out.println("Enter Name of the Customer");
        String customername = sc.next();

        String customerphoneNumber = "";
        while (true) {
            System.out.println("Enter the 10-digit phone number of the customer:");
            customerphoneNumber = sc.next();
            if (customerphoneNumber.length() == 10) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit number.");
            }
        }

        System.out.println("Enter the email of the customer:");
        String customeremail = sc.nextLine();

        if (purchasedMedicines.isEmpty()) {
            System.out.println("No medicines purchased");
            return;
        }
    
        double totalAmount = 0;
        System.out.println("--------------------- Bill Generation--------------------------");

        File f=new File(customername+ ".txt");
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("Name:- "+customername);
        bw.newLine();
        bw.write("phone no. :- "+customerphoneNumber);
        bw.newLine();
        bw.write("e-mail ID :- "+customeremail);
        bw.newLine();
        bw.write("------------------------------------------------------------------------------------------------");
        bw.newLine();
        bw.write("--------------------MEDICINE DETAILS--------------------------");
        bw.newLine();

        while (!purchasedMedicines.isEmpty()) {
            Medicine med = purchasedMedicines.pop(); // Retrieves and removes the top of the stack
            double cost = med.getQuantity() * med.getPrice();
            totalAmount += cost;
            System.out.println("Medicine: " + med.getMed_name());
            System.out.println("Quantity: " + med.getQuantity());
            System.out.println("Price per unit: " + med.getPrice());
            System.out.println("Cost: " + cost);
            System.out.println("----------------------------------------------------");

            bw.write("Medicine: " + med.getMed_name() + "\n");
            bw.write("Quantity: " + med.getQuantity() + "\n");
            bw.write("Price per unit: " + med.getPrice() + "\n");
            bw.write("Cost: " + cost + "\n");
            bw.write("------------------------------------------------\n");
        

        bw.write("Total Amount: " + totalAmount + "\n");
        bw.write("-------------------------Thank You VIsit Again-----------------------------\n");
        bw.close();
        fw.close();

        System.out.println("Total Amount: " + totalAmount);
        System.out.println("------------------------------------------------------");
        }
    }
    
}
