package lt.employees.rest.app.converter;

import java.util.ArrayList;
import java.util.List;

import lt.employees.rest.app.response.EmployeeResponse;
import lt.employees.service.dto.EmployeeDTO;

/**
 * Employee Response class converter.
 */
public class EmployeeResponseConverter {

	public static List<EmployeeResponse> convertToResponse(List<EmployeeDTO> employees) {
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
		if (employee.getContactInfo() != null) {
			result.setContactInfo(ContactInfoResponseConverter.convert(employee.getContactInfo()));
		}
		if (employee.getDepartment() != null) {
			result.setDepartment(DepartmentResponseConverter.convert(employee.getDepartment()));
		}

		return result;
	}

	public static EmployeeDTO convert(EmployeeResponse employeeResponse) {
		EmployeeDTO result = new EmployeeDTO();
		result.setId(employeeResponse.getId());
		result.setFirstName(employeeResponse.getFirstName());
		result.setLastName(employeeResponse.getLastName());
		if (employeeResponse.getContactInfo() != null) {
			result.setContactInfo(ContactInfoResponseConverter.convert(employeeResponse.getContactInfo()));
		}

		return result;
	}

	public static List<EmployeeDTO> convertToDTO(List<EmployeeResponse> employees) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		for (EmployeeResponse employee : employees) {
			result.add(convert(employee));
		}

		return result;
	}

}
