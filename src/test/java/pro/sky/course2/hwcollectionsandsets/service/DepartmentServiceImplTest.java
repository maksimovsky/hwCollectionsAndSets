package pro.sky.course2.hwcollectionsandsets.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2.hwcollectionsandsets.exception.WrongDepartmentException;
import pro.sky.course2.hwcollectionsandsets.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.course2.hwcollectionsandsets.service.DepartmentServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void beforeEach() {
        when(employeeServiceMock.getEmployees()).thenReturn(EMPLOYEES);
    }

    @Test
    @DisplayName("Получение работников по отделу")
    void shouldReturnListOfEmployeesByDepartmentAndThrowException() {
        Collection<Employee> expected = List.of(EMPLOYEE_1, EMPLOYEE_2);
        Collection<Employee> result = out.getEmployeesInDepartment(1);
        assertEquals(expected, result);

        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(6));
    }

    @Test
    @DisplayName("Получение мапы с работниками по отделам")
    void shouldReturnMapWithDepartments() {
        assertEquals(DEPARTMENTS, out.getEmployeesInDepartments());
    }

    @Test
    @DisplayName("Получение работника с минимальной зарплатой")
    void shouldReturnEmployee1AndThrowException() {
        assertEquals(EMPLOYEE_1, out.getEmployeeWithMinSalaryInDepartment(1));
        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(7));
    }

    @Test
    @DisplayName("Получение работника с максимальной зарплатой")
    void shouldReturnEmployee2AndThrowException() {
        assertEquals(EMPLOYEE_2, out.getEmployeeWithMaxSalaryInDepartment(1));
        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(6));
    }

    @Test
    @DisplayName("Получение средней зарплаты")
    void shouldReturnAverageSalaryAndThrowException() {
        assertEquals(AVERAGE_SALARY_1_DEPT, out.getAverageSalaryInDepartment(1));
        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(6));
    }

    @Test
    @DisplayName("Получение месячной зарплаты")
    void shouldReturnMonthSalariesAndThrowException() {
        assertEquals(MONTH_SALARIES_1_DEPT, out.getMonthSalariesInDepartment(1));
        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(6));
    }

    @Test
    @DisplayName("Индексация зарплат")
    void shouldReturnEmployeesWithNewSalariesAndThrowException() {
        assertEquals(EMPLOYEES_DEPT_1_INDEXED, out.indexSalariesInDepartment(1, 6));
        assertThrows(WrongDepartmentException.class, () -> out.getEmployeesInDepartment(6));
    }
}