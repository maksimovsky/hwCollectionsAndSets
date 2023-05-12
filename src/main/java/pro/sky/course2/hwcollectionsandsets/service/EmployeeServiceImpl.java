package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

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
        return (Math.ceil((employees.values().stream().
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble()) * 100)) / 100;
    }

    public double getMonthSalaries() {
        return employees.values().stream().mapToDouble(employee -> employee.getSalary()).sum();
    }

    public Collection<Employee> indexSalaries(double percents) {
        employees.values().forEach(employee ->
                employee.setSalary(Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
        return getEmployees();
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
}
