package testing;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class commonCode {

    WebDriver driver;

    @Before
    public void startWebDriver(){

        System.setProperty("webdriver.gecko.driver", "/home/naman/Downloads/geckodriver");
        driver = new FirefoxDriver();
    }


    @After
    public void closeWebDriver(){
        driver.close();
        driver.quit();
    }

    public void openNewTab(){
        try {
            Robot robot = new Robot();

            // ctrl + T & ctrl TAB

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);

            // CTRL+T is now pressed

            robot.keyRelease(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void waitWebDriver(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void switchToLastTab(){
        for(String childTab: driver.getWindowHandles()){
            driver.switchTo().window(childTab);
        }
    }
}
