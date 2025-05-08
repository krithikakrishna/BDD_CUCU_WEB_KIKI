package Hooks;

import io.cucumber.java.Before;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.baseURI;

public class CucumberHooks {
    @Before
    public void setup() {
        String env = System.getProperty("env", "PREPROD");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/properties/application-" + env + ".properties");
            prop.load(fis);
            baseURI = prop.getProperty("base.url") + ":" + prop.getProperty("base.port").replace("/", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
