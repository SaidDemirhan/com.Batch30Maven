package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
    public static void main(String[] args) {

        //1. http://zero.webappsecurity.com sayfasina gidin
        //2. Signin buttonuna tiklayin
        //3. Login alanine  “username” yazdirin
        //4. Password alanine “password” yazdirin
        //5. Sign in buttonuna tiklayin
        //6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin

        driver.findElement(By.cssSelector("#signin_button")).click();

        //3. Login alanine  “username” yazdirin

        WebElement ad= driver.findElement(By.cssSelector("#user_login"));
        ad.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement sifre= driver.findElement(By.cssSelector("#user_password"));
        sifre.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.xpath("//*[@id='primary-button']"));
        //6. Pay Bills sayfasina gidin

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
    }

}
