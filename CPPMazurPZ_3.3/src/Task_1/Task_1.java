package Task_1;

import java.util.*;


public class Task_1 {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom", 2002, 22);
        Cat murca = new Cat("Murca", 2004, 6);
        Cat murzic = new Cat("Murzic", 2007, 61);
        Dog zver = new Dog("Zver", 2012, 3);
        Dog luna = new Dog("Luna", 2017, 8);
        Dog patron = new Dog("Patron", 2022, 25);
        List<Dog> dogs = new ArrayList<>(List.of(zver, luna, patron));
        Collections.sort(dogs);
        for (Dog dog :
                dogs) {
            System.out.println(dog);
        }
        List<Cat> cats = new ArrayList<>(List.of(tom, murca, murzic));
        Collections.sort(cats);
        for (Cat cat :
                cats) {
            System.out.println(cat);
        }
        List<PetAnimal> rancho = new ArrayList<>();
        rancho.addAll(dogs);
        rancho.addAll(cats);
        rancho.sort(new AnimalByAgeComparator(Order.DESCENDING));
        for (PetAnimal pet :
                rancho) {
            System.out.println(pet.getName() + " " + pet.getAge() + " years");
        }
    }
}