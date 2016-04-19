package lt.employees.rest.app.service;

import lt.employees.rest.app.converter.EmployeeResponseConverter;
import lt.employees.rest.app.response.EmployeeResponse;
import lt.employees.service.EmployeesService;
import lt.employees.service.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service(value = "employeesRest")
@Path("/employees")
public class EmployeesRestApi {

	@Autowired
	private EmployeesService employeesService;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployees() {
		final List<EmployeeResponse> employees =
				EmployeeResponseConverter.convertToResponse(employeesService.fetchEmployees());

		return Response.status(Response.Status.OK).entity(employees).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchEmployeeById(@PathParam("id") Long id) {
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
	public Response deleteEmployee(@PathParam("id") Long id) {
		employeesService.deleteEmployee(id);
		
		return Response.status(Response.Status.OK).build();
	}

}