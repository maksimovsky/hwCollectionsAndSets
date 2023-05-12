package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.hwcollectionsandsets.model.Employee;
import pro.sky.course2.hwcollectionsandsets.service.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping
public class Controller {
    private final EmployeeServiceImpl service;

    public Controller(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public Collection<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam double salary, @RequestParam int department) {
        return service.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping("/employee/set-salary")
    public Employee setSalary(@RequestParam String firstName, @RequestParam String lastName,
                              @RequestParam double salary) {
        return service.setSalary(firstName, lastName, salary);
    }

    @GetMapping("/employee/set-department")
    public Employee setDepartment(@RequestParam String firstName, @RequestParam String lastName,
                                  @RequestParam int department) {
        return service.setDepartment(firstName, lastName, department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary() {
        return service.getEmployeeWithMinSalary();
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary() {
        return service.getEmployeeWithMaxSalary();
    }

    @GetMapping("/average-salary")
    public double getAverageSalary() {
        return service.getAverageSalary();
    }

    @GetMapping("/month-salaries")
    public double getMonthSalaries() {
        return service.getMonthSalaries();
    }

    @GetMapping("/index-salaries")
    public void indexSalaries(@RequestParam double percents) {
        service.indexSalaries(percents);
    }

    @GetMapping("/names")
    public Collection<String> getNames() {
        return service.getNames();
    }

    @GetMapping("/salaries-less")
    public Collection<Employee> getEmployeesWithSalaryLessThan(double salary) {
        return service.getEmployeesWithSalaryLessThan(salary);
    }

    @GetMapping("/salaries-more")
    public Collection<Employee> getEmployeesWithSalaryMoreThan(double salary) {
        return service.getEmployeesWithSalaryMoreThan(salary);
    }

    @GetMapping("/departments/all")
    public Collection<Employee> getEmployeesInDepartments() {
        return service.getEmployeesInDepartments();
    }

    @GetMapping(path = "/departments/all", params = "department")
    public Collection<Employee> getEmployeesInDepartment(@RequestParam int department) {
        return service.getEmployeesInDepartment(department);
    }

    @GetMapping("/departments/min-salary")
    public Employee getEmployeeWithMinSalaryInDepartment(@RequestParam int department) {
        return service.getEmployeeWithMinSalaryInDepartment(department);
    }

    @GetMapping("/departments/max-salary")
    public Employee getEmployeeWithMaxSalaryInDepartment(@RequestParam int department) {
        return service.getEmployeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping("/departments/average-salary")
    public double getAverageSalaryInDepartment(@RequestParam int department) {
        return service.getAverageSalaryInDepartment(department);
    }

    @GetMapping("/departments/month-salaries")
    public double getMonthSalariesInDepartment(@RequestParam int department) {
        return service.getMonthSalariesInDepartment(department);
    }

    @GetMapping("/departments/index-salaries")
    public void indexSalariesInDepartment(int department, double percents) {
        service.indexSalariesInDepartment(department, percents);
    }
}
