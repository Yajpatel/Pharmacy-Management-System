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

    public void setMed_name(String med_name) {
        Med_name = med_name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMed_name() {
        return Med_name;
    }

    public String getCategory() {
        return category;
    }

    public String getExp_date() {
        return exp_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Medicine [Med_name=" + Med_name + ", category=" + category + ", exp_date=" + exp_date + ", quantity="
                + quantity + ", price=" + price + "]";
    }
}
