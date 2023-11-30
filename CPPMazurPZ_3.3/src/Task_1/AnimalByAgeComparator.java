package Task_1;

import java.util.Comparator;

public class AnimalByAgeComparator implements Comparator<PetAnimal> {
    Order order;

    public AnimalByAgeComparator(Order order) {
        if (order == null) {
            throw new NullPointerException();
        }
        this.order = order;
    }

    @Override
    public int compare(PetAnimal o1, PetAnimal o2) {
        return order == Order.DESCENDING
                ? o1.yearOfBirth.compareTo(o2.yearOfBirth)
                : o2.yearOfBirth.compareTo(o1.yearOfBirth);
    }
}
