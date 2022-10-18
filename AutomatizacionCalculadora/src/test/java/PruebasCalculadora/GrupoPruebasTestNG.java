package PruebasCalculadora;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GrupoPruebasTestNG {

	WebDriver driver = null;
	
	@BeforeTest
	public void configuracion() {
		String ruta = System.getProperty("user.dir");
		System.out.println(ruta);
		System.setProperty("webdriver.chrome.driver", ruta + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	
	@Test
	public void pruebaSuma() {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		
		driver.findElement(By.name("number1")).clear();
		driver.findElement(By.name("number2")).clear();
		
		
		//5+6=11
		driver.findElement(By.name("number1")).sendKeys("5");
		driver.findElement(By.name("number2")).sendKeys("6");
		
		driver.findElement(By.id("calculateButton")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String valorRespuesta = driver.findElement(By.id("numberAnswerField")).getAttribute("value").toString();
		String resulEsperado = "11";
		
		Assert.assertEquals(valorRespuesta, resulEsperado);

	}
	
	@Test
	public void pruebaResta() {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		
		driver.findElement(By.name("number1")).clear();
		driver.findElement(By.name("number2")).clear();
		
		driver.findElement(By.name("number1")).sendKeys("10");
		driver.findElement(By.name("number2")).sendKeys("5");
		
		Select opciones = new Select(driver.findElement(By.id("selectOperationDropdown")));
		opciones.selectByIndex(1);
		
		driver.findElement(By.id("calculateButton")).sendKeys(Keys.ENTER);;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String valorResta = driver.findElement(By.name("numberAnswer")).getAttribute("value");
		String resulEsperado = "5";
		
		Assert.assertEquals(valorResta, resulEsperado);
	}
	
	
	@Test
	public void pruebaMultiplicacion() {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		
		driver.findElement(By.name("number1")).sendKeys("2");
		driver.findElement(By.name("number2")).sendKeys("1");
		
		Select opcion = new Select(driver.findElement(By.id("selectOperationDropdown")));
		
		opcion.selectByIndex(2);
				
		
		driver.findElement(By.id("calculateButton")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String valorRespuesta = driver.findElement(By.id("numberAnswerField")).getAttribute("value").toString();
		String resulEsperado = "2";
		
		Assert.assertEquals(valorRespuesta, resulEsperado);

	}
	
	@Test
	public void pruebaNegativaDiv () {
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.name("number1")).sendKeys("5");
		driver.findElement(By.name("number2")).sendKeys("0");
		
		Select opcion = new Select(driver.findElement(By.id("selectOperationDropdown")));
		opcion.selectByIndex(3);
		
		driver.findElement(By.id("calculateButton")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String div0 = driver.findElement(By.id("errorMsgField")).getText();
		
		Assert.assertEquals(div0, "Divide by zero error!");
		
	}
	
	
	@AfterTest
	public void cierre() {
		driver.quit();
	}
	
	
}
