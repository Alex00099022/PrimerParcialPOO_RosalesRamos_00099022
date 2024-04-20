abstract class AbstractElectronicItem implements ElectronicItem {
    protected String name;
    protected String model;
    protected String description;
    protected double price;

    public AbstractElectronicItem(String name, String model, String description, double price) {
        this.name = name;
        this.model = model;
        this.description = description;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }


    public String getModel() {
        return model;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
