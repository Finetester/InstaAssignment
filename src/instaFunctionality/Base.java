package instaFunctionality;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Requirement >>> Locate store names present in the section of Greater Toronto Area and print their names ?

    public class Base {
	
	WebDriver driver;
	
	public void basemethod(String browser,String url) {
		 String path=System.getProperty("user.dir");
         System.out.println("returning the location my dr>> "+ path);
		
         
         if (browser.contains("edge")) {
			System.setProperty("webdriver.edge.driver","\\driver\\msedgedriver.exe" );
			driver = new EdgeDriver();
			
		}else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver","\\driver\\geckodriver.exe" );
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");
			driver=new ChromeDriver();	
		}	
	    else {
		    System.out.println("this browser parameter is not correct : give valid input");
			System.exit(0);
		}
		
		
		if (url !=" ") {
			driver.get(url);
		}
			
	   else {
				driver.get("about:blank");
        }
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		
	    }
	
	
	public void teardown() {
		driver.quit();
	    }
	 

	public static void main(String[] args) {
		Base insta = new Base();
		insta.basemethod("edge","https://www.instacart.ca/");
		insta.teardown();

	    }

        }
