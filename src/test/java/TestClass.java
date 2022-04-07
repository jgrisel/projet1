import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	
	@Test
	public void test() throws Exception {
		//Initialisation du driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jgrisel\\eclipse-workspace\\Projet1\\src\\main\\resources\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//initialiser le fichier.properties
		Properties propertyJDD = new Properties();
	    propertyJDD.load(new FileInputStream("C:\\Users\\jgrisel\\eclipse-workspace\\Projet1\\src\\main\\resources\\JDD.properties\\JDD.properties"));
	    
	    //aller sur le site du challenge
	    driver.get(propertyJDD.getProperty("URL"));
	    driver.manage().window().maximize();
	}

}
