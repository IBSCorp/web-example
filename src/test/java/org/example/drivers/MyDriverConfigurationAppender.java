package org.example.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;
import ru.ibsqa.chameleon.selenium.driver.WebSupportedDriver;
import ru.ibsqa.chameleon.selenium.driver.configuration.IDriverConfiguration;
import ru.ibsqa.chameleon.selenium.driver.configuration.IDriverConfigurationAppender;

/**
 * Бины, имплементирующие интерфейс IDriverConfigurationAppender, могут быть использованы для точной настройки
 * конфигурации драйвера. В данном примере добавляется запуск в режиме "инкогнито". Для типов драйвера CHROME и
 * FIREFOX это делается разными способами. Для других типов драйвера в данном примере никаких действий не выполняется.
 * Поведение управляется параметром командной строки incognito. Этот параметр зарегистрирован в файле
 * src/test/resources/properties.xml и следовательно отображается в плагине на вкладке Настройки.
 */
@Component
public class MyDriverConfigurationAppender implements IDriverConfigurationAppender {

    // Получение параметра из командной строки
    private final boolean incognito = Boolean.parseBoolean(System.getProperty("incognito", "false"));

    @Override
    public void appendToConfiguration(IDriverConfiguration driverConfiguration) {
        if (!incognito) {
            return;
        }
        if (WebSupportedDriver.CHROME.equals(driverConfiguration.getDriverType())) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            driverConfiguration.setOptions(options);
        } else if (WebSupportedDriver.FIREFOX.equals(driverConfiguration.getDriverType())) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driverConfiguration.setOptions(options);
        }
    }

}
