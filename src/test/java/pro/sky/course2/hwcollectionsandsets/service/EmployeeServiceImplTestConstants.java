package pro.sky.course2.hwcollectionsandsets.service;

import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.Collection;
import java.util.List;

public class EmployeeServiceImplTestConstants {
    public static final String IVAN = "Ivan";
    public static final String PETR = "Petr";
    public static final String IVANOV = "Ivanov";
    public static final String PETROV = "Petrov";
    public static final String WRONG_FIRST_NAME = "Ivan2";
    public static final String WRONG_LAST_NAME = "Ivanov2";
    public static final double SALARY_1 = 57000;
    public static final double SALARY_2 = 168000;
    public static final double SALARY_3 = 89000;
    public static final double NEW_SALARY = 95000;
    public static final double COMPARING_SALARY = 70000;
    public static final double PERCENTS = 4;
    public static final double INDEXED_SALARY_1 = 59280;
    public static final double INDEXED_SALARY_2 = 174720;
    public static final double INDEXED_SALARY_3 = 92560;
    public static final int DEPT_1 = 1;
    public static final int DEPT_2 = 2;
    public static final Employee EMPLOYEE_1 = new Employee(IVAN, IVANOV, SALARY_1, DEPT_1);
    public static final Employee EMPLOYEE_2 = new Employee(IVAN, PETROV, SALARY_2, DEPT_1);
    public static final Employee EMPLOYEE_3 = new Employee(PETR, IVANOV, SALARY_3, DEPT_2);
    public static final Employee EMPLOYEE_4 = new Employee(PETR, PETROV, SALARY_3, DEPT_2);
    public static final Employee EMPLOYEE_3_WITH_NEW_SALARY = new Employee(PETR, IVANOV, NEW_SALARY, DEPT_2);
    public static final Employee EMPLOYEE_3_WITH_NEW_DEPT = new Employee(PETR, IVANOV, SALARY_3, DEPT_1);
    public static final Employee EMPLOYEE_1_INDEXED = new Employee(IVAN, IVANOV, INDEXED_SALARY_1, DEPT_1);
    public static final Employee EMPLOYEE_2_INDEXED = new Employee(IVAN, PETROV, INDEXED_SALARY_2, DEPT_1);
    public static final Employee EMPLOYEE_3_INDEXED = new Employee(PETR, IVANOV, INDEXED_SALARY_3, DEPT_2);
    public static final Employee EMPLOYEE_WITH_MIN_SALARY = EMPLOYEE_1;
    public static final Employee EMPLOYEE_WITH_MAX_SALARY = EMPLOYEE_2;
    public static final double AVERAGE_SALARY = 104666.67;
    public static final double MONTH_SALARIES = 314000;
    public static final Collection<Employee> EMPLOYEES = List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3);
    public static final Collection<Employee> EMPLOYEES_INDEXED = List.of(EMPLOYEE_1_INDEXED,
            EMPLOYEE_2_INDEXED, EMPLOYEE_3_INDEXED);
    public static final Collection<Employee> EMPLOYEES_WITH_SALARIES_LESS_THAN =
            List.of(EMPLOYEE_1);
    public static final Collection<Employee> EMPLOYEES_WITH_SALARIES_MORE_THAN =
            List.of(EMPLOYEE_2, EMPLOYEE_3);
    public static final Collection<String> EMPLOYEES_NAMES = List.of(IVAN + " " + IVANOV,
            IVAN + " " + PETROV, PETR + " " + IVANOV);
}
