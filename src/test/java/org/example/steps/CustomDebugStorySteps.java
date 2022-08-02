package org.example.steps;

import io.cucumber.java.ru.Когда;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ibsqa.qualit.steps.AbstractSteps;

/**
 * Пример реализации кастомных шагов уровня BDD.
 */
public class CustomDebugStorySteps extends AbstractSteps {

    @Autowired
    private CustomDebugSteps customDebugSteps; // здесь подключаем бин с тестовыми шагами

    @Когда("^debug \"([^\"]*)\"")
       public void stepDebug(String param) {
        flow(() ->
                // Здесь происходит вызов кастомного тестового шага, в котором и реализуется основная логика
                customDebugSteps.stepDebug(param)
        );
    }
}
