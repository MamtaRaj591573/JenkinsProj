package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogin 
{
	//Declaration
	@FindBy(id="email")
	private WebElement usernameTF;
	
	@FindBy(id="pass")
	private WebElement passwordTF;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgotten password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(linkText="Create new account")
	private WebElement createNewAccountLink;
	
	@FindBy(linkText="Create a Page")
	private WebElement createPageLink;
	
	//initialization
	
	public FacebookLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
//	public void setUserName(String un)
//	{
//		usernameTF.sendKeys(un);
//	}
//
//	public void setPassword(String pwd)
//	{
//		passwordTF.sendKeys(pwd);
//	}
//	public void clickLoginButton()
//	{
//		loginButton.click();
//	}
//	public void clickForgottenPassword()
//	{
//		forgotPasswordLink.click();
//	}
//	public void clickCreateNewAccount()
//	{
//		createNewAccountLink.click();
//	}
//	public void clickCreatePage()
//	{
//		createPageLink.click();
//	}

//utilization2

	public WebElement getUsernameTF() 
	{
		return usernameTF;
	}
	public WebElement getPasswordTF()
	{
		return passwordTF;
	}
	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	public WebElement getForgotPasswordLink() 
	{
		return forgotPasswordLink;
	}
	public WebElement getCreateNewAccountLink() 
	{
		return createNewAccountLink;
	}
	public WebElement getCreatePageLink()
	{
		return createPageLink;
	}
	//business logic
	public void login(String username,String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButton.click();
	}
	
	
	
	
	
	
	
	


}
