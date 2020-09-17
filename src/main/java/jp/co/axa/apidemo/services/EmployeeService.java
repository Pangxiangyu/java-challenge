package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

/**
 * Employee Service。
 */
public interface EmployeeService {

    /**
     * Get all of employees。
     *
     * @return List<Employee>
     */
    public List<Employee> retrieveEmployees();

    /**
     * Get the employee information by employeeId。
     *
     * @param employeeId Long
     * @return Employee
     */
    public Employee getEmployee(Long employeeId);

    /**
     * Save the posted employee information。
     *
     * @param employee Employee
     */
    public void saveEmployee(Employee employee);

    /**
     * Delete the employee information by employeeId。
     *
     * @param employeeId Long
     */
    public void deleteEmployee(Long employeeId);

    /**
     * Update the employee information by employeeId。
     *
     * @param employee Employee
     */
    public void updateEmployee(Employee employee);
}