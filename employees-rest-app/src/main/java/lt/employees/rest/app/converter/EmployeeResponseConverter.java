package lt.employees.rest.app.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.rest.app.response.EmployeeResponse;
import lt.employees.service.dto.EmployeeDTO;

/**
 * Employee Response class converter.
 */
public class EmployeeResponseConverter {

	public static List<EmployeeResponse> convert(List<EmployeeDTO> employees) {
		List<EmployeeResponse> result = new ArrayList<EmployeeResponse>();

		for (EmployeeDTO employee : employees) {
			result.add(convert(employee));
		}

		return result;
	}

	public static EmployeeResponse convert(EmployeeDTO employee) {
		EmployeeResponse result = new EmployeeResponse();
		result.setId(employee.getId());
		result.setFirstName(employee.getFirstName());
		result.setLastName(employee.getLastName());
		result.setAddress(AddressResponseConverter.convert(employee.getAddress()));

		return result;
	}

	public static EmployeeDTO convert(EmployeeResponse employeeResponse) {
		EmployeeDTO result = new EmployeeDTO();
		result.setId(employeeResponse.getId());
		result.setFirstName(employeeResponse.getFirstName());
		result.setLastName(employeeResponse.getLastName());
		result.setAddress(AddressResponseConverter.convert(employeeResponse.getAddress()));

		return result;
	}

}
