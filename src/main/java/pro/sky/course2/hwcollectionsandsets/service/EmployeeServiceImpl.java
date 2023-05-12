package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Map<String, Employee> employees = new HashMap<>();

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(firstName + lastName);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(firstName + lastName);
    }

    public Employee setSalary(String firstName, String lastName, double salary) {
        Employee employee = findEmployee(firstName, lastName);
        employee.setSalary(salary);
        return employee;
    }

    public Employee setDepartment(String firstName, String lastName, int department) {
        Employee employee = findEmployee(firstName, lastName);
        employee.setDepartment(department);
        return employee;
    }

    public Employee getEmployeeWithMinSalary() {
        return employees.values().stream().
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public Employee getEmployeeWithMaxSalary() {
        return employees.values().stream().
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public double getAverageSalary() {
        return employees.values().stream().
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble();
    }

    public double getMonthSalaries() {
        return employees.values().stream().mapToDouble(employee -> employee.getSalary()).sum();
    }

    public void indexSalaries(double percents) {
        employees.values().forEach(employee ->
                employee.setSalary(Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
    }

    public Collection<String> getNames() {
        return employees.values().stream().
                map(employee -> employee.getFirstName() + " " + employee.getLastName()).
                collect(Collectors.toUnmodifiableList());
    }

    public Collection<Employee> getEmployeesWithSalaryLessThan(double salary) {
        return employees.values().stream().
                filter(employee -> employee.getSalary() < salary).collect(Collectors.toUnmodifiableList());
    }

    public Collection<Employee> getEmployeesWithSalaryMoreThan(double salary) {
        return employees.values().stream().
                filter(employee -> employee.getSalary() >= salary).collect(Collectors.toUnmodifiableList());
    }

    public Collection<Employee> getEmployeesInDepartments() {
        List<Employee> employeeList = new ArrayList<>();
        Stream.iterate(0, i -> i + 1).limit(5).
                forEach(i -> employeeList.addAll(getEmployeesInDepartment(i)));
        return Collections.unmodifiableCollection(employeeList);
    }

    public Collection<Employee> getEmployeesInDepartment(int department) {
        return employees.values().stream().
                filter(employee -> employee.getDepartment() == department).collect(Collectors.toUnmodifiableList());
    }

    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        return employees.values().stream().
                filter(employee -> employee.getDepartment() == department).
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        return employees.values().stream().
                filter(employee -> employee.getDepartment() == department).
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public double getAverageSalaryInDepartment(int department) {
        return employees.values().stream().filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble();
    }

    public double getMonthSalariesInDepartment(int department) {
        return employees.values().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).sum();
    }

    public void indexSalariesInDepartment(int department, double percents) {
        employees.values().stream().filter(employee -> employee.getDepartment() == department).
                forEach(employee -> employee.setSalary(
                        Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
    }
}
