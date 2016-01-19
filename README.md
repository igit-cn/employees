###Prepare code and database for app
1. Build entire project with maven `mvn clean install`.

2. Create database and update `employee-app/src/db/liquibase.properties` with newly created database credentials.

3. Go to `employee-app` and run liquibase command: `mvn liquibase:update`.

### Running App with maven TomEE plugin
1. Go to `employees-app` and run `mvn tomee:run`.

2. Load [localhost:8080/employees](http://localhost:8080/employees/)

### Running App on application server
You must have TomEE JAX-RS or other application server with EE features to run this app.

If you use TomEE JAX-RS application server, you can create `employees.xml` context file and put it to `{TomEE_HOME}\conf\Catalina\localhost\`.

####`employees.xml`
`<Context docBase="{PATH_TO_SOURCE}\employees-app\target\employees\" path="" reloadable="true" />`