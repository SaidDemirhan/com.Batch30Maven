package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Odev1 {
    //1. “https://www.saucedemo.com” Adresine gidin
    //2. Username kutusuna “standard_user” yazdirin
    //3. Password kutusuna “secret_sauce” yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin

        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce"+ Keys.ENTER);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urun=driver.findElement(By.cssSelector(".inventory_item_name"));

        if (urun.isDisplayed()){
            System.out.println("Secilen ürün sepete eklenmistir.");
        }else System.out.println("Sepetiniz bostur.");
        //9. Sayfayi kapatin
        driver.close();
    }
}
