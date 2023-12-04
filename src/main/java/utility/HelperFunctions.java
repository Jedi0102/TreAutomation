package utility;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HelperFunctions {
    public String url;
    public String reportsFolder;
    public void parseProperties(String path){
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url=properties.getProperty("url");
        reportsFolder=properties.getProperty("reportsFolderPath");

    }
    String mainWindowHandle;
    public void switchToNewWindow(){
        mainWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles=getWebDriver().getWindowHandles();
        String newWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

        switchTo().window(newWindowHandle);
    }
    public void switchBack(){
        switchTo().window(mainWindowHandle);
    }

}