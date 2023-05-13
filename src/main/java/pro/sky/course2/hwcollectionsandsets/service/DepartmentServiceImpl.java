package pro.sky.course2.hwcollectionsandsets.service;

import org.springframework.stereotype.Service;
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
    public Collection<Employee> getEmployeesInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> getEmployeesInDepartments() {
        List<Employee> employeeList = new ArrayList<>();
        Stream.iterate(0, i -> i + 1).limit(5).
                forEach(i -> employeeList.addAll(getEmployeesInDepartment(i)));
        return Collections.unmodifiableCollection(employeeList);
    }

    @Override
    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                min(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                max(Comparator.comparingDouble(employee -> employee.getSalary())).get();
    }

    @Override
    public double getAverageSalaryInDepartment(int department) {
        return (Math.ceil((departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).average().getAsDouble()) * 100)) / 100;
    }

    @Override
    public double getMonthSalariesInDepartment(int department) {
        return departments.getEmployees().stream().
                filter(employee -> employee.getDepartment() == department).
                mapToDouble(employee -> employee.getSalary()).sum();
    }

    @Override
    public Collection<Employee> indexSalariesInDepartment(int department, double percents) {
        departments.getEmployees().stream().filter(employee -> employee.getDepartment() == department).
                forEach(employee -> employee.setSalary(
                        Math.ceil(employee.getSalary() * (1 + percents / 100) * 100) / 100));
        return getEmployeesInDepartment(department);
    }
}
