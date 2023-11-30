import java.util.Objects;

public class Car {
    protected int productionYear;
    protected String brandName;
    protected int cost;
    protected int petroleumWaste;
    protected int maxSpeed;

    public Car() {
    }

    public Car(int productionYear, String brandName, int cost, int petroleumWaste, int maxSpeed) {
        this.productionYear = productionYear;
        this.brandName = brandName;
        setCost(cost);
        setPetroleumWaste(petroleumWaste);
        setMaxSpeed(maxSpeed);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        cost = Math.max(cost, 1000);
        this.cost = cost;
    }

    public int getPetroleumWaste() {
        return petroleumWaste;
    }

    public void setPetroleumWaste(int waste) {
        waste = Math.max(waste, 1);
        this.petroleumWaste = waste;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    protected void setMaxSpeed(int speed) {
        speed = Math.max(speed, 30);
        this.maxSpeed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cost == car.cost && petroleumWaste == car.petroleumWaste && maxSpeed == car.maxSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, petroleumWaste, maxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "productionYear=" + productionYear +
                ", brandName=" + brandName +
                ", cost=" + cost +
                ", petroleumWaste=" + petroleumWaste +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
