package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EmployeeController。
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    /** EmployeeService */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Set the EmployeeService。
     *
     * @param employeeService EmployeeService
     */
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Get all of employees。
     *
     * @return List<Employee>
     */
    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        // Get all of employees
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    /**
     * Get the employee information by employeeId。
     *
     * @param employeeId Long
     * @return Employee
     */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        // Get the employee information by employeeId
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Save the posted employee information。
     *
     * @param employee Employee
     */
    @PostMapping("/employees")
    public void saveEmployee(Employee employee){
        try {
            // Save the posted employee information
            employeeService.saveEmployee(employee);
            System.out.println("Employee Saved Successfully");
        }catch (Exception e)
        {
            // If there's any DB error, output the error log
            e.printStackTrace();
        }

    }

    /**
     * Delete the employee information by employeeId。
     *
     * @param employeeId Long
     */
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        try {
            // Delete the employee information by employeeId
            employeeService.deleteEmployee(employeeId);
            System.out.println("Employee Deleted Successfully");
        }catch (Exception e)
        {
            // If there's any DB error, output the error log
            e.printStackTrace();
        }

    }

    /**
     * Update the employee information by employeeId。
     *
     * @param employee Employee
     * @param employeeId Long
     */
    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        try {
            // Search the employee information by employeeId
            Employee emp = employeeService.getEmployee(employeeId);

            if(emp != null){
                // If the employee exists, then update the employee information
                employeeService.updateEmployee(employee);
            }else{
                // If the employee doesn't exist, then output the warning log
                System.out.println("There isn't the employee information.");
            }
        }catch (Exception e)
        {
            // If there's any DB error, output the error log
            e.printStackTrace();
        }
    }

}
