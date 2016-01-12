package lt.employees.app.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lt.employees.app.response.EmployeesResponse;
import lt.employees.services.EmployeesService;
import lt.employees.services.dto.EmployeeDTO;

@Path("/employees")
public class Employees {
	
	@Inject
	private EmployeesService employessSevice;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployees() {
		List<EmployeeDTO> employees = employessSevice.fetchEmployees();
		
		EmployeesResponse response = new EmployeesResponse();
		response.getEmployees().addAll(employees);
		
		return Response.status(Response.Status.OK).entity(response).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchEmployeeById(@PathParam("id") int id) {
		EmployeeDTO employee = employessSevice.getEmployeeById(id);
		
		return Response.status(Response.Status.OK).entity(employee).build();
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(EmployeeDTO employee) {
		employessSevice.saveEmployee(employee);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id) {
		employessSevice.deleteEmployee(id);
		
		return Response.status(Response.Status.OK).build();
	}
	
}