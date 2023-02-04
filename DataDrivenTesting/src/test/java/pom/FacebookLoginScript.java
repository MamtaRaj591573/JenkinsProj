package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginScript 
{

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FacebookLogin obj=new FacebookLogin(driver);
//		obj.setUserName("mamta");
//		obj.setPassword("1234");
//		obj.clickLoginButton();
		obj.login("mamta","1234");
		Thread.sleep(1000);
		driver.quit();
	}

}
