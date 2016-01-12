package lt.employees.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import lt.employees.app.api.Employees;

@ApplicationPath("/rest/api")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		classes.add(Employees.class);
		
        return classes;
    }
	
}
