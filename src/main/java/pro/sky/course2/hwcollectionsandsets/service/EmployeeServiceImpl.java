package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.exception.WrongNameException;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Map<String, Employee> employees = new HashMap<>();

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        validateName(firstName, lastName);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validateName(firstName, lastName);
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(firstName + lastName);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validateName(firstName, lastName);
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(firstName + lastName);
    }

    @Override
    public Employee setSalary(String firstName, String lastName, double salary) {
        validateName(firstName, lastName);
        Employee employee = findEmployee(firstName, lastName);
        employee.setSalary(salary);
        return employee;
    }

    @Override
    public Employee setDepartment(String firstName, String lastName, int department) {
        validateName(firstName, lastName);
        Employee employee = findEmployee(firstName, lastName);
        employee.setDepartment(department);
        return employee;
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employees.values().stream().
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employees.values().stream().
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public double getAverageSalary() {
        return (Math.ceil((employees.values().stream().
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble()) * 100)) / 100;
    }

    @Override
    public double getMonthSalaries() {
        return employees.values().stream().mapToDouble(employee -> employee.getSalary()).sum();
    }

    @Override
    public Collection<Employee> indexSalaries(double percents) {
        employees.values().forEach(employee ->
                employee.setSalary(Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
        return getEmployees();
    }

    @Override
    public Collection<String> getNames() {
        return employees.values().stream().
                map(employee -> employee.getFirstName() + " " + employee.getLastName()).
                collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> getEmployeesWithSalaryLessThan(double salary) {
        return employees.values().stream().
                filter(employee -> employee.getSalary() < salary).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> getEmployeesWithSalaryMoreThan(double salary) {
        return employees.values().stream().
                filter(employee -> employee.getSalary() >= salary).collect(Collectors.toUnmodifiableList());
    }

    private static void validateName(String firstName, String lastName) {
        if (!isAlpha(firstName) || !isAlpha(lastName)) {
            throw new WrongNameException();
        }
    }
}
