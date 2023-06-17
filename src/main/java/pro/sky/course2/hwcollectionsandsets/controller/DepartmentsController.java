package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.service.DepartmentServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentsController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesInDepartments() {
        return departmentServiceImpl.getEmployeesInDepartments();
    }

    @GetMapping("/{department}/employees")
    public Collection<Employee> getEmployeesInDepartment(@PathVariable int department) {
        return departmentServiceImpl.getEmployeesInDepartment(department);
    }

    @GetMapping("/{department}/salary/min")
    public Employee getEmployeeWithMinSalaryInDepartment(@PathVariable int department) {
        return departmentServiceImpl.getEmployeeWithMinSalaryInDepartment(department);
    }

    @GetMapping("/{department}/salary/max")
    public Employee getEmployeeWithMaxSalaryInDepartment(@PathVariable int department) {
        return departmentServiceImpl.getEmployeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping("/{department}/salary/average")
    public double getAverageSalaryInDepartment(@PathVariable int department) {
        return departmentServiceImpl.getAverageSalaryInDepartment(department);
    }

    @GetMapping("/{department}/salary/sum")
    public double getMonthSalariesInDepartment(@PathVariable int department) {
        return departmentServiceImpl.getMonthSalariesInDepartment(department);
    }

    @GetMapping("/{department}/salary/index")
    public Collection<Employee> indexSalariesInDepartment
            (@PathVariable int department, @RequestParam double percents) {
        return departmentServiceImpl.indexSalariesInDepartment(department, percents);
    }
}
