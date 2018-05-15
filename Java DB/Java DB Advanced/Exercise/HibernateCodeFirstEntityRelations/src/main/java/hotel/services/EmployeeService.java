package hotel.services;

import hotel.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    Employee create(Employee employee);

    List<Employee> multipleCreate(Iterable<Employee> employees);

    void deleteById(long id);
}
