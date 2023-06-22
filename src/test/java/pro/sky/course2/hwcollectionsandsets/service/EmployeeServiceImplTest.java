package pro.sky.course2.hwcollectionsandsets.service;

import org.junit.jupiter.api.*;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeAlreadyAddedException;
import pro.sky.course2.hwcollectionsandsets.exception.EmployeeNotFoundException;
import pro.sky.course2.hwcollectionsandsets.exception.WrongNameException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course2.hwcollectionsandsets.service.EmployeeServiceImplTestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    void beforeEach() {
        out.addEmployee(IVAN, IVANOV, SALARY_1, DEPT_1);
        out.addEmployee(IVAN, PETROV, SALARY_2, DEPT_1);
        out.addEmployee(PETR, IVANOV, SALARY_3, DEPT_2);
    }

    @AfterEach
    void afterEach() {
        out.removeEmployee(IVAN, IVANOV);
        out.removeEmployee(IVAN, PETROV);
        out.removeEmployee(PETR, IVANOV);
    }

    @Test
    @DisplayName("Возвращение списка всех сотрудников")
    void shouldReturnEmployees() {
        assertEquals(EMPLOYEES, out.getEmployees());
    }

    @Test
    @DisplayName("Добавление сотрудника")
    void shouldReturnEmployee4AndThrowExceptions() {
        assertEquals(EMPLOYEE_4, out.addEmployee(PETR, PETROV, SALARY_3, DEPT_2));
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee(PETR, PETROV, SALARY_3, DEPT_2));
        assertThrows(WrongNameException.class, () -> out.addEmployee(WRONG_FIRST_NAME, PETROV, SALARY_3, DEPT_2));
        assertThrows(WrongNameException.class, () -> out.addEmployee(PETR, WRONG_LAST_NAME, SALARY_3, DEPT_2));
        assertThrows(WrongNameException.class, () ->
                out.addEmployee(WRONG_FIRST_NAME, WRONG_LAST_NAME, SALARY_3, DEPT_2));

        out.removeEmployee(PETR, PETROV);  //чтобы без ошибок отработал "Поиск сотрудника"
    }

    @Test
    @DisplayName("Удаление сотрудника")
    void shouldReturnEmployee1AndThrowExceptions() {
        assertEquals(EMPLOYEE_1, out.removeEmployee(IVAN, IVANOV));
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(IVAN, IVANOV));
        assertThrows(WrongNameException.class, () -> out.removeEmployee(WRONG_FIRST_NAME, IVANOV));

        out.addEmployee(IVAN, IVANOV, SALARY_1, DEPT_1); //чтобы без ошибок отработал afterEach()
    }

    @Test
    @DisplayName("Поиск сотрудника")
    void shouldReturnEmployee2AndThrowExceptions() {
        assertEquals(EMPLOYEE_2, out.findEmployee(IVAN, PETROV));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(PETR, PETROV));
        assertThrows(WrongNameException.class, () -> out.removeEmployee(WRONG_FIRST_NAME, IVANOV));
    }

    @Test
    @DisplayName("Изменение зарплаты")
    void shouldReturnEmployeeWithNewSalaryAndThrowExceptions() {
        assertEquals(EMPLOYEE_3_WITH_NEW_SALARY, out.setSalary(PETR, IVANOV, PERCENTS));
        assertThrows(WrongNameException.class, () -> out.setSalary(WRONG_FIRST_NAME, IVANOV, PERCENTS));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(PETR, PETROV));
    }

    @Test
    @DisplayName("Изменение отдела")
    void shouldReturnEmployeeWithNewDeptAndThrowExceptions() {
        assertEquals(EMPLOYEE_3_WITH_NEW_DEPT, out.setDepartment(PETR, IVANOV, DEPT_1));
        assertThrows(WrongNameException.class, () -> out.setDepartment(WRONG_FIRST_NAME, IVANOV, DEPT_2));
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(PETR, PETROV));
    }

    @Test
    @DisplayName("Поиск сотрудника с минимальной зарплатой")
    void shouldReturnEmployeeWithMinSalary() {
        assertEquals(EMPLOYEE_WITH_MIN_SALARY, out.getEmployeeWithMinSalary());
    }

    @Test
    @DisplayName("Поиск сотрудника с максимальной зарплатой")
    void shouldReturnEmployeeWithMaxSalary() {
        assertEquals(EMPLOYEE_WITH_MAX_SALARY, out.getEmployeeWithMaxSalary());
    }

    @Test
    @DisplayName("Вычисление средней зарплаты")
    void shouldReturnAverageSalary() {
        assertEquals(AVERAGE_SALARY, out.getAverageSalary());
    }

    @Test
    @DisplayName("Вычисление зарплат за месяц")
    void shouldReturnMonthSalaries() {
        assertEquals(MONTH_SALARIES, out.getMonthSalaries());
    }

    @Test
    @DisplayName("Индексация зарплат")
    void shouldReturnEmployeeIndexed() {
        assertEquals(EMPLOYEES_INDEXED, out.indexSalaries(PERCENTS));
    }

    @Test
    @DisplayName("Возвращение списка имен сотрудников")
    void shouldReturnEmployeesNames() {
        assertEquals(EMPLOYEES_NAMES, out.getNames());
    }

    @Test
    @DisplayName("Поиск сотрудников, с зарплатой меньше, чем...")
    void shouldReturnEmployeesWithSalariesLessThan() {
        assertEquals(EMPLOYEES_WITH_SALARIES_LESS_THAN, out.getEmployeesWithSalaryLessThan(COMPARING_SALARY));
    }

    @Test
    @DisplayName("Поиск сотрудников, с зарплатой больше, чем...")
    void shouldReturnEmployeesWithSalariesMoreThan() {
        assertEquals(EMPLOYEES_WITH_SALARIES_MORE_THAN, out.getEmployeesWithSalaryMoreThan(COMPARING_SALARY));
    }
}