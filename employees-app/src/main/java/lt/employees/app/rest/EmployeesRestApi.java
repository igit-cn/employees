package lt.employees.app.rest;

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

import lt.employees.app.rest.response.EmployeesResponse;
import lt.employees.services.EmployeesService;
import lt.employees.services.dto.EmployeeDTO;

@Path("/employees")
public class EmployeesRestApi {

	private EmployeesService employeesService;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployees() {
		List<EmployeeDTO> employees = employeesService.fetchEmployees();
		
		EmployeesResponse response = new EmployeesResponse();
		for (EmployeeDTO employee : employees) {
//			final Link link = Link.fromMethod(getClass(), "fetchEmployeeById").build(employee.getId());
			response.addEmployee(employee);
		}

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
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(EmployeeDTO employee) {
		employeesService.saveEmployee(employee);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int id) {
		employeesService.deleteEmployee(id);
		
		return Response.status(Response.Status.OK).build();
	}

	public void setEmployeesService(final EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
}