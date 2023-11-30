public class Truck extends Car {
    int weightCapacity;

    public Truck() {
    }

    public Truck(int productionYear, String brandName, int cost, int petroleumWaste, int maxSpeed, int weightCapacity) {
        super(productionYear, brandName, cost, petroleumWaste, maxSpeed);
        setPetroleumWaste(petroleumWaste);
        setMaxSpeed(maxSpeed);
        setWeightCapacity(weightCapacity);
    }

    @Override
    public void setPetroleumWaste(int waste) {
        waste = Math.max(waste, 6);
        this.petroleumWaste = waste;
    }

    public void setWeightCapacity(int weightCapacity) {
        weightCapacity = Math.max(weightCapacity, 4);
        this.weightCapacity = weightCapacity;
    }

    @Override
    protected void setMaxSpeed(int speed) {
        speed = Math.max(speed, 160);
        this.maxSpeed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "productionYear=" + productionYear +
                ", brandName=" + brandName +
                ", cost=" + cost +
                ", petroleumWaste=" + petroleumWaste +
                ", maxSpeed=" + maxSpeed +
                ", weightCapacity=" + weightCapacity +
                '}';
    }
}
