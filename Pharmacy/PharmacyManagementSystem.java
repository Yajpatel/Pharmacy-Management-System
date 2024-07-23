package Pharmacy;

import java.util.*;
import java.sql.*;

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
            System.out.println("3.=>To Update Medicine Price");
            System.out.println("4.=>TO Update Medicine Quantity");
            System.out.println("5.=>To Update Expiry Date");
            System.out.println("6.=>To Search Medicine");
            System.out.println("7.=>To Buy Medicines");
            System.out.println("8.=>To Generate Bill");;
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
                        updateMedicinePrice();
                    break;
                case 4 :
                        updateMeicinequantity();
                    break;
                case 5 :
                        updateExpiryDate();
                break;
                case 6 :
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

    //Pending
    static void addMedicine()throws Exception{                           //to add product in database 
        sc.nextLine() ;
        System.out.println("Enter the name of the medicine");
        String name=sc.nextLine();

        System.out.println("Enter the category of the medicine");
        String category=sc.nextLine();

        System.out.println("Enter the expiry date of the medicine");
        // System.out.println("");
        System.out.println("enter the year in '2023' form");
        int year=sc.nextInt();
        System.out.println("enter the month in '01' or'11'  form");
        int month=sc.nextInt();
        System.out.println("enter the date in '01' or '20' form");
        int day=sc.nextInt();

        System.out.println("Enter the quantity of the medicine ");
        int quantity=sc.nextInt();

        System.out.println("Enter the price of the medicine");
        double price=sc.nextDouble();

        String add="insert into pharmacy (name,category,exp_date,quantity,price)values(?,?,'"+year+"-"+month+"-"+day+"',?,?)";
        PreparedStatement pst=con.prepareStatement(add);
        pst.setString(1, name);
        pst.setString(2, category);
        pst.setInt(3, quantity);
        pst.setDouble(4, price);
        pst.executeUpdate();
    }

    static void removeMedicine(){

    }

    static void updateMedicinePrice(){

    }

    static void updateMeicinequantity(){

    }

    static void updateExpiryDate(){

    }
}