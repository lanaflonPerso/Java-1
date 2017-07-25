package hotel.services;

import hotel.entities.Employee;
import hotel.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return this.employeeRepository.findOne(id);
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> multipleCreate(Iterable<Employee> employees) {
        return this.employeeRepository.save(employees);
    }

    @Override
    public void deleteById(long id) {
        this.employeeRepository.delete(id);
    }

}
