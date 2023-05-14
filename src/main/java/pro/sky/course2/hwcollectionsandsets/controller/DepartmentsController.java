package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.service.DepartmentServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentsController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("/all")
    public Collection<Employee> getEmployeesInDepartments() {
        return departmentServiceImpl.getEmployeesInDepartments();
    }

    @GetMapping(path = "/all", params = "department")
    public Collection<Employee> getEmployeesInDepartment(@RequestParam int department) {
        return departmentServiceImpl.getEmployeesInDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryInDepartment(@RequestParam int department) {
        return departmentServiceImpl.getEmployeeWithMinSalaryInDepartment(department);
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryInDepartment(@RequestParam int department) {
        return departmentServiceImpl.getEmployeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping("/average-salary")
    public double getAverageSalaryInDepartment(@RequestParam int department) {
        return departmentServiceImpl.getAverageSalaryInDepartment(department);
    }

    @GetMapping("/month-salaries")
    public double getMonthSalariesInDepartment(@RequestParam int department) {
        return departmentServiceImpl.getMonthSalariesInDepartment(department);
    }

    @GetMapping("/index-salaries")
    public Collection<Employee> indexSalariesInDepartment(int department, double percents) {
        return departmentServiceImpl.indexSalariesInDepartment(department, percents);
    }
}
