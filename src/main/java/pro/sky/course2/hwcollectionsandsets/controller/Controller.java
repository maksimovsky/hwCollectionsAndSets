package pro.sky.course2.hwcollectionsandsets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.hwcollectionsandsets.Employee;
import pro.sky.course2.hwcollectionsandsets.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    private  final EmployeeServiceImpl service;

    public Controller(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getList() {
        return service.getList();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.findEmployee(firstName, lastName);
    }
}
