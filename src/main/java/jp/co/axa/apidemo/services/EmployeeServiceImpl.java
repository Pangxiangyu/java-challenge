package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EmployeeServiceImpl。
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Set the EmployeeRepository。
     *
     * @param employeeRepository EmployeeRepository
     */
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Get all of employees。
     *
     * @return List<Employee>
     */
    public List<Employee> retrieveEmployees() {
        // Get all of employees
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    /**
     * Get the employee information by employeeId。
     *
     * @param employeeId Long
     * @return Employee
     */
    public Employee getEmployee(Long employeeId) {
        // Get the employee information by employeeId
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    /**
     * Save the posted employee information。
     *
     * @param employee Employee
     */
    public void saveEmployee(Employee employee){
        // Save the posted employee information
        employeeRepository.save(employee);
    }

    /**
     * Delete the employee information by employeeId。
     *
     * @param employeeId Long
     */
    public void deleteEmployee(Long employeeId){
        // Delete the employee information by employeeId
        employeeRepository.deleteById(employeeId);
    }

    /**
     * Update the employee information by employeeId。
     *
     * @param employee Employee
     */
    public void updateEmployee(Employee employee) {
        // Update the employee information by employeeId
        employeeRepository.save(employee);
    }
}