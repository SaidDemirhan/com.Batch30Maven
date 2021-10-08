package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun
        //2- https://www.walmart.com/ adresine gidin
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        //7- URL in walmart.com icerdigini control edin
        //8-”Nutella” icin arama yapiniz
        //9- Kac sonuc bulundugunu yaziniz
        //10-Sayfayi kapatin

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.walmart.com/");
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String expectedKelime="Save";
        String actualSayfaBasligi=driver.getTitle();
        if (actualSayfaBasligi.contains(expectedKelime)){
            System.out.println("Baslik Save iceriyor");
        }else System.out.println("Baslik Save icermiyor");
        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz

        String expectedSayfaBasligi= "Walmart.com | Save Money.Live Better";
        if (actualSayfaBasligi.equals(expectedSayfaBasligi)){
            System.out.println("sayfa basligi: Walmart.com | Save Money.Live Better");
        }else System.out.println("sayfa basligi beklenenle uyusmuyor.");

        //7- URL in walmart.com icerdigini control edin
        String actualUrl= driver.getCurrentUrl();
        String expectedadres= "walmart.com";
        if (actualUrl.contains(expectedadres)){
            System.out.println("url walmart.com iceriyor");
        }else System.out.println("url walmart.com icermiyor");
        //8-”Nutella” icin arama yapiniz
        WebElement arama= driver.findElement(By.xpath("//input[@type='search']"));
        arama.sendKeys("Nutella"+Keys.ENTER);
        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi);
        //10-Sayfayi kapatin
        driver.close();
    }
}
