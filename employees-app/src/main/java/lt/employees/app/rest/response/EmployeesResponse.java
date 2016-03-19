package lt.employees.app.rest.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lt.employees.services.dto.EmployeeDTO;

@XmlRootElement
public class EmployeesResponse {
	
	private List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

	@XmlElement
	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

}
