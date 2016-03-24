package lt.employees.app.rest.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lt.employees.services.dto.EmployeeDTO;

@XmlRootElement
public class EmployeesResponse {

	@XmlElement
	private List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

	public void addEmployee(EmployeeDTO employee) {
		employees.add(employee);
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
}
