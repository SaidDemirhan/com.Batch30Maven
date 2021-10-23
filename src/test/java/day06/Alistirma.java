package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alistirma {

    static WebDriver driver;

    @BeforeClass
    public  static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com/");
    }

    @Test
    public void urlTest1(){
        String expectedUrl="https://www.amazon.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("url uyusmuyor!",expectedUrl,actualUrl);
    }

    @Test
    public void baslikTest(){
        String expectedBaslik="Amazon";
        String actualBaslik= driver.getTitle();
        Assert.assertTrue("Baslikta beklenilen kelime bulunmuyor",actualBaslik.contains(expectedBaslik));
    }

    @Test
    public void aramaTusu() {
        WebElement aramaTusuKutusu=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor.",aramaTusuKutusu.isEnabled());
    }

    @Test
    public void aramaButonu(){
        WebElement aramaButonu=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        Assert.assertTrue(aramaButonu.isEnabled());
    }

    @Test
    public void urunEkleme() throws InterruptedException {
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Ferrero: \"Nutella B-Ready\" ein knuspriges Brot in Form von " +
                "Mini-Baguette, gefüllt mit einem cremigen Nutella, 15 Stück, 286 g']")).click();
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]")).click();

        Thread.sleep(2000);
        WebElement urun =driver.findElement(By.xpath("//h1[@class='a-size-medium a-text-bold']"));
        Assert.assertTrue("eklenen ürün görünmüyor",urun.isDisplayed());
    }

    //@AfterClass
    public static  void tearDown(){
        driver.close();
    }
}
