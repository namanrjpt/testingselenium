package testing;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class navigation extends commonCode{

    @Test
    public void do_navigation(){

        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.linkText("Geography")).sendKeys(Keys.chord(Keys.CONTROL, Keys.LEFT_SHIFT, Keys.RETURN));
        String name = "Karnataka";
        waitWebDriver(5);




        openNewTab();
        switchToLastTab();
        //going to instagram for image
        driver.navigate().to("https://www.instagram.com/explore/tags/" + name);
        String imageUrl = driver.findElement(By.id("pImage_0")).getAttribute("src");
        System.out.println(imageUrl);
        openNewTab();
        switchToLastTab();


        driver.navigate().to(imageUrl);
        waitWebDriver(5);

    }

    @Test
    public void youtube(){
        driver.navigate().to("https://www.youtube.com");
        waitWebDriver(2);

        driver.findElement(By.xpath("//*[@id=\"masthead-search-term\"]")).sendKeys("Sample Video");
        driver.findElement(By.xpath("//*[@id=\"masthead-search-term\"]")).sendKeys(Keys.RETURN);

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.print(e);
        }
    }
}
