## Setting up Arcus project in local

1. Create workspace folder (ex: `mkdir ~\workspace` )
2. Clone arcus code base (`git clone https://github.com/aqitrade/arcus.git`) 
3. Change director to arcus (`cd arcus`)
4. Run `mvn clean install`
5. Change directory to arcus-web (`cd arcus-web`)
6. Run Jetty server (`mvn jetty:run`)
7. Arcus should be up and running in port 8080 and you can access 
	arcus REST service catalog using this [ link ](http://localhost:8080/arcus/swagger-ui.html) 
