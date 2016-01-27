#Arcus

#### Prerequisites

The following softwares are required to run Arcus in local:
 
1. Brew (http://brew.sh/)
2. Maven 3.x ( brew install maven)
3. JDK 1.8 (brew install java)
4. Git (brew install git)
5. [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars1 "Eclipse")/intellij

#### Setting up Arcus in local environment

1. Create workspace folder (ex: `mkdir ~\workspace` )
2. Clone arcus code base (`git clone https://github.com/aqitrade/arcus.git`) 
3. Change directory to arcus (`cd arcus`)
4. Run `mvn clean install`
5. Change directory to arcus-web (`cd arcus-web`)
6. Run Jetty server (`mvn jetty:run`)
7. Arcus should be up and running in port 8080 and you can access 
	arcus REST service catalog using this [ link ](http://localhost:8080/arcus/swagger-ui.html) 

### JPA entities code generation
1. Update eclipse from site http://www.telosys.org/eclipse/v210 or From Eclipse market place, install Telosys Tools 2.1.1
2. Double click MYSQL.dbrep file from arcus-data/TelosysTools folder
3. Select table name from the drop down
4. Select the Generation tab and choose persistence-jpa from the drop down
5. Check JPA Entities and click generate button.
6. Entity class should be generated into com.aqitrade.arcus.data.entity package. 

