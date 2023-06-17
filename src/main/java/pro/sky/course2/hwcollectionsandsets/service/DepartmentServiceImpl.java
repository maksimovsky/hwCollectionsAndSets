package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.exception.WrongDepartmentException;
import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl departments;

    public DepartmentServiceImpl(EmployeeServiceImpl departments) {
        this.departments = departments;
    }

    @Override
    public List<Employee> getEmployeesInDepartment(int department) {
        verifyDepartment(department);
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesInDepartments() {
        Map<Integer, List<Employee>> employeeList = new HashMap<>();
        Stream.iterate(1, i -> i + 1).limit(5).
                forEach(i -> employeeList.put(i, getEmployeesInDepartment(i)));
        return employeeList;
//        return Map.copyOf(employeeList);
    }

    @Override
    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        verifyDepartment(department);
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        verifyDepartment(department);
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public double getAverageSalaryInDepartment(int department) {
        verifyDepartment(department);
        return (Math.ceil((departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble()) * 100)) / 100;
    }

    @Override
    public double getMonthSalariesInDepartment(int department) {
        verifyDepartment(department);
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).sum();
    }

    @Override
    public Collection<Employee> indexSalariesInDepartment(int department, double percents) {
        verifyDepartment(department);
        departments.getEmployees().stream().filter(employee -> employee.getDepartment() == department).
                forEach(employee -> employee.setSalary(
                        Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
        return getEmployeesInDepartment(department);
    }

    private void verifyDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new  WrongDepartmentException();
        }
    }
}
