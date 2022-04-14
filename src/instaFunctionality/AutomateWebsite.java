package instaFunctionality;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

        public class AutomateWebsite extends Base {
        	
        public void clickshowall() {
        	//first clicking on showall button to display all the stores
			WebElement showall=driver.findElement(By.xpath("//button[@class='css-xp22gy']"));
			if (showall.isEnabled()) {
				showall.click();
			}else {
				System.out.println("Show all is not present");
			}
			
        }
		
		public void shop() {
			
			List<WebElement> storename = driver.findElements(By.xpath("//p[@class='css-3w8d2s']"));
			System.out.println("Number of stores are > "+ storename.size());
			for (int i = 0; i < storename.size(); i++) {
				String str = storename.get(i).getText();
				System.out.println(str);
		}
	
		}
		

	    public static void main(String[] args) {
		    AutomateWebsite insta = new AutomateWebsite();
		    insta.basemethod("chrome", "https://www.instacart.ca/");
		    insta.clickshowall();
     	    insta.shop();
            insta.teardown();

	   }

       }
