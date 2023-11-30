public class PassengerCar extends Car {
    int engineVolume;

    public PassengerCar() {
    }

    public PassengerCar(int productionYear, String brandName, int cost, int petroleumWaste, int maxSpeed, int engineVolume) {
        super(productionYear, brandName, cost, petroleumWaste, maxSpeed);
        setPetroleumWaste(petroleumWaste);
        setMaxSpeed(maxSpeed);
        setEngineVolume(engineVolume);
    }

    @Override
    public void setPetroleumWaste(int waste) {
        waste = Math.max(waste, 2);
        this.petroleumWaste = waste;
    }

    public void setEngineVolume(int engineVolume) {
        engineVolume = Math.max(engineVolume, 1);
        this.engineVolume = engineVolume;
    }

    @Override
    protected void setMaxSpeed(int speed) {
        speed = Math.max(speed, 240);
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
                ", engineVolume=" + engineVolume +
                '}';
    }
}
