package pro.sky.course2.hwcollectionsandsets.service;

import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, double salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee setSalary(String firstName, String lastName, double salary);

    Employee setDepartment(String firstName, String lastName, int department);

    Employee getEmployeeWithMinSalary();

    Employee getEmployeeWithMaxSalary();

    double getAverageSalary();

    double getMonthSalaries();

    Collection<Employee> indexSalaries(double percents);

    Collection<String> getNames();

    Collection<Employee> getEmployeesWithSalaryLessThan(double salary);

    Collection<Employee> getEmployeesWithSalaryMoreThan(double salary);
}
