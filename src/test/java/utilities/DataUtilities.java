package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import base.BaseTest;

public class DataUtilities {
	
	
	public String ReadWebElementProperties(String sWebElementKey) throws IOException {
		BaseTest.sProperties = new Properties();
		FileInputStream fis = new FileInputStream(AppConstants.WEBELE_PROPERTYFILE_PATH);
		BaseTest.sProperties.load(fis);

		return BaseTest.sProperties.getProperty(sWebElementKey);
		
	}
	
	public String ReadAccountProperties(String AccountFeildType) throws IOException {
		BaseTest.sProperties = new Properties();
		FileInputStream fis = new FileInputStream(AppConstants.USERACCOUNTS_PROPERTYFILE_PATH);
		BaseTest.sProperties.load(fis);
		return BaseTest.sProperties.getProperty(AccountFeildType);
		
	}
	
	public String ReadPageURLproperties(String PageURLKey) throws IOException {
		BaseTest.sProperties = new Properties();
		FileInputStream fis = new FileInputStream(AppConstants.USERACCOUNTS_PROPERTYFILE_PATH);
		BaseTest.sProperties.load(fis);
		return BaseTest.sProperties.getProperty(PageURLKey);
		
	}
	
	
	

}
