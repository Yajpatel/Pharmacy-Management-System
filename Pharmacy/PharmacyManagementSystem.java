package Pharmacy;

import java.util.*;
import java.sql.*;
import java.io.*;

public class PharmacyManagementSystem{
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Medicine> medicineMap = new HashMap<>();
    static ArrayList<Medicine> medicineList = new ArrayList<>();
    static Connection con;
    public static void main(String[] args)throws Exception {

        String dburl = "jdbc:mysql://localhost:3306/medical";
        String dbuser = "root";
        String Pass = "";
        String driver = "com.mysql.jdbc.Driver";
        
        //default URL for Connection with database
        Class.forName(driver);
        con = DriverManager.getConnection(dburl, dbuser, Pass);
        
        //to check if it is connected with database or not
        if(con != null){
            System.out.println("connection sucessfull");
        }
        else{
            System.out.println("connection failed");
        }

        //not working
        // String sql = "Create table if not exists Pharmacy(sr_no int primary key auto_increment,name varchar(30),category varchar(20),exp_date Date,quantity int,price decimal(10,2)";
        // Statement st = con.createStatement();
        // int r = st.executeUpdate(sql);

        
        //method for adding data to HashMap and Arraylist
        HashArrayAdd();
        //choices 
        int choice;
        do{
            System.out.println("1.=>To Add Medicine");
            System.out.println("2.=>To Remove Medicine");
            System.out.println("3.=>To display Medicines Content");
            System.out.println("4.=>To Update Medicine Price");
            System.out.println("5.=>TO Update Medicine Quantity");
            System.out.println("6.=>To Update Expiry Date");
            System.out.println("7.=>To Search Medicine");
            System.out.println("8.=>To Buy Medicines");
            System.out.println("9.=>To Generate Bill");;
            System.out.println("0.=><====To Exit====>");
            System.out.println("----------------------------------------------------------------");
            choice = sc.nextInt();
            switch(choice){
                case 1 :
                        addMedicine();
                    break;
                case 2 :
                        removeMedicine();
                    break;
                case 3 :
                        displaymedicines();
                    break;
                case 4 :
                        updateMedicinePrice();
                    break;
                case 5 :
                        updateMedicinequantity();
                    break;
                case 6 :
                        updateExpiryDate();
                break;
                case 7 : 
                        searchMedicine();
                    break;
                case 8 :
                        buyMedicine();
                    break;
                case 9 :
                        generatebill();
                    break;
                case 0 :
                        return;
                default : System.out.println("invalid choice Select appropriate choice");
                break;
            }
        }while(choice != 0);
    }

    static void HashArrayAdd()throws Exception{
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
            medicineList.add(medicine);
            
            // System.out.println(medicineMap);
            // System.out.println(medicineList);
        }
    }

    //Method to add medicine
    static void addMedicine()throws Exception{                
        sc.nextLine() ;
        System.out.println("Enter the name of the medicine");
        String name=sc.nextLine();

        System.out.println("Enter the category of the medicine");
        String category=sc.nextLine();

        System.out.println("Enter the expiry date of the medicine");
        System.out.println("enter the year in '2023' form");
        int year=sc.nextInt();
        System.out.println("enter the month in '01' or '11'  form");
        int month=sc.nextInt();
        System.out.println("enter the date in '01' or '20' form");
        int day=sc.nextInt();

        System.out.println("Enter the quantity of the medicine ");
        int quantity=sc.nextInt();

        System.out.println("Enter the price of the medicine");
        double price=sc.nextDouble();

        String add="insert into pharmacy (name,category,exp_date,quantity,price)values(?,?,'"+year+"-"+month+"-"+day+"',?,?)";
        PreparedStatement pst=con.prepareStatement(add,Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.setString(2, category);
        pst.setInt(3, quantity);
        pst.setDouble(4, price);
        pst.executeUpdate();                            //values added to the database

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            Medicine medicine = new Medicine(name, category, year + "-" + month + "-" + day, quantity, price);
            medicineMap.put(id, medicine);
            medicineList.add(medicine);
        }

        System.out.println("Medicine Removed Successfully");
    }

    //Method to remove medicine
    static void removeMedicine()throws Exception{
        System.out.println("enter Medicine ID to remove Medicine");
        int id = sc.nextInt();

        if(medicineMap.containsKey(id)){
            String sql = "delete from pharmacy where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

            Medicine medicine = medicineMap.remove(id);
            medicineList.remove(medicine);

            System.out.println("Medicine Removed SuccessFully");
        }
        else{
            System.out.println("Medicine with ID \" + id + \" not found");
        }
    }

    //Method to display Medicines Available
    static void displaymedicines(){

    }

    //Method to update Medcine price 
    static void updateMedicinePrice() throws Exception{
        System.out.println("Enter ID of the medicine to update PRICE");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            System.out.println("Enter the new price:");
            double price = sc.nextDouble();

            String sql = "update pharmacy set price = ? where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.executeUpdate();            //price updated in database

            //
            Medicine medicine = medicineMap.get(id);
            medicine.setPrice(price);
            System.out.println("Medicine price updated successfully.");
        } 
        else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    //Method to Update Medicine Quantity
    static void updateMedicinequantity()throws Exception{
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
        } 
        else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    //Method to Update Expiry Date
    static void updateExpiryDate()throws Exception{
        System.out.println("Enter the ID of the medicine to update EXPIRY DATE");
        int id = sc.nextInt();

        if (medicineMap.containsKey(id)) {
            System.out.println("Enter the new expiry date (YYYY-MM-DD):");
            System.out.println("Enter the expiry date of the medicine");
            System.out.println("enter the year in '2023' form");
            int year=sc.nextInt();
            System.out.println("enter the month in '01' or '11'  form");
            int month=sc.nextInt();
            System.out.println("enter the date in '01' or '20' form");
            int day=sc.nextInt();

            String sql = "update pharmacy set exp_date = ? where sr_no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, year+"-"+month+"-"+day);
            pst.setInt(2, id);
            pst.executeUpdate();

            Medicine medicine = medicineMap.get(id);
            medicine.setExp_date(year+"-"+month+"-"+day);
            System.out.println("Medicine expiry date updated successfully");
        } 
        else {
            System.out.println("Medicine with ID " + id + " not found");
        }
    }

    static void searchMedicine()throws Exception{
        sc.nextLine() ;
        System.out.println("Enter the Name of the Medicine");
        String med=sc.nextLine();
        
        String sql = "select * from pharmacy where name = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if(!rs.next()){
            System.out.println("Not found");
        }
        else{
            while (rs.next()){
                System.out.println("Name :- "+rs.getString(2));
                System.out.println("Category :- "+rs.getString(3));
                System.out.println("Expiry date:-"+rs.getDate(4));
                System.out.println("Quantity :- "+rs.getInt(5));
                System.out.println("Price :- "+rs.getDouble(6));
            }
        }
    }

    //Usage of io Pending 
    //display pending
    static void buyMedicine(){

    }

    static void generatebill(){

    }
}