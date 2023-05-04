package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.Employee;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.StorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final List<Employee> employees = new ArrayList<>();
    private static final int maxSize = 10;
    private static int size = 0;

    @Override

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (size >= maxSize) {
            throw new StorageIsFullException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        size++;
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        size--;
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getList() {
        return Collections.unmodifiableList(employees);
    }
}
