package PruebasCalculadora;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GrupoPruebas {

	
	//WebDriver driver = null;

	
	public static void main(String[] args) {

			String ruta = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\romeo_rivas\\eclipse-workspace\\AutomatizacionCalculadora\\drivers\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
		
			driver.get("https://testsheepnz.github.io/BasicCalculator.html");
			driver.findElement(By.name("number1")).sendKeys("1");
			driver.findElement(By.name("number2")).sendKeys("2");
						
			driver.findElement(By.xpath("//input[@id='calculateButton']")).click();
			
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			String resulopera = driver.findElement(By.xpath("//input[@id='numberAnswerField']")).getAttribute("value");
			System.out.println("resultado:");
			System.out.println(resulopera);
			System.out.println("fin");
			
			Assert.assertEquals("3", resulopera);
			
			
			driver.quit();

	}
	
	public void SelectorOpcion(int num) {
		
/*
		Select opciones = new Select(driver.findElement(By.id("selectOperationDropdown")));
		opciones.selectByIndex(3);
		*
		*/
		
	}
	
	
	
}
