Secure-Service-Specification-and-Deployment
============================================

##Short description

The Secure Service Specification and Deployment package offers the possibility to model the composite service's BPMN process and to specify the desired security requirements. It also supports the service discovery and enables the packaging and deployment of the security enriched composite service specification. 

##Overview

This package enables modelling the process of a composite service and configuring the security requirements with respect to the components comprising the composite service specification. It also enables deploy a composite service specification, which is extended with security properties by offering management functionalities for the maintenance of a list of services, which are described, based on their security properties. For each service, the functional specification is enriched with security characteristics, detailing the level of security that can be supported by the specific service.
The package offers the possibility to publish Aniketos compliant services to a service registry and supports searching in this registry to discover the most appropriate service descriptions, which comply with a set of security requirements.
Currently, a set of security properties are supported, which have to do with the trustworthiness, the separation and binding of duty, the confidentiality, the non-repudiation and the integrity.

##Requirements

###Build

The SSSD package requires [JDK 1.7](http://www.oracle.com/technetwork/java/javaee/downloads/java-archive-downloads-eesdk-419427.html#java_ee_sdk-6-oth-JPR). To build and execute all packages [Eclipse for RCP and RAP Developers, Juno or above](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/juno/SR2/eclipse-rcp-juno-SR2-win32.zip) and apache Maven (http://maven.apache.org/) are required.

###Run

The modules contained inside the Service Composition Framework run as Eclipse plugins, and they can be executed all together through the Eclipse RCP application configuration.
The Service Runtime Environment module has to be executed in [Apache Karaf](https://karaf.apache.org/index/community/download/archives.html#Karaf2.3.1). Details of how to do this are provided below.

##Features

The open source SSSD package provides the following features:

* BPMN modeling of the composite service.
* Modeling of multiple security properties:
 * Confidentiality requirements.
 * Integrity requirement.
 * Separation of Duty (not currently part of the open source release).
 * Binding of Duty (not currently part of the open source release).
* Creation of a BPMN model skeleton from the SRS file (generated through the Socio Technical Security Requirements package).
* Add of the SRS's security requirements to an already existent BPMN model.
* Discovery of services into the Marketplace.
* Creation of several functionally equivalent composition plans based on the number of discovered atomic services.
* Creation of consumer policies through the conspec editor (not currently part of the open source release).
* Creation of agreement templates through the conspec editor (not currently part of the open source release)
* Definition of rules expressing the behaviour of the composite service at runtime.
* Packaging and deploy of the composite service.

##How to get started

###Build the modules

####Service Composition Framework
1. Check out everything from the Service Composition Framework folder into a fresh Eclipse workspace.

####Service Runtime Environement
1. Check out everything from the Service Runtime Environement repository into a fresh Eclipse workspace.
2. Import [Apache CXF DOSGi RI 1.3](http://search.maven.org/remotecontent?filepath=org/apache/cxf/dosgi/cxf-dosgi-ri-singlebundle-distribution/1.3/cxf-dosgi-ri-singlebundle-distribution-1.3.jar) as a project into the workspace.
3. Call ```maven install``` for each package.

###Execute the modules:

####Service Composition Framework
Prerequisites:
* Marketplace (see https://github.com/AniketosEU/Security-Service-Validation-and-Verification)
* Service Runtime Environment

1. Open the org.activiti.designer.elsag project
2. Open the file org.activiti.designer.scf.product
3. Click on the "Launch an Eclipse application" in the Overview tab.

####Service Runtime Environment
Prerequisites:
* Notification Service (see https://github.com/AniketosEU/Security-Monitoring-and-Notification)
* Marketplace (see https://github.com/AniketosEU/Security-Service-Validation-and-Verification)
* SCPM (see https://github.com/AniketosEU/Security-Service-Validation-and-Verification)
* Activiti

Install the Activiti war files activiti-explorer.war and activiti-rest.war(http://activiti.org/) in a Apache Tomcat instance.
Then the following two files need to be modified:
	- activiti-explorer/WEB-INF/classes/db.properties
	- activiti-rest/WEB-INF/classes/db.properties
The content of these two files should be:
```
db=mysql
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/activiti?autoReconnect=true
jdbc.username=username
jdbc.password=password
```

A change is also required to:
activiti-explorer/WEB-INF/activiti-standalone-context.xml

In the demoDataGenerator bean it is recommended to initially set the createDemoUsersAndGroups to true and all other properties to false.
```
<bean id="demoDataGenerator" 
      class="org.activiti.explorer.demo.DemoDataGenerator" init-method="init">
    <property name="processEngine" ref="processEngine" />
    <property name="createDemoUsersAndGroups" value="false" />
    <property name="createDemoProcessDefinitions" value="false" />
    <property name="createDemoModels" value="false" />
</bean>
```

After these changes have been performed one must either reload activity-explorer and activity-rest applications or restart Tomcat. Activiti will create the necessary tables on the first run. One can connect to the explorer application using kermit as username and password. A new user can be created and the demo users deleted or the password can also be modified.
The Activiti installation must be extended with a module that is responsible for communicating with SPMM. This extension module consists of two jar files. The first one is called aniketosDelegation.jar and is generated by XXXXX. This jar file provides the SPMM listener. In order for this listener to be effective a property must be added in the processEngineConfiguration bean in activiti-standalone-context.xml file:
```
<bean id="processEngineConfiguration" class="org.activiti.spring.SpringProcessEngineConfiguration">
  <property name="dataSource" ref="dataSource" />
  <property name="transactionManager" ref="transactionManager" />
  <property name="databaseSchemaUpdate" value="true" />
  <property name="jobExecutorActivate" value="true" />
  <property name="customFormTypes">
    <list>
      <bean class="org.activiti.explorer.form.UserFormType"/>   
    </list>
  </property>
	
  <!--  SPMM Listener -->
  <property name="customPostBPMNParseListeners">
    <list>
      <bean class="eu.aniketos.spmm.handler.ParseListener"></bean>
    </list>
  </property>	
</bean>
```

This jar also provides the AniketosClientDelegation class that is required by the composition plans created by SCF.
Connection to the SRE database is performed through the dataManager.jar. This jar file is created by the project https://github.com/AniketosEU/Secure-Service-Specification-and-Deployment/tree/master/Service-Runtime-Environment/datamanager. 
The database connection string is defined in the sre_db.properties file:
```
dbconnstring=jdbc:mysql://localhost:3306/aniketos_runtime?user=user&password=pass
```
This file can must be placed in the user’s home directory (C:\Users\username in Windows and /home/username in Linux).
Both these jar files (aniketosDelegation.jar, datamanager-1.0-SNAPSHOT.jar) must be copied to activity-explorer/WEB-INF/lib and activity-rest/WEB-INF/lib folders. After copying the files the web applications must be reloaded.

The Service Runtime Engine OSGi module requires a MySQL database. The commands for creating the database and importing the structure are:
```
create database aniketos_runtime;
mysql -u root -p < aniketos_runtime.sql
```

The data source configuration file is as follows:
```
<?xml version="1.0" encoding="UTF-8"?>
<blueprint xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0">  
  
  <bean id="mysqlDataSource" 
        class="com.mysql.jdbc.jdbc2.optional.MysqlDataSource">
    <property name="url" value="jdbc:mysql://localhost:3306/aniketos_runtime"/>
      <property name="user" value="username"/>
      <property name="password" value="password"/>
  </bean>
  
  <bean id="mysqlXADataSource" 
        class="com.mysql.jdbc.jdbc2.optional.MysqlXADataSource">
    <property name="url" value="jdbc:mysql://localhost:3306/aniketos_runtime"/>
    <property name="user" value="username"/>
    <property name="password" value="[assword"/>
  </bean>  
  
  <service interface="javax.sql.DataSource" ref="mysqlDataSource">
    <service-properties>
      <entry key="osgi.jndi.service.name" value="jdbc/sredb"/>
    </service-properties>
  </service>
  
  <service interface="javax.sql.XADataSource" ref="mysqlXADataSource">
    <service-properties>
      <entry key="osgi.jndi.service.name" value="jdbc/xasredb" />
    </service-properties>
  </service>  
	
</blueprint>
```

After the database has been created and the data source bundle is deployed, the SRE feature can be installed in Apache Karaf 2.3.1(https://karaf.apache.org/index/community/download/archives.html#Karaf2.3.1). with the following commands:
```
features:addUrl mvn:eu.aniketos.serviceruntime/feature/1.0.0-SNAPSHOT/xml/features
features:install serviceruntimeremote
```

The SRE feature doesn’t start two bundles upon installation. These bundles must be started manually:
* jersey-json (1.17.0)
* Aniketos Service Runtime Remote Bundle (1.0.0.SNAPSHOT)
When Service Runtime Feature is installed, the SRE Web Service will be available at http://localhost:9079/sre?wsdl

The SRE module requires some configuration in order to be able to connect to Activiti and Tomcat to deploy process diagrams and composite web services. This configuration is performed through the eu.aniketos.serviceruntime.remote.cfg file that must be placed in the etc folder of Karaf. The contents of this file may include:
```
activiti.address=http://localhost:8081/
activiti.username=kermit
activiti.password=aniketos
tomcat.address=http://localhost:8081/
tomcat.username=tomcatscript
tomcat.password=tomcat
tomcat.version=6
tomcat.publicAddress=http://hestia.atc.gr/
```

##Contributing (guide)

Bugs, suggestions and issues can be submitted through the Github [issue tracker]
https://github.com/AniketosEU/Secure-Service-Specification-and-Deployment/issues

##Modules

The SSSD package is comprised of the following modules:

###SCF

The Service Composition Framework allows a service designer to model the composite service's BPMN process and to specify the desired security requirements. It also supports the discovery of the web services available in the Marketplace and enables the packaging and deployment of the security enriched composite service specification to the SRE. 

###MTM

The Model Transformation Module (MTM) is the module responsible to extract the Security Requirements Specification (SRS) coming from STS-Tool (see https://github.com/AniketosEU/Socio-technical-Security-Requirements) and transform it to other formats that are needed by other Aniketos modules, i.e., the service specification and the consumer policies.

###SCPM Client View

This module provides the GUI client for the invocation of the SCPM relased in package SSVV(https://github.com/AniketosEU/Security-Service-Validation-and-Verification).

###SRE

The Service Runtime Enviroment module's tasks are to: expose a Web Service that is consumed from the Service Composition Framework (SCF) for the deployment of composite services, deploy composition plans (BPMN) to the Activiti Engine, dynamically generate the composite services WAR files, subscribe to notification events for composite and atomic services and trigger re-composition and re-configuration whenever it is required.

##Example usage

The general steps for using these services are:

1. Model a BPMN service composition using the Service Composition Framework.
2. Add security requirements to the service specification.
3. Use the SCPM interface integrated into the Service Composition Framework to call the SSVV package toolchain in order to verify the service security properties.
4. Choose the service you want to execute based on the security results.
5. Deploy the composite service to the Service Runtime Environment
6. Profit!

##Credits

The various modules that make up the SSVV package have been developed by a number of organisations:

1. SCF developed by [SELEX](http://www.selex-es.com/).
2. MTM developed by [TECNALIA] (http://www.tecnalia.com).
3. SRE developed by [ATC] (http://www.atc.gr).
4. SRCM developed by [UNITN] (http://www.unitn.it).
5. SCPM client developed by [LJMU] (http://www.ljmu.ac.uk).

##Official site, external resources

Please see the [Aniketos project website](http://aniketos.eu/) for more details.

##About the developers

The initial code for this project was developed as part of the [Aniketos project]((http://aniketos.eu/)), partly funded by the European Community's Seventh Framework Programme under grant agreement no. 257930.

##Updates and list of known issues

For changes please see the [commit history](https://github.com/AniketosEU/Security-Service-Validation-and-Verification/commits/master).

For known issues please see the [issue tracker](https://github.com/AniketosEU/Security-Service-Validation-and-Verification/issues) (and let us know if you find any more please!).
