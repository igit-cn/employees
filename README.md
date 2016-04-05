###Prepare code and database for Rest App
1. Build entire project with maven `mvn clean install` or run `build.bat`.

2. Run mysql server, update `employee-rest-app/src/db/liquibase.properties` with mysql credentials.

3. Run `run-liquibase.bat` or go to `employee-rest-app` and run liquibase command: `mvn liquibase:update`.

### Running Rest App with maven Tomcat plugin
1. Run `run-rest-app.bat` or go to `employees-rest-app` and run `mvn clean tomcat7:run-war`.

2. Load [localhost:8080/employees](http://localhost:8080/employees/)

### Running Rest App on application server
You can run app without maven tomcat plugin. Simply copy `employees.war` from `{project_home}/employees-rest-app/target` directory to
`{tomcat_home}/webapp` directory and run server. Also you must create context.xml with database connection or you can take it from
`{project-home}/employees-rest-app/target/tomcatconf/context.xml`.

### Running UI Application
To run UI App you must have Node JS installed and Bash (Git bash for example).
You can run server in bash, go to `{project_home}/employees-ui` and execute `npm start`.

Open url: `http://localhost:8000/app/index.html`