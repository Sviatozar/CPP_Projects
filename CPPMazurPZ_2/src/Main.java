import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck(1991, "Kraz", 1, 80, 1, 1);
        Car car = new Car(1991, "benz", -100, 70, 1);
        PassengerCar pasCar = new PassengerCar(1991, "Zaz", 1, 60, 1, 0);
        Bus bus = new Bus(1991, "bohdan", 1, 50, 1, 1);
        Car[] garage = new Car[]{car, truck, bus, pasCar};
        TaxiCorporation taxiCorporation = new TaxiCorporation(garage);
        taxiCorporation.getGarageValue();
        System.out.println("Before sorting by petroleum waste:");
        System.out.println(taxiCorporation);
        taxiCorporation.sortByPetroleumWaste();
        System.out.println("After sorting by petroleum waste:");
        System.out.println(taxiCorporation);
        System.out.println("Find car by max speed");
        System.out.println(taxiCorporation.findByMaxSpeed(140));
        System.out.println("Find car by parameters");
        System.out.println(taxiCorporation.findByParameters(1991, "benz", 1000, 70, 30));
        System.out.println();
        System.out.println("MyArrayList tests");
        MyArrayList<Car> cars = new MyArrayList<>();
        PassengerCar pasCar1 = new PassengerCar(2010, "Volvo", 2500, 3, 150, 2);
        Truck truck1 = new Truck(2008, "Man", 20000, 7, 110, 50);
        Bus bus1 = new Bus(2020, "Isuzu", 40000, 9, 100, 52);
        cars.add(pasCar1);
        cars.add(bus1);
        cars.add(1, truck1);
        System.out.println(cars);
        System.out.println();
        cars.addAll(new Car[]{truck1, bus1, pasCar1});
        System.out.println("Three more cars added to list " + cars);
        System.out.println();
        cars.addAll(3, new Car[]{pasCar1, pasCar1, pasCar1});
        System.out.println("Three passenger cars added from forth position " + cars);
        System.out.println();
        cars.remove(0);
        System.out.println("First element removed " + cars);
        System.out.println();
        System.out.println("List size " + cars.size());
    }
}