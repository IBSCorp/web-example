package org.example.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.ibsqa.chameleon.elements.web.TextInput;

import java.util.List;

/**
 * TODO
 */
public class ValidationInput extends TextInput {

    @Override
    public String getErrorMsg() {
        List<WebElement> elements = findElements(By.xpath("../small"));
        if (elements.size()>0) {
            return elements.get(0).getText();
        }
        return null;
    }

}
