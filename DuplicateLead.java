package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// login page
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("democsr");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		// next page
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Nortingam");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bala");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Soorya");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Bala");

		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Supply chain");

		driver.findElement(By.id("createLeadForm_description"))
				.sendKeys("This is Bala, Working in supply chain Management");

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Bala@soorya.com");

		WebElement we = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select s = new Select(we);

		s.selectByVisibleText("New York");

		Thread.sleep(2000);

		driver.findElement(By.name("submitButton")).click();

		String title = driver.getTitle();

		System.out.println(title);
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).clear();

		driver.findElement(By.id("createLeadForm_firstName")).clear();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Nortingam University");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Soorya Bala");
		
		driver.findElement(By.name("submitButton")).click();
		
		String titleResult=driver.getTitle();
		
		System.out.println(titleResult);
		

	}

}
