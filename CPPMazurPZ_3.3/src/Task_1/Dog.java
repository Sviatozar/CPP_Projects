package Task_1;

public class Dog extends PetAnimal implements Comparable<Dog> {
    public int scaredOfThievesCount;

    public Dog(String name, int yearOfBirth, int scaredOfThievesCount) {
        super(name, yearOfBirth);
        this.scaredOfThievesCount = Math.max(scaredOfThievesCount, 0);
    }

    @Override
    public void sleep() {
        System.out.println(this.name + " sleep");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public int compareTo(Dog o) {
        return Integer.compare(this.scaredOfThievesCount, o.scaredOfThievesCount);
    }

    @Override
    public String toString() {
        return name + " scared of " + scaredOfThievesCount + " thieves.";
    }
}
