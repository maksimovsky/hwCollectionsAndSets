package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public Collection<Employee> getEmployeesInDepartments() {
        return departmentService.getEmployeesInDepartments();
    }

    @GetMapping(path = "/all", params = "department")
    public Collection<Employee> getEmployeesInDepartment(@RequestParam int department) {
        return departmentService.getEmployeesInDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMinSalaryInDepartment(department);
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping("/average-salary")
    public double getAverageSalaryInDepartment(@RequestParam int department) {
        return departmentService.getAverageSalaryInDepartment(department);
    }

    @GetMapping("/month-salaries")
    public double getMonthSalariesInDepartment(@RequestParam int department) {
        return departmentService.getMonthSalariesInDepartment(department);
    }

    @GetMapping("/index-salaries")
    public Collection<Employee> indexSalariesInDepartment(int department, double percents) {
        return departmentService.indexSalariesInDepartment(department, percents);
    }
}
