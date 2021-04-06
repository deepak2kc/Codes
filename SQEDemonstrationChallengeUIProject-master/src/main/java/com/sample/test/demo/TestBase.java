package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sample.test.demo.util.TestUtil;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;

    //@BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializeDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        try {
//            driver.quit();
//
//        } catch (Exception e) {
//        }
//    }

    private void initializeDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
            
            driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }       
    }


}
