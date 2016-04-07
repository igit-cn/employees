package lt.employees.rest.app.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lt.employees.rest.app.converter.EmployeeResponseConverter;
import lt.employees.rest.app.response.EmployeeResponse;
import lt.employees.service.EmployeesService;
import lt.employees.service.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "employeesRest")
@Path("/employees")
public class EmployeesRestApi {

	@Autowired
	private EmployeesService employeesService;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployees() {
		final List<EmployeeResponse> employees = EmployeeResponseConverter.convert(employeesService.fetchEmployees());

		return Response.status(Response.Status.OK).entity(employees).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchEmployeeById(@PathParam("id") int id) {
		EmployeeDTO employee = employeesService.getEmployeeById(id);
		
		return Response.status(Response.Status.OK).entity(employee).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(EmployeeResponse employee) {
		employeesService.saveEmployee(EmployeeResponseConverter.convert(employee));
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id) {
		employeesService.deleteEmployee(id);
		
		return Response.status(Response.Status.OK).build();
	}

}