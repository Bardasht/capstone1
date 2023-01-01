package tek.sdet.framewrok.configuration;

import org.openqa.selenium.WebDriver;

public interface Browser {
    
    WebDriver openBrowser(String url);
}