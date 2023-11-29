import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1, "Blake", "Smith", Gender.MALE, 21, 1000, 1, Speciality.PM),
            new Employee(2, "Ann", "Jones", Gender.FEMALE, 31, 2000, 5, Speciality.PM),
            new Employee(3, "Brock", "Taylor", Gender.MALE, 41, 3000, 10, Speciality.PM),
            new Employee(4, "Bea", "Brown", Gender.FEMALE, 51, 4000, 15, Speciality.PM),
            new Employee(5, "Cade", "Williams", Gender.MALE, 21, 1000, 1, Speciality.BACKEND_DEVELOPER),
            new Employee(6, "Beth", "Wilson", Gender.FEMALE, 29, 2000, 5, Speciality.QA),
            new Employee(7, "Cale", "Johnson", Gender.MALE, 41, 3000, 10, Speciality.BACKEND_DEVELOPER),
            new Employee(8, "Blaire", "Davies", Gender.FEMALE, 51, 4000, 15, Speciality.QA),
            new Employee(9, "Chad", "Robinson", Gender.MALE, 21, 1000, 1, Speciality.HR),
            new Employee(10, "Claire", "Wright", Gender.FEMALE, 31, 2000, 5, Speciality.HR),
            new Employee(11, "Chase", "Thompson", Gender.MALE, 41, 3000, 10, Speciality.HR),
            new Employee(12, "Dawn", "Evans", Gender.FEMALE, 51, 4000, 15, Speciality.HR),
            new Employee(13, "Clark", "Walker", Gender.MALE, 21, 1000, 1, Speciality.DEV_OPS),
            new Employee(14, "Dea", "White", Gender.FEMALE, 31, 2000, 5, Speciality.DEV_OPS),
            new Employee(15, "Cole", "Roberts", Gender.MALE, 41, 3000, 10, Speciality.DEV_OPS),
            new Employee(16, "Elle", "Green", Gender.FEMALE, 51, 4000, 15, Speciality.DEV_OPS),
            new Employee(17, "Drake", "Hall", Gender.MALE, 21, 1000, 1, Speciality.BACKEND_DEVELOPER),
            new Employee(18, "Eve", "Wood", Gender.FEMALE, 29, 2000, 5, Speciality.QA),
            new Employee(19, "Grant", "Jackson", Gender.MALE, 41, 3000, 10, Speciality.BACKEND_DEVELOPER),
            new Employee(20, "Faye", "Clark", Gender.FEMALE, 51, 4000, 15, Speciality.QA),
            new Employee(21, "Heath", "Hansen", Gender.MALE, 21, 1000, 1, Speciality.FRONTEND_DEVELOPER),
            new Employee(22, "Gali", "Johansen", Gender.FEMALE, 31, 2000, 5, Speciality.FRONTEND_DEVELOPER),
            new Employee(23, "Jack", "Olsen", Gender.MALE, 41, 3000, 10, Speciality.FRONTEND_DEVELOPER),
            new Employee(24, "Grace", "Larsen", Gender.FEMALE, 51, 4000, 15, Speciality.FRONTEND_DEVELOPER)
    ));

    public String[] getNamesAndSurnamesOfTop3BySalary() {
        return employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)
                        .reversed()).map((e) -> e.getName() + " " + e.getSurname())
                .limit(3).toArray(String[]::new);
    }

    public Map<Speciality, List<Employee>> groupBySpeciality() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality, Collectors.toList()));
    }

    public int getSalaryByHugeCriteriaList() {
        return employees.stream().filter(e -> e.getGender() == Gender.FEMALE
                && e.getAge() <= 30 && e.getSpeciality() == Speciality.QA
                && e.getWorkExperience() <= 5).map(Employee::getSalary).reduce(0, Integer::sum);
    }

    public String getDescendingSalaryWithFullName() {
        return employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)
                        .reversed()).map(e -> e.getName() + " " + e.getSurname() + " " + e.getSalary())
                .collect(Collectors.joining(";"));
    }

    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty() {
        return employees.stream().anyMatch(e -> e.getGender() == Gender.MALE
                && (e.getSpeciality() == Speciality.DEV_OPS
                || e.getSpeciality() == Speciality.BACKEND_DEVELOPER)
                && e.getWorkExperience() > 20);
    }

    public Map<Speciality, Double> getAverageSalaryBySpeciality() {
        return employees.stream().collect(Collectors
                .groupingBy(Employee::getSpeciality, Collectors.averagingDouble(Employee::getSalary)));
    }
}
