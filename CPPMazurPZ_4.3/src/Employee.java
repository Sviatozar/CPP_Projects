import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private Gender gender;
    private int age;
    private int salary;
    private int workExperience;
    private Speciality speciality;

    public Employee() {
    }

    public Employee(int id, String name, String surname, Gender gender, int age, int salary, int workExperience, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.workExperience = workExperience;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && salary == employee.salary && workExperience == employee.workExperience && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && gender == employee.gender && speciality == employee.speciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, age, salary, workExperience, speciality);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", salary=" + salary +
                ", workExperience=" + workExperience +
                ", speciality=" + speciality +
                '}' + '\n';
    }
}
