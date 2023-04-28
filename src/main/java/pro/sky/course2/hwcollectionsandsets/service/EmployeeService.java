package pro.sky.course2.hwcollectionsandsets.service;

import pro.sky.course2.hwcollectionsandsets.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
