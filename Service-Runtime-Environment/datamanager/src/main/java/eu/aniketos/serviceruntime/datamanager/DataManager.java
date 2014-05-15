package eu.aniketos.serviceruntime.datamanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataManager {

	private static String connectionString = null;
	
    public static String getConnectionString() {
        if (connectionString == null) {
            Properties prop = new Properties();     
            try {
                prop.load(new FileInputStream(new File(System.getProperty("user.home"), "sre_db.properties")));
                connectionString = prop.getProperty("dbconnstring");
            } catch (IOException ex) {
                ex.printStackTrace();
            }        
        }
        return connectionString;
    }
    
	public static void addResult(String processId, String variableName, String variableResult) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(getConnectionString());
			preparedStatement = connection.prepareStatement(
					"insert into results values (default, ?, ?, ?)");
			preparedStatement.setString(1, processId);
		    preparedStatement.setString(2, variableName);
		    preparedStatement.setString(3, variableResult);	
		    preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Failed to store result: " + ex.getMessage());
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception ex) {
				
			}
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				
			}			
		}
	}
	
	public static String [] getResults(String processId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(getConnectionString());
			preparedStatement = connection.prepareStatement(
					"select * from results where instanceId=? order by id");
			preparedStatement.setString(1, processId);
			resultSet = preparedStatement.executeQuery();
			
			List<String> results = new ArrayList<String>();
			
			while (resultSet.next()) {
				String variableName = resultSet.getString("variableName");
				String variableResult = resultSet.getString("variableResult");
				
				results.add(variableName + "=" + variableResult);				
			}
			
			return results.toArray(new String[0]);
			
		} catch (Exception ex) {
			System.out.println("Failed to retrieve result: " + ex.getMessage());
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception ex) {
				
			}
			
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception ex) {
				
			}			
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				
			}			
		}
		return null;
	}	
    
	public static String getProcessId(String serviceId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(getConnectionString());
			preparedStatement = connection.prepareStatement(
					"select * from services where service=?");
			preparedStatement.setString(1, serviceId);
			resultSet = preparedStatement.executeQuery();
			
			List<String> results = new ArrayList<String>();
			
			if (resultSet.next()) {
				return resultSet.getString("processId");
			}
			
			return null;
			
		} catch (Exception ex) {
			System.out.println("Failed to retrieve result: " + ex.getMessage());
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception ex) {
				
			}
			
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception ex) {
				
			}			
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				
			}			
		}
		return null;
	}	    
}
