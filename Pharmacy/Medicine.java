package Pharmacy;

public class Medicine {
    
    String Med_name;
    String category;
    String exp_date;
    int quantity;
    double price;

    public Medicine(String med_name, String category, String exp_date, int quantity, double price) {
        Med_name = med_name;
        this.category = category;
        this.exp_date = exp_date;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "Medicine [Med_name=" + Med_name + ", category=" + category + ", exp_date=" + exp_date + ", quantity="
                + quantity + ", price=" + price + "]";
    }

}
