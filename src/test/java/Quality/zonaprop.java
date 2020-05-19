package Quality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class zonaprop {
	public WebDriver driver;
	
	By busquedaavanzada = By.xpath("//*[@id='react-filters-form']/form/div/div[5]/p");
	By casa =  By.xpath("//*[@id=\"propertyType\"]/option[1]");
    By preciodesde =By.cssSelector("input[id='price-min']");
	By precioHasta = By.cssSelector("input[id='price-max']");
    By inputBuscar = By.cssSelector("#react-filters-form > form > div > div.search-box-container > div > div.rbt-input-hint-container > input");
	By ambientes = By.xpath("//*[@id='react-filters-form']/form/div/div[4]/div/div[1]/ul/li[3]/button");
	By btnAlquilar = By.xpath("//*[@id='react-filters-form']/form/div/div[1]/ul/li[2]/button");
	By imgzona = By.xpath("//*[@id='header-container']/div[1]/div[1]/a/img");
    By buscar =  By.cssSelector("#react-filters-form > form > div > div.apply-filters > button");
	By verMas = By.xpath("//*[@id='menu-sort-filter']/li/span");
    By precioDes = By.xpath("//*[@id='menu-sort-filter']/li/ul/li[2]/span");
    By vercasa = By.cssSelector("#react-posting-cards > div > div > div:nth-child(5) > div > div.second-column > div.posting-info-container > div > div.posting-header > div.posting-heading > h2 > a");
    
    
	@Before
	public void setUp() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe" );   
		driver = new ChromeDriver();
		String baseUrl = "https://www.zonaprop.com.ar/";
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
	}
	
	
	
	@After
	public void TearDown(){
		driver.quit();
	}
	
	
	@Test
	public void testgoogle() throws InterruptedException
	{
	    driver.findElement(busquedaavanzada).click();
	    driver.findElement(casa).click();
	    driver.findElement(preciodesde).sendKeys("1000");
	    driver.findElement(precioHasta).sendKeys("35000");
	    driver.findElement(inputBuscar).sendKeys("Tigre"+ Keys.ENTER);
	    driver.findElement(ambientes).click();
	    driver.findElement(btnAlquilar).click();
	    driver.findElement(buscar).click();
	    Thread.sleep(30000);
	    if(driver.findElement(imgzona).isDisplayed()) {
	    	
    	    driver.findElement(verMas).click();
	        driver.findElement(precioDes).click();
	        Thread.sleep(30000);
		    MovetoElement(vercasa);
	       }
	    else {
	    	
	    	System.out.print("No carga la pagina");
	    }
	}
	
	public void MovetoElement(By locator)
	{
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(locator);
		builder.moveToElement(element).perform();
	    element.click();
	}
}
