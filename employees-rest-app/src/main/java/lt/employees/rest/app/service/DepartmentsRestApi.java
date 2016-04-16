package lt.employees.rest.app.service;

import lt.employees.rest.app.converter.DepartmentResponseConverter;
import lt.employees.rest.app.response.DepartmentResponse;
import lt.employees.service.DepartmentsService;
import lt.employees.service.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
        List<DepartmentResponse> departments = DepartmentResponseConverter.convert(departmentsService.fetchDepartments());

        return Response.status(Response.Status.OK).entity(departments).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchDepartmentById(@PathParam("id") int id) {
        DepartmentDTO department = departmentsService.getDepartmentById(id);

        return Response.status(Response.Status.OK).entity(department).build();
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
    public Response deleteDepartment(@PathParam("id") int id) {
        departmentsService.deleteDepartment(id);

        return Response.status(Response.Status.OK).build();
    }

}
