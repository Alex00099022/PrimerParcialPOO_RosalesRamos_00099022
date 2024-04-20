class MobilePhone extends AbstractElectronicItem {
    private String networkType;

    public MobilePhone(String name, String model, String description, double price, String networkType) {
        super(name, model, description, price);
        this.networkType = networkType;
    }

    public String getNetworkType() {
        return networkType;
    }
}
