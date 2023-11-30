package Task_1;

import java.time.LocalDate;

public abstract class PetAnimal {
    public String name;
    public LocalDate yearOfBirth;

    public PetAnimal(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = LocalDate.now().isAfter(LocalDate.ofYearDay(yearOfBirth, 1))
                ? LocalDate.ofYearDay(yearOfBirth, 1)
                : LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return LocalDate.now().getYear() - yearOfBirth.getYear();
    }

    public abstract void sleep();

    public abstract void makeSound();
}
