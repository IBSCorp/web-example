package org.example.drivers;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import ru.ibsqa.chameleon.selenium.driver.AbstractDriverFactory;
import ru.ibsqa.chameleon.selenium.driver.WebSupportedDriver;

/**
 * Бины, наследующие от абстрактного класса AbstractDriverFactory, могут быть использованы для самостоятельного
 * создания драйвера Selenium. Если метод newInstance вернет null, то будет выполнено стандартное создание драйвера.
 * Для прерывания тестов следует выбрасывать исключение.
 */
@Component
public class MyDriverFactory extends AbstractDriverFactory<WebSupportedDriver> {
    @Override
    public WebDriver newInstance(String driverId) {
        // Пример создания драйвера Selenoid
        // Для использования надо раскомментировать код и проверить параметры
        /*
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "98.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            // How to add test badge
            put("name", "Test badge...");

            // How to set session timeout
            put("sessionTimeout", "15m");

            // How to set timezone
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            // How to add "trash" button
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            // How to enable video recording
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.111.111/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to(getConfiguration().getApplicationUrl());
        return driver;
        */
        return null;
    }
}
