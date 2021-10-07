package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        String sayfaBasligi=driver.getTitle();
        if (sayfaBasligi.contains("Save")){
            System.out.println("Baslik Save iceriyor");
        }else System.out.println("Baslik Save icermiyor");
        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        if (sayfaBasligi.equals("Walmart.com | Save Money.Live Better")){
            System.out.println("sayfa basligi Walmart.com | Save Money.Live Better");
        }else System.out.println("sayfa basligi sorulanla uyusmuyor.");

        //7- URL in walmart.com icerdigini control edin
        String expectedUrl= driver.getCurrentUrl();
        if (expectedUrl.contains("walmart.com")){
            System.out.println("url walmart.com iceriyor");
        }else System.out.println("url walmart.com icermiyor");
        //8-”Nutella” icin arama yapiniz
        /*WebElement arama= driver.findElement(""+ Keys.ENTER);
        //9- Kac sonuc bulundugunu yaziniz
        List<WebElement> sonuc = driver.findElement();
        //10-Sayfayi kapatin
        driver.close();*/
    }
}
