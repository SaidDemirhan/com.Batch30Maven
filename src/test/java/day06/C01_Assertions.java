package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class C01_Assertions {
//1) Bir class oluşturun: BestBuyAssertions
//2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
// ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
// ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
// ○ logoTest => BestBuy logosunun görüntülendigini test edin
// ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public static  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public  void urlTest(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Istenen Url bulunamadi", expectedUrl,actualUrl);
    }
    @Test
    public  void titelTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse("istenmeyen kelime Title da var", actualTitle.contains(istenmeyenKelime));

    }

    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("Logo görünmüyor",logo.isDisplayed());
    }

    public void fransizcaTest(){
        WebElement fransizcaLinki=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue("Fransizca Linki Görünmüyor",fransizcaLinki.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
