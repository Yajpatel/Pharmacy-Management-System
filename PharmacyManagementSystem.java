import java.util.*;
import java.sql.*;

public class PharmacyManagementSystem{
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        String dburl = "jdbc:mysql://localhost:3306/medical";
        String dbuser = "root";
        String Pass = "";
        String driver = "com.mysql.jdbc.Driver";
        
        //default URL for Connection with database
        Class.forName(driver);
        Connection con = DriverManager.getConnection(dburl, dbuser, Pass);
        
        //to check if it is connected with database or not
        if(con != null){
            System.out.println("connection sucessfull");
        }
        else{
            System.out.println("connection failed");
        }

        String sql = "Create table if not exists Pharmacy(sr_no int primary key,name varchar(30),category varchar(20),exp_date Date,quantity int,price decimal(10,2)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        
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
                break;
                case 2 :
                break;
                case 3 :
                break;
                case 4 :
                break;
                case 5 :
                break;
                case 0 :
                break;
                default :
                break;
            }
        }while(choice != 0);
    }

    //Pending
}
