package core;




import com.dt.web.DtTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public DtTestCase dt;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(description = "Class Level Setup!")
    public void setUp () throws Exception {
        String systemName = System.getProperty("os.name").toLowerCase();
        System.out.println(systemName);
        if(systemName.contains("window"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"); //Chrome Driver
            driver = new ChromeDriver();
        }
        else if(systemName.contains("linux"))
        {
            System.setProperty("webdriver.chrome.driver", "/root/chrome/chromedriver"); //Chrome Driver
            System.setProperty("webdriver.gecko.driver", "/usr/bin/google-chrome");
            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption("useAutomationExtension", false);
            //options.addArguments("--headless");
            //options.addArguments("--no-sandbox");
            //options.addArguments("--disable-dev-shm-usage");
            //options.setExperimentalOption("useAutomationExtension", false);

            driver = new ChromeDriver(options);
        }
        else if (systemName.contains("mac os x"))
        {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); //Chrome Driver
            driver = new ChromeDriver();
        }
        else
        {
            throw new RuntimeException("unsupport platform");
        }

        //等待时间
        wait = new WebDriverWait(driver,15);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dt = new DtTestCase(driver);
        //最大化窗口
        driver.manage().window().maximize();
    }

    @AfterClass(description = "Class Level Teardown!")
    public void tearDown () {
        driver.quit();
    }

}
