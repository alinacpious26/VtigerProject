package testPackage;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DataUtilities;

public class DataSupply {
	@DataProvider(name="userCredentials")
	public Object[][] userData(){
		return new Object[][] {
			{"resbin@gmail.com","resbin@123"},
			{"siva@gmail.com","siva@123"},
			{"sreekanth@gmail.com","sreekanth@123"},
			{"athulya@gmail.com","athulya@123"}
		};
	}
		@DataProvider(name="userCredentials1")
		public Object[][] userData1(){
			return new Object[][] {
				{"sneha@gmail.com","sneha@123"},
				{"pious@gmail.com","pious@123"},
				{"helen@gmail.com","helen@123"},
				{"hari@gmail.com","hari@123"}
			};
	}
		@DataProvider(name="ContactDetails")
		public Object[][] contactData(){
			return new Object[][] {
				{"Mrs.","Rani","Mathew","Cold Call","Teacher","Education","rani@gmail.com","8745674567"},
				{"Mr.","Nayan","Pious","Employee","Software Developer","IT","nayan@gmail.com","8747834567"},
				{"Dr.","Mareena","Pious","Self Generated","Cardic Surgeon","Health","mareena@gmail.com","8942367567"}
				
			};
		}
		@DataProvider(name="databaseContactDetails")
		public Object[][] databaseContact(){
			

		
			DataUtilities du = new DataUtilities();
			ArrayList<Object[]> result = du.getDataFromDatabase("select * from contacts");
			return result.toArray(new Object[0][]);
			
		}
		
		@Test(dataProvider = "databaseContactDetails")
		public void contactDetails(String salutation,String firstname,String lastname,String leadsrc,String title,String email,String mobNo,String department) {
			
		}
			

		@Test(dataProvider = "userCredentials")
		public void printData(String username,String password) {
			System.out.println(username);
			System.out.println(password);
		}
}
