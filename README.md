###Prepare code and database for app
1. Build entire project with maven `mvn clean install` or run `build.bat`.

2. Run mysql server, update `employee-app/src/db/liquibase.properties` with mysql credentials.

3. Run `run-liquibae.bat` or go to `employee-app` and run liquibase command: `mvn liquibase:update`.

### Running App with maven Tomcat plugin
1. Run `run-app.bat` or go to `employees-app` and run `mvn clean tomcat7:run-war`.

2. Load [localhost:8080/employees](http://localhost:8080/employees/)

### Running App on application server
You can run app without maven tomcat plugin. Simply copy `employees.war` from `{project_home}/employees-app/target` directory to
`{tomcat_home}/webapp` directory and run server. Also you must create context.xml with database connection or you can take it from
`{project-home}/employees-app/target/tomcatconf/context.xml`.