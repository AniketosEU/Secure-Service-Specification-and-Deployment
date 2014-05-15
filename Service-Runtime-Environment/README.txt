Service Runtime Engine Bundles
-serviceruntimeremote (MAVEN): Bundle that provides a service that connects SCF with SRE. Communicates with Tomcat and Activiti to upload processes and deploy composite web services.
-serviceruntimedata(MAVEN): Bundle that provides DataAdapter class for persisting and retrieving data from the aniketos-runtime database. It requires the sre-datasource-mysql.xml file, which must be copied into Karaf's deploy directory.
-serviceruntimeremotefeature (MAVEN): Karaf feature for SRE
-datamanager (MAVEN): Project for creating the datamanager jar to be used in Tomcat by Activiti and Composite Web Services. It provides access to the SRE database.