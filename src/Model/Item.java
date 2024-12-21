package Model;

public class Item {
    private String id;
    private String name;
    private Double price;
    private int qty;
    private  String description;

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item() {
    }

    public Item(String id, String name, Double price, int qty, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.description = description;
    }
}
