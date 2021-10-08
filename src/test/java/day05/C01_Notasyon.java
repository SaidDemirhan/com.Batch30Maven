package day05;

import org.junit.Test;

public class C01_Notasyon {
    //seleniumda da belli methodlar olusturbiliriz
    //cagirmamiz lazim ki calissinlar.
    public void ilkTestMethodu(){
        System.out.println("ilk test methodumuz");

    }

    //basina @test eklersek bagimsiz olarak test icin calisan bir method oldu
    @Test
    public void notasyonluIlikTestMethodu(){
        System.out.println("notasyonlu ilk test methodumuz");

    }
}
