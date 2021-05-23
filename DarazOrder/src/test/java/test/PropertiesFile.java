package test;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) {
		
		getProperties()
		
	}

		public static void getProperties() {
			
			try {
				
				//Create a object for class properties 
				Properties prop = new Properties();
				
				String projectPath = System.getProperty("user.dir");
				//create a object for class inputStream
				inputStream input = new FileInputStream("./DarazOrder/src/test/java/test/config.properties");
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
	}

}
