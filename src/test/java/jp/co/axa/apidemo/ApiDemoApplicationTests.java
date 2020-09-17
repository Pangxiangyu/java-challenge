package jp.co.axa.apidemo;

import jp.co.axa.apidemo.controllers.EmployeeController;
import jp.co.axa.apidemo.entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	private final static long EMPLOYEE_ID = 1;
	private final static String EMPLOYEE_NAME = "Pang Xiangyu";
	private final static int EMPLOYEE_SALARY = 100;
	private final static String DEPARTMENT = "IT-Solution";
	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<Employee>();

	@Mock
	private EmployeeController employeeController;

	/**
	 * Initial the mock, set the Employee class for test。
	 *
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		employee.setId(EMPLOYEE_ID);
		employee.setDepartment(DEPARTMENT);
		employee.setName(EMPLOYEE_NAME);
		employee.setSalary(EMPLOYEE_SALARY);
		employees.add(employee);
	}

	/**
	 * Test the getEmployees() method。
	 * GetMapping("/employees")
	 *
	 */
	@Test
	public void getEmployees() {

		// Mock the EmployeeController class
		employeeController = Mockito.mock(EmployeeController.class);
		Mockito.when(employeeController.getEmployees()).thenReturn(employees);

		// Call the getEmployees() method for test
		List<Employee> employeesResult = employeeController.getEmployees();
		Mockito.verify(employeeController).getEmployees();

		if (!employeesResult.isEmpty()){
			// If the employeesResult isn't empty, Compare the result
			Assert.assertEquals(employee.getId(), employeesResult.get(0).getId());
			Assert.assertEquals(employee.getDepartment(), employeesResult.get(0).getDepartment());
			Assert.assertEquals(employee.getName(), employeesResult.get(0).getName());
			Assert.assertEquals(employee.getSalary(), employeesResult.get(0).getSalary());
		}
	}

	/**
	 * Test the getEmployee() method。
	 * GetMapping("/employees/{employeeId}")
	 *
	 */
	@Test
	public void getEmployee() {

		// Mock the EmployeeController class
		employeeController = Mockito.mock(EmployeeController.class);
		Mockito.when(employeeController.getEmployee(EMPLOYEE_ID)).thenReturn(employee);

		// Call the getEmployee() method for test
		Employee employeeResult = employeeController.getEmployee(EMPLOYEE_ID);
		Mockito.verify(employeeController).getEmployee(EMPLOYEE_ID);

		// Compare the result
		Assert.assertEquals(employee.getId(), employeeResult.getId());
		Assert.assertEquals(employee.getDepartment(), employeeResult.getDepartment());
		Assert.assertEquals(employee.getName(), employeeResult.getName());
		Assert.assertEquals(employee.getSalary(), employeeResult.getSalary());
	}

	/**
	 * Test the saveEmployee() method。
	 * PostMapping("/employees")
	 *
	 */
	@Test
	public void saveEmployee() {

		// Mock the EmployeeController class
		employeeController = Mockito.mock(EmployeeController.class);

		// Call the saveEmployee() method for test
		employeeController.saveEmployee(employee);
		Mockito.verify(employeeController).saveEmployee(employee);
	}

	/**
	 * Test the deleteEmployee() method。
	 * DeleteMapping("/employees/{employeeId}")
	 *
	 */
	@Test
	public void deleteEmployee() {

		// Mock the EmployeeController class
		employeeController = Mockito.mock(EmployeeController.class);

		// Call the deleteEmployee() method for test
		employeeController.deleteEmployee(EMPLOYEE_ID);
		Mockito.verify(employeeController).deleteEmployee(EMPLOYEE_ID);
	}

	/**
	 * Test the updateEmployee() method。
	 * PutMapping("/employees/{employeeId}")
	 *
	 */
	@Test
	public void updateEmployee() {

		// Mock the EmployeeController class
		employeeController = Mockito.mock(EmployeeController.class);

		// Call the updateEmployee() method for test
		employeeController.updateEmployee(employee, EMPLOYEE_ID);
		Mockito.verify(employeeController).updateEmployee(employee, EMPLOYEE_ID);
	}
}
