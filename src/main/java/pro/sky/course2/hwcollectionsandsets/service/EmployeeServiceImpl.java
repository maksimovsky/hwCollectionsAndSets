package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Map<String, Employee> employees = new HashMap<>();

    @Override

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
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
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
