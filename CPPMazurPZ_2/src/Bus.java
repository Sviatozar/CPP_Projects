public class Bus extends Car {
    int seatAmount;

    public Bus() {
    }

    public Bus(int productionYear, String brandName, int cost, int petroleumWaste, int maxSpeed, int seatAmount) {
        super(productionYear, brandName, cost, petroleumWaste, maxSpeed);
        setPetroleumWaste(petroleumWaste);
        setMaxSpeed(maxSpeed);
        setSeatAmount(seatAmount);
    }

    @Override
    public void setPetroleumWaste(int waste) {
        waste = Math.max(waste, 4);
        this.petroleumWaste = waste;
    }

    public void setSeatAmount(int seatAmount) {
        seatAmount = Math.max(seatAmount, 10);
        this.seatAmount = seatAmount;
    }

    @Override
    protected void setMaxSpeed(int speed) {
        speed = Math.max(speed, 140);
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
                ", seatAmount=" + seatAmount +
                '}';
    }
}
