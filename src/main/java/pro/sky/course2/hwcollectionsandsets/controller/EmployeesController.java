package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.service.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeeServiceImpl employeeService;

    public EmployeesController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam double salary, @RequestParam int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/set-salary")
    public Employee setSalary(@RequestParam String firstName, @RequestParam String lastName,
                              @RequestParam double salary) {
        return employeeService.setSalary(firstName, lastName, salary);
    }

    @GetMapping("/set-department")
    public Employee setDepartment(@RequestParam String firstName, @RequestParam String lastName,
                                  @RequestParam int department) {
        return employeeService.setDepartment(firstName, lastName, department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/average-salary")
    public double getAverageSalary() {
        return employeeService.getAverageSalary();
    }

    @GetMapping("/month-salaries")
    public double getMonthSalaries() {
        return employeeService.getMonthSalaries();
    }

    @GetMapping("/index-salaries")
    public Collection<Employee> indexSalaries(@RequestParam double percents) {
        return employeeService.indexSalaries(percents);
    }

    @GetMapping("/names")
    public Collection<String> getNames() {
        return employeeService.getNames();
    }

    @GetMapping("/salaries-less")
    public Collection<Employee> getEmployeesWithSalaryLessThan(double salary) {
        return employeeService.getEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/salaries-more")
    public Collection<Employee> getEmployeesWithSalaryMoreThan(double salary) {
        return employeeService.getEmployeesWithSalaryMoreThan(salary);
    }
}
