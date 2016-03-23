package lt.employees.app.rest;

import lt.employees.app.rest.response.EmployeesResponse;
import lt.employees.services.EmployeesService;
import lt.employees.services.dto.EmployeeDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeesRestApi {
	
	@Inject
	private EmployeesService employeesService;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployees() {
		List<EmployeeDTO> employees = employeesService.fetchEmployees();
		
		EmployeesResponse response = new EmployeesResponse();
		response.getEmployees().addAll(employees);
		
		return Response.status(Response.Status.OK).entity(response).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchEmployeeById(@PathParam("id") int id) {
		EmployeeDTO employee = employeesService.getEmployeeById(id);
		
		return Response.status(Response.Status.OK).entity(employee).build();
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(EmployeeDTO employee) {
		employeesService.saveEmployee(employee);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id) {
		employeesService.deleteEmployee(id);
		
		return Response.status(Response.Status.OK).build();
	}
	
}