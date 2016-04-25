package lt.employees.rest.app.service;

import java.util.ArrayList;
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

import lt.employees.domain.entity.Department;
import lt.employees.rest.app.converter.DepartmentResponseConverter;
import lt.employees.rest.app.response.DepartmentResponse;
import lt.employees.service.DepartmentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Rest Service for departments.
 */
@Service(value = "departmentsRest")
@Path("/departments")
public class DepartmentsRestApi {

    @Autowired
    private DepartmentsService departmentsService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response fetchDepartments() {
        List<DepartmentResponse> departments = new ArrayList<DepartmentResponse>();
        for (Department department : departmentsService.fetchDepartments()) {
            departments.add(DepartmentResponseConverter.convert(department));
        }

        return Response.status(Response.Status.OK).entity(departments).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchDepartmentById(@PathParam("id") Long id) {
        final DepartmentResponse response = DepartmentResponseConverter.convert(departmentsService.getDepartmentById(id));

        return Response.status(Response.Status.OK).entity(response).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveDepartment(DepartmentResponse department) {
        departmentsService.saveDepartment(DepartmentResponseConverter.convert(department));

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDepartment(@PathParam("id") Long id) {
        departmentsService.deleteDepartment(id);

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("nameInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public Response fetchDepartmentsNameInfo() {
        List<DepartmentResponse> departments = new ArrayList<DepartmentResponse>();
        for (Department department : departmentsService.fetchDepartments()) {
            departments.add(DepartmentResponseConverter.convertNameInfo(department));
        }

        return Response.status(Response.Status.OK).entity(departments).build();
    }

}
