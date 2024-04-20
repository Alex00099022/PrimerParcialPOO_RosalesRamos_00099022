class Laptop extends AbstractElectronicItem {
    private String processor;

    public Laptop(String name, String model, String description, double price, String processor) {
        super(name, model, description, price);
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }
}
