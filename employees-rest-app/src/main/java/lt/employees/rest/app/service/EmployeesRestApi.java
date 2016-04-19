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
import lt.employees.rest.app.converter.NameInfoConverter;
import lt.employees.rest.app.response.EmployeeResponse;
import lt.employees.rest.app.response.NameInfoResponse;
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

	@GET
	@Path(("nameInfo"))
	@Produces({MediaType.APPLICATION_JSON})
	public Response fetchEmployeesNameInfo() {
		final List<NameInfoResponse> EmployeesNameInfoResponses = NameInfoConverter.convertToResponse(employeesService.fetchEmployeesNameInfo());

		return Response.status(Response.Status.OK).entity(EmployeesNameInfoResponses).build();
	}

}