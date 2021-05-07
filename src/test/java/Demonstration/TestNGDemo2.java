package Demonstration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	
	@Test(dataProvider = "AccountsData" )
	public void logintoapp(String usernmae, String password) {
		
		System.out.println(usernmae+" "+ password);
	}
	
	
	@DataProvider(name = "AccountsData", parallel = true)
	public Object[][] useraccountsData() {
		
		
		return new Object[][] { {"mithun.r", "1234"}  };
			
		
	}
	
}
