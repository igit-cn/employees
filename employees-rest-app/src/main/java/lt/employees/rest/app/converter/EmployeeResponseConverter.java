package lt.employees.rest.app.converter;

import lt.employees.domain.entity.Employee;
import lt.employees.rest.app.response.EmployeeResponse;

/**
 * Employee Response class converter.
 */
public class EmployeeResponseConverter {

	public static EmployeeResponse convert(Employee employee) {
		EmployeeResponse result = new EmployeeResponse();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());

		if (employee.getContactInfo() != null) {
			result.setContactInfo(ContactInfoResponseConverter.convert(employee.getContactInfo()));
		}

		if (employee.getDepartment() != null) {
			result.setDepartment(DepartmentResponseConverter.convertNameInfo(employee.getDepartment()));
		}

		return result;
	}

	public static Employee convert(EmployeeResponse employeeResponse) {
		Employee result = new Employee();
		result.setId(employeeResponse.getId());
		result.setFirstName(employeeResponse.getFirstName());
		result.setLastName(employeeResponse.getLastName());

		if (employeeResponse.getContactInfo() != null) {
			result.setContactInfo(ContactInfoResponseConverter.convert(employeeResponse.getContactInfo()));
		}

		return result;
	}

	public static EmployeeResponse convertNameInfo(Employee employee) {
		EmployeeResponse result = new EmployeeResponse();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());

		return result;
	}

}
