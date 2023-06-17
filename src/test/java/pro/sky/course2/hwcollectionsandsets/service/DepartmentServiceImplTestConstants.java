package pro.sky.course2.hwcollectionsandsets.service;

import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DepartmentServiceImplTestConstants {
    public static final Employee EMPLOYEE_1 =
            new Employee("Ivan", "Ivanov", 57000, 1);
    public static final Employee EMPLOYEE_2 =
            new Employee("Ivan", "Petrov", 168000, 1);
    public static final Employee EMPLOYEE_3 =
            new Employee("Petr", "Ivanov", 89000, 2);
    public static final Employee EMPLOYEE_4 =
            new Employee("Petr", "Petrov", 95000, 4);
    public static final Collection<Employee> EMPLOYEES =
            List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3, EMPLOYEE_4);
    public static final Map<Integer, List<Employee>> DEPARTMENTS = Map.of(
            1, List.of(EMPLOYEE_1, EMPLOYEE_2),
            2, List.of(EMPLOYEE_3), 3, List.of(),
            4, List.of(EMPLOYEE_4), 5, List.of()
    );
    public static final double AVERAGE_SALARY_1_DEPT = 112500;
    public static final double MONTH_SALARIES_1_DEPT = 225000;
    public static final Employee EMPLOYEE_1_INDEXED =
            new Employee("Ivan", "Ivanov", 60420, 1);
    public static final Employee EMPLOYEE_2_INDEXED =
            new Employee("Ivan", "Petrov", 178080, 1);
    public static final Collection<Employee> EMPLOYEES_DEPT_1_INDEXED = List.of(EMPLOYEE_1_INDEXED, EMPLOYEE_2_INDEXED);
}
