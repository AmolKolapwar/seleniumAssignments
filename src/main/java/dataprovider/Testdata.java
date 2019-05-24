package dataprovider;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.test.utilities.FileManager;

public class Testdata {
	
	
	@DataProvider(name = "setLoginData")
	public Object[][] setLoginData() throws InvalidFormatException{
		Object data[][] = FileManager.getTestData("Country");
		return data ;
	}

}
