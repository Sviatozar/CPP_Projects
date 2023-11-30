import java.util.Arrays;
import java.util.Comparator;

public class TaxiCorporation {
    private Car[] garage;

    public TaxiCorporation() {
    }

    public TaxiCorporation(Car[] garage) {
        this.garage = garage;
    }

    public Car[] getGarage() {
        return garage;
    }

    ;

    public void setGarage(Car[] garage) {
        this.garage = garage;
    }

    ;

    public int getGarageValue() {
        int sum = 0;
        for (Car car :
                garage) {
            sum += car.getCost();
        }
        return sum;
    }

    public void sortByPetroleumWaste() {
        for (int i = garage.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (garage[j - 1].petroleumWaste > garage[j].petroleumWaste) {
                    Car temp = garage[j - 1];
                    garage[j - 1] = garage[j];
                    garage[j] = temp;
                }
            }
        }
    }

    public Car findByMaxSpeed(int speed) {
        for (Car car :
                garage) {
            if (car.getMaxSpeed() == speed) {
                return car;
            }
        }
        return null;
    }

    public Car findByParameters(int productionYear, String brandName, int cost, int petroleumWaste, int maxSpeed) {
        Car searchCar = new Car(productionYear, brandName, cost, petroleumWaste, maxSpeed);
        for (Car car : garage) {
            if (car.hashCode() == searchCar.hashCode() && (car.equals(searchCar))) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(garage);
    }
}
