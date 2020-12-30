package Test;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

 

import MiHCM.HomePage;
import MiHCM.LoginPage;

 


    public class Login {

 
  	  public static WebDriver driver  = null;
  	  
	    @BeforeTest
	    public void setup() 
	    {
	      	driver= BaseClass.initilize();
	    }
  	  
  	  


        LoginPage objLogin;

 

        HomePage objHomePage;

 
        @Test(priority=0)

 

        public void test_Home_Page_Appear_Correct(){
       //  System.setProperty("webdriver.chrome.driver","C:\\seldrv\\chromedriver.exe");
                   
    //    WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
      //  driver.get("http://demo.guru99.com/V4/");
        //Create Login Page object
        objLogin = new LoginPage(driver);

 

        //Verify login page title

 

        String loginPageTitle = objLogin.getLoginTitle();

 

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

 

        //login to application

 

        objLogin.loginToGuru99("mgr123", "mgr!23");

 

        // go the next page

 

        objHomePage = new HomePage(driver);

 

        //Verify home page

 

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
        driver.close();
        driver.quit();
        }
    }