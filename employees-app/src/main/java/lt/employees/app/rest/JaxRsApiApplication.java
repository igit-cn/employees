package lt.employees.app.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class JaxRsApiApplication extends Application {

    @Inject
    private Employees employeesApi;

    @Produces
    private JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>(Arrays.asList(
                employeesApi,
                jacksonJsonProvider
        ));
    }
}
