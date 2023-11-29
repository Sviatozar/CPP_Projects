public class Task_1 {
    static EmployeeRepository employeeRepository = new EmployeeRepository();

    public static void main(String[] args) {
        String[] names = employeeRepository.getNamesAndSurnamesOfTop3BySalary();
        System.out.println("Top 3 by Salary:");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Employees grouped by specialities: " + '\n' + employeeRepository.groupBySpeciality());
        System.out.println("Salary of QA females younger than 30, with work experience less than 5 years: " + '\n' + employeeRepository.getSalaryByHugeCriteriaList());
        System.out.println(employeeRepository.getDescendingSalaryWithFullName());
        System.out.println(employeeRepository.checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty());
        System.out.println(employeeRepository.getAverageSalaryBySpeciality());
    }
}