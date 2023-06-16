package pro.sky.course2.hwcollectionsandsets.model;

import org.apache.commons.lang3.StringUtils;
import pro.sky.course2.hwcollectionsandsets.exception.WrongDepartmentException;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private double salary;
    private int department;

    public Employee(String firstName, String lastName, double salary, int department) {
        if (department < 1 || department > 5) {
            throw new WrongDepartmentException();
        }
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new WrongDepartmentException();
        }
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "ФИ: " + firstName + " " + lastName;
    }
}
