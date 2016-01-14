### Running App with maven TomEE plugin
To run app with plugin:

1. Build entire project with maven `mvn clean install`.

2. Go to employees-app and run `mvn tomee:run`.

### Running App on application server
You must have TomEE JAX-RS or other application server with EE features to run this app.

If you use TomEE JAX-RS application server, you can create `employees.xml` context file and put it to `{TomEE_HOME}\conf\Catalina\localhost\`.

####`employees.xml`
`<Context docBase="{PATH_TO_SOURCE}\employees-app\target\employees\" path="" reloadable="true" />`