package ex44;

// * Product Class
// * Holds a product and all it's info

public class Products {

    private String name;
    private String price;
    private String quantity;


    public Products(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String full_product_info()
    {
        String prudct_info = String.format(
                "Name: %s \n" +
                "Price: %s \n" +
                "Quantity: %s", name, price, quantity
        );

        return prudct_info;
    }


    //--only getters as product info should not be modified--//
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }
}
