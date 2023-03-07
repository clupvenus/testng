package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {
    @Test
    public void hardAssertionTesti(){

        Assert.assertTrue(5>8);

        Assert.assertFalse(8==8);

        Assert.assertEquals(5,9);

        Assert.assertNotEquals(6,6);

    }

    @Test
    public void softAssertionTesti(){
        /*
        Junitteki Assert Clasi TestNG de de vardir ama bir test methodundan birden fazla
        failed olan assertion varsa ilkinde calismayi durdurup exception firlattigindan tum hatayi
        bir defada gorup hepsini duzelme sansimiz olmaz
        TestNg bunun icin bir alternatif dusunmus.
        Bu alternatifte assert classindaki static methodlari kullanmak yerine
        soft assert classindan bir obje olusturup o obje uzerinden istedigimiz testleri yapiyoruz.

        softassert objesi ile yailan assertionkar failed olsa da testimiz yapilmaya devam eder.
        ancak testlerin sonucunu gormek istedigimizde
         softassert.assertAll() ile tum yaptigi testleri raporlamasini soyleriz.

         assertAll() methodunun calistigi satirda exception olabilir.

         */

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(5>8,"true testi failed");

        softAssert.assertFalse(8==8,"false testi failed");

        softAssert.assertEquals(5,9,"equals testi failed");

        softAssert.assertNotEquals(6,6,"notequals testi failed");



        softAssert.assertAll();

    }
}
