### Running App
You must have TomEE or other application server with EE features to run this app.

If you use TomEE application server, you can create `employees.xml` context file and put it to `{TomEE_HOME}\conf\Catalina\localhost\`.

####`employees.xml`
`<Context docBase="{PATH_TO_SOURCE}\employees-app\target\employees\" path="" reloadable="true" />`