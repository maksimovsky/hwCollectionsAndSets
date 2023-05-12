package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private static final EmployeeServiceImpl departments = new EmployeeServiceImpl();

    public Collection<Employee> getEmployeesInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).collect(Collectors.toUnmodifiableList());
    }

    public Collection<Employee> getEmployeesInDepartments() {
        List<Employee> employeeList = new ArrayList<>();
        Stream.iterate(0, i -> i + 1).limit(5).
                forEach(i -> employeeList.addAll(getEmployeesInDepartment(i)));
        return Collections.unmodifiableCollection(employeeList);
    }

    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    public double getAverageSalaryInDepartment(int department) {
        return (Math.ceil((departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble()) * 100)) / 100;
    }

    public double getMonthSalariesInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).sum();
    }

    public Collection<Employee> indexSalariesInDepartment(int department, double percents) {
        departments.getEmployees().stream().filter(employee -> employee.getDepartment() == department).
                forEach(employee -> employee.setSalary(
                        Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
        return getEmployeesInDepartment(department);
    }
}
