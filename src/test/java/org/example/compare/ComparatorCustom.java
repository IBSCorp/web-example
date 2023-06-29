package org.example.compare;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.ibsqa.chameleon.compare.Comparator;
import ru.ibsqa.chameleon.compare.IComparator;

@Component
@Comparator(value = "содержит игнорируя регистр")
public class ComparatorCustom implements IComparator {
    @Override
    public boolean checkValue(String actual, String expected) {
        return StringUtils.containsIgnoreCase(actual, expected);
    }
}
