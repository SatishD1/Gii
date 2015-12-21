package Gii_DemoScript;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.File;

import org.openqa.jetty.html.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.App;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Image;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Region;
import org.sikuli.script.FindFailed;
import org.sikuli.util.EventObserver;
import org.sikuli.util.EventSubject;
import org.sikuli.util.OverlayCapturePrompt;

import java.util.regex.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GiiLogin {
	

    public static void main(String[] args) throws Exception 
    
    {
    	// TODO Auto-generated method stub

    	LaunchApplication();
    	CreateNewCustomer();
    	Configuration();
    	ConnectionToDB();
    }

	public static boolean exists(Match find) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void find() {

		// TODO Auto-generated method stub
		
	}

	
	public static boolean isImagePresent(String image)
    {
		Screen screen = new Screen();
		
        boolean status = false;
        screen = new Screen();
        try {
            screen.find(image);
            status = true;
        } catch (FindFailed e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }    
    
    public static void waitForImage(String image, int time) throws InterruptedException{
        for(int i=0; i<time; i++){
            if(isImagePresent(image)){
                break;
            }
            else{
                Thread.sleep(1000);
            }
        }
    }
    
	public static void LaunchApplication()
			throws Exception {
		// TODO Auto-generated method stub
		
		Screen screen = new Screen();
		

		Pattern InvalidCredentials=new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\InvalidCredentials.PNG");
		Pattern LogonPopUP= new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\GiiLogon_Popup.PNG");
		Pattern OkButton= new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\GiiLogon_OkButton.PNG");
		Pattern WelcomeLabel = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Gii_UserLoggedin_Label.PNG");
		Pattern Role = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Roles\\UK\\ENTP\\1448527895129.PNG");
		Pattern SearchButton = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Search.PNG");
		Pattern DownArrow = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\DownArrow.PNG");
		Pattern RoleSelectionWindow = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Gii_UserLoggedin_Label.PNG");
		Pattern SearchField = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\SearchField.PNG");

		
		//WebDriver driver = new ChromeDriver();SearchField
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		driver.get("https://citrixinsidedev.dell.com/Citrix/XenApp/auth/login.aspx");
		WebDriverWait waiting = new WebDriverWait(driver, 10);
		waiting.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
		if(driver.findElement(By.id("btnLogin")).isEnabled())
		{
			System.out.println("Application Launch Success......");
		}
		else
		{
			System.out.println("Application Launch Failure......");
		}	
		
		
/*		
		screen.type(UserName,"GEDIS_SIT_USER40");
		screen.type(Password,"UATUAT");
		screen.find(Domain).click();
	    screen.click(Europe);
		screen.click(Logon);
		driver.wait(10);
		*/
		
		driver.findElement(By.id("user")).sendKeys("GEDIS_SIT_USER40");
		driver.findElement(By.id("password")).sendKeys("UATUAT");
		Select ddlDomain = new Select(driver.findElement(By.id("domain")));
		ddlDomain.selectByValue("EUROPE");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(10); 
		waiting.until(ExpectedConditions.presenceOfElementLocated(By.id("viewButton")));
		if(driver.findElement(By.id("viewButton")).isEnabled())
		{
			System.out.println("Application Login Success......");
		}
		else
		{
			System.out.println("Application Login Failure......");
		}
		
		driver.findElement(By.xpath(".//span[contains(text(),'Sales')]")).click();
		waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[@class='breadcrumb lastBreadcrumb' and contains(text(),'Sales')]")));
		if(driver.findElement(By.xpath(".//span[@class='breadcrumb lastBreadcrumb' and contains(text(),'Sales')]")).isDisplayed())
		{
			System.out.println("Clicked Sales Icon Successfully......");
		}
		else
		{
			System.out.println("Sales Icon Failed......");
		}
		
		driver.findElement(By.xpath(".//span[contains(text(),'GE2')]")).click();
		if(driver.findElement(By.xpath(".//span[@class='breadcrumb lastBreadcrumb' and contains(text(),'GE2')]")).isDisplayed())
		{
			System.out.println("Clicked GE2 environment Icon Successfully......");
		}
		else
		{
			System.out.println("GE2 environment Icon Failed......");
		}
		
		driver.findElement(By.xpath(".//span[contains(text(),'Gii GE2 EMEA R3_2')]")).click();
		System.out.println("Clicked "+"'Gii GE2 EMEA R3_2'"+" Icon Successfully......");
		waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\GiiLogon_Popup.PNG", 60);
		
		//App.open("wfica32");
		App.focus("Gii");			
		screen.find(LogonPopUP).click();
		screen.find(OkButton).click();
		screen.exists(WelcomeLabel);
		System.out.println("Logged In......");
		App.focus("Gii");
        waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Gii_UserLoggedin_Label.PNG",60);
        App.focus("Gii");
        screen.find(RoleSelectionWindow).click();

outer:
        while(screen.exists(new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Roles\\UK\\ENTP\\GEDIS_SALES_SUPPORT_ORL_CPF2.0_UK_ENTP.PNG").similar((float)0.99)) == null)
        {
        	 System.out.println("Entered WHILE statement......");
        	//screen.type(Key.PAGE_DOWN);
        	 screen.wheel(Button.WHEEL_DOWN, 1);   
        	 Thread.sleep(3000);
        	 try
        	 {
                if(screen.exists(new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Roles\\UK\\ENTP\\GEDIS_SALES_SUPPORT_ORL_CPF2.0_UK_ENTP.PNG").similar((float)0.99)) != null)
          	   {
          		 System.out.println("Entered IF statement......"); 
          		 screen.find(new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Roles\\UK\\ENTP\\GEDIS_SALES_SUPPORT_ORL_CPF2.0_UK_ENTP.PNG").similar((float)0.99)).doubleClick(); 
          		 System.out.println("Role Selected.......");
          		 break;
          	   }  
        	 }
        	 catch (FindFailed e)
        	 {
        		 e.getStackTrace();
        		 System.out.println(e);
                 continue outer;                 
        	 } 
        }   
       
		System.out.println("Application Loading........");
		waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Search.PNG",60);
		if(screen.exists(SearchButton)!=null)
		{
		    System.out.println("Success........");
		}
		else
		{
			System.out.println("Failure........");
		}
		
		App.focus("Gii");
        
	}
	
	public static void SearchCustomer()
	{
		Screen screen = new Screen();
		
		Pattern SearchButton = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Search.PNG");
		Pattern SearchField = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\SearchField.PNG");
		
		
		try 
		{
			screen.find(SearchField).type(Key.DELETE);
			screen.find(SearchField).type(SearchField,"90037798");
			screen.find(SearchButton).click();
			//Thread.sleep(5000);
			waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Create_New_Customer.PNG", 40);
			System.out.println("Customer Search is success.....");
		} 
		
		catch (FindFailed | InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
 	public static void CreateNewCustomer()
	{
		Screen screen = new Screen();
		
		Pattern CreateNewCustomerIcon = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Create_New_Customer.PNG");
		Pattern AllCustomerDetailsHeader = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\All_Customer_Details_Header.PNG").similar((float)0.99);
		Pattern FirstName = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\FirstName.PNG").similar((float)0.99);
		Pattern LastName = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\LastName.PNG").similar(0.99f).targetOffset(169,239);
		Pattern AreaCode = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\AreaCode.PNG").similar((float)0.99);
		Pattern Number = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Number.PNG").similar((float)0.99);
		Pattern CPFGroupID = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\CPFGroupID.PNG").similar((float)0.99);
		Pattern CompanyName = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\CompanyName.PNG").similar((float)0.99);
		Pattern Address1 = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Address1.PNG").similar((float)0.99);
		Pattern PostCode = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\PostCode.PNG").similar((float)0.99);
		Pattern Country = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Country.PNG").similar((float)0.99);
		Pattern UnitedKingdom = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\UnitedKingdom.PNG").similar((float)0.99);
		Pattern City = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\City.PNG").similar((float)0.99);
		Pattern PaymentTerm = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\PaymentTerm.PNG").similar((float)0.99);
		Pattern Prepaid = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Prepaid.PNG").similar((float)0.99);
		Pattern Currency = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\Currency.PNG").similar((float)0.99);
		Pattern PromotionCode = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\PromotionCode.PNG").similar((float)0.99);
		Pattern Default = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\0000_Default.PNG").similar((float)0.99);
		Pattern GreenTick = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\GreenTick.PNG").similar((float)0.99);
		Pattern CustomerID = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\CustomerID.PNG");
		
		
		
		try 
		{
			App.focus("Gii");
			screen.click(CreateNewCustomerIcon);
			waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Customer_Creation\\All_Customer_Details_Header.PNG",60);
			screen.click(AllCustomerDetailsHeader);

			screen.type(Key.TAB); //Title
			screen.type(Key.TAB); //FirstName
			screen.type("Satish");
			screen.type(Key.TAB); //LastName
			screen.type("DD");
			screen.type(Key.TAB); //Type1
			screen.type(Key.TAB); //AreaCode
			screen.type("111111"); 
			screen.type(Key.TAB);  //Number
			screen.type("22222222");
			screen.type(Key.TAB); //Type2
			screen.type(Key.TAB); //AreaCode2
			screen.type(Key.TAB); //Number2
			screen.type(Key.TAB); //CFPGroupID
			screen.type("54142141");
			screen.type(Key.TAB); //CompanyName
			screen.type("Dell International");
			screen.type(Key.TAB); //Customer Name Ext
			screen.type(Key.TAB); //Customer Name Ext2
			screen.type(Key.TAB); //AddressSearchIcon
			screen.type(Key.TAB); //Address1
			screen.type("69-71 Upper Ground");
			screen.type(Key.TAB); //Address2
			screen.type(Key.TAB); //PostCode
			screen.type("SE1 9PQ");
			screen.type(Key.TAB); //Country
			screen.type(Key.TAB); //Country
			screen.type(Key.TAB); //City
			screen.type("London");
			screen.type(Key.TAB); //CustomerFax-AreaCode
			screen.type(Key.TAB); //CustomerFax-Number
			screen.type(Key.TAB); //CustomerMainTel-AreaCode
			screen.type(Key.TAB); //CustomerMainTel-Number
			screen.type(Key.TAB); //Email
			screen.type(Key.TAB); //CFO By Email
			screen.type(Key.TAB); //PaymentTerms
			screen.click(PaymentTerm);
			screen.click(Prepaid);
			screen.type(Key.TAB); //Currency
			screen.type(Key.TAB); //Discount
			screen.type(Key.TAB); //Customer Type
			screen.type(Key.TAB); //Parent Reference
			screen.type(Key.TAB); //Channel	
			screen.type(Key.TAB); //Sales Channel
			screen.type(Key.TAB); //Promotion Code
			screen.type("0000 Default");
			screen.type(Key.TAB); //Lead Sales Rep
			screen.type(Key.TAB); //Contact CFO Language
			screen.type(Key.TAB); //Item Language
			screen.type(Key.TAB); //Category
			screen.type(Key.TAB); //Tax Reg No
			screen.type(Key.TAB); //Company Reg No
			screen.click(GreenTick);
			Thread.sleep(25000);
			App.focus("Gii");
			
			Settings.OcrTextRead=true;
	 		System.out.println("The Newly Created Customer Number is : " +screen.find(CustomerID).highlight().text().toString());
		
			//screenClipOneNote();
			
			//Capture Screen Shot
	 		screen.find(CustomerID).highlight();
			BufferedImage bf = screen.capture().getImage();
			File file1 = new File("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\ScreenShots"+"\\NewlyCreatedCustomerNumber.png");
			ImageIO.write(bf, "png", file1);
			System.out.println("The Newly Created Customer Number is Captured @ : "+file1);
			
				
		} 
		
		catch (FindFailed | IOException | InterruptedException  e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
   
 	public static void Configuration()
 	{
 		Settings.OcrTextSearch=true;
 		Screen screen = new Screen();
 		
 		Pattern Configuration = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\Configuration.PNG");
 		Pattern ProductCatalogue = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\ProductCatalogue.PNG").similar(0.99f);
 		Pattern Catalogue = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\Catalogue.PNG").similar(0.99f);
 		Pattern EnterOrderCode = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\EnterOrderCode.PNG").similar(0.99f);
 		Pattern OrderCodeSearchIcon = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\OrderCode_SearchIcon.PNG").similar(0.99f);
 		Pattern AcceptConfig = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\AcceptConfig.PNG").similar(0.99f);
 		Pattern SaveAsQuote = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\SaveAsQuote.PNG").similar(0.99f);
 		Pattern Header = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\Gii(3.9.0.18).PNG").similar(0.99f);
 		Pattern YES = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\YES.PNG").similar(0.99f);
 		Pattern QuoteCompletion = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\QuoteCompletion.PNG").similar(0.99f);
 		Pattern InternetFlexiField = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\InternetFlexiField.PNG").similar(0.99f);
 		Pattern NonInternetOrder = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\NonInternetOrder.PNG").similar(0.99f);
 		Pattern OK = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\OK.PNG").similar(0.99f);
 		Pattern OfferConfirmationMode = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\OfferConfirmationMode.PNG").similar(0.99f);
 		Pattern ManualEmailSelection = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\ManualEmailSelection.PNG").similar(0.99f);
 		Pattern SendEmail = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\SendEmail.PNG").similar(0.99f);
 		Pattern QuoteCompletionOK = new Pattern ("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\QuoteCompletion_OK.PNG").similar(0.99f);
 		Pattern QuoteNumber = new Pattern("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Quote\\QuoteNumber.PNG").similar((float)0.99);
 		
 		try
 		{		
 		waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\Configuration.PNG",60);
 		screen.find(Configuration).click();
 	    //waitForImage("ProductCatalogue",60);
 	    screen.find(ProductCatalogue).click();
 		waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\Catalogue.PNG",60);
 		screen.find(Catalogue).click();
 		screen.find(EnterOrderCode).type(Key.DELETE);
 		screen.type(EnterOrderCode,"CA017LE5550EMEA");
 		screen.click(OrderCodeSearchIcon);
 		App.focus("Gii");
 		screen.click(Header);
 		Thread.sleep(20000);
 		screen.find(AcceptConfig).click();
 		Thread.sleep(10000);
 		waitForImage("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\Images\\Configuration\\SaveAsQuote.PNG",60);
 		screen.find(SaveAsQuote).click();
 		Thread.sleep(2000);
 		screen.click(YES);
 		Thread.sleep(5000);
 		screen.click(QuoteCompletion);
 		screen.find(InternetFlexiField).click();
 		screen.click(NonInternetOrder);
 		screen.click(OK);
 		Thread.sleep(3000);
 		screen.click(OfferConfirmationMode);
 		screen.find(ManualEmailSelection).click();
 		screen.type(ManualEmailSelection,"Satish_D1@dell.com");
 		screen.click(SendEmail);
 		//Thread.sleep(10000);
 		//screen.click(QuoteCompletionOK);
 		Thread.sleep(10000);
 		screen.find(QuoteNumber).highlight();
 		//Settings.OcrTextSearch=true;
 		Settings.OcrTextRead=true;
 		System.out.println("The Newly Created Offer Number is Captured @ : " +screen.find(QuoteNumber).highlight().text().toString());
 		//Capture Screen Shot
 		BufferedImage bf = screen.capture().getImage();
		File file1 = new File("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\ScreenShots"+"\\Offer_Number.png");
		ImageIO.write(bf, "png", file1);
		System.out.println("The Newly Created Offer Number is Captured @ : "+file1);
 		
 		
 		}
 		
		catch (FindFailed | InterruptedException | IOException  e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 	
 	public static void screenClipOneNote()
 	{
 	    org.sikuli.script.IScreen scr = null;
 	    EventObserver ob = null;
 	    final OverlayCapturePrompt oc = new OverlayCapturePrompt(scr, ob);
 	        //oc.prompt("Select Area to capture as Image");
 	        oc.addObserver(new EventObserver() 
 	        { // Inner calss
 	            @Override
 	            public void update(EventSubject arg0) {
 	                org.sikuli.script.ScreenImage capturedImg = oc.getSelection(); // To use oc object make as final.
 	                try { 
 	                    ImageIO.write(capturedImg.getImage(), "PNG", new File("C:\\Users\\Satish_D1\\workspace\\Sikuli Demo\\ScreenShots\\ScreenClip.png"));
 	                   System.out.println("The Newly Created Customer Number is Captured @ : ");
 	                } 
 	                catch (Exception e) 
 	                {     
 	                	e.printStackTrace();        
 	                }
 	                }
 	    }
 	        );
 	}
    
 	public static void ConnectionToDB()
 	{
 		try
 		{
 			String FROM_CURRENCY="";
 			String TO_CURRENCY="";
 			String CONVERSION_DATE="";
 			String CONVERSION_TYPE="";
 			String CONVERSION_RATE="";
 			String ENABLED_FLAG="";
 			
 			String Query1="select * FROM apps_global.gedis_gl_daily_rates"
 					+ " where from_currency= 'GBP' and to_currency = 'USD' and conversion_type =  1000 "
 					+ "and conversion_date = to_date(SYSDATE)";
 			
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521/servicename","userName","Password");
 			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ausmg11bdedbscn.us.dell.com:1521/GSEM3TE_SQL", "SQL_USER", "SQL_USER");
 			Statement stm = con.createStatement();
 			ResultSet rs=stm.executeQuery (Query1);
 			rs.next();
 			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5)+" "+rs.getString(6));
 			
 			FROM_CURRENCY =readln("The FROM_CURRENCY is: "+rs.getString(1));
 			TO_CURRENCY =readln("The TO_CURRENCY is: "+rs.getString(2));
 			CONVERSION_DATE =readln("The CONVERSION_DATE is: "+rs.getString(3));
 			CONVERSION_TYPE =readln("The CONVERSION_TYPE is: "+rs.getString(4));
 			CONVERSION_RATE =readln("The CONVERSION_RATE is: "+rs.getString(5));
 			ENABLED_FLAG =readln("The ENABLED_FLAG is: "+rs.getString(6));
 			 			
 			con.close();
 		}
 		catch(ClassNotFoundException | SQLException e)
 		{
 			e.printStackTrace();
 		}
 	}

	private static String readln(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		return null;
	}
}

	
