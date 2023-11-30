package Task_1;

public class Cat extends PetAnimal implements Comparable<Cat> {
    public int caughtMiceCount;

    public Cat(String name, int yearOfBirth, int caughtMiceCount) {
        super(name, yearOfBirth);
        this.caughtMiceCount = Math.max(caughtMiceCount, 0);
    }

    @Override
    public void sleep() {
        System.out.println(this.name + " sleep");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public int compareTo(Cat o) {
        return Integer.compare(this.caughtMiceCount, o.caughtMiceCount);
    }

    @Override
    public String toString() {
        return name + " caught " + caughtMiceCount + " mice's";
    }
}
