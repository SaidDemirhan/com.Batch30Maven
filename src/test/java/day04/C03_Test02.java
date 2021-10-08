package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {
    public static void main(String[] args) throws InterruptedException {

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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1000");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2021-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement basariliYazisiElementi= driver.findElement(By.cssSelector("#alert_content"));
        if (basariliYazisiElementi.isDisplayed()){
            System.out.println("PASSED");
        }else
            System.out.println("failed");

        driver.close();
    }

}
