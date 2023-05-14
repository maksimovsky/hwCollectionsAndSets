package pro.sky.course2.hwcollectionsandsets.service;

import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.Collection;

public interface DepartmentService {
    public Collection<Employee> getEmployeesInDepartment(int department);

    Collection<Employee> getEmployeesInDepartments();

    Employee getEmployeeWithMinSalaryInDepartment(int department);

    Employee getEmployeeWithMaxSalaryInDepartment(int department);

    double getAverageSalaryInDepartment(int department);

    double getMonthSalariesInDepartment(int department);

    Collection<Employee> indexSalariesInDepartment(int department, double percents);
}
