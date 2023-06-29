package org.example.step_listeners;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import ru.ibsqa.chameleon.steps.aspect.AbstractStepListener;
import ru.ibsqa.chameleon.steps.aspect.StepType;

/**
 * Бины, имплементирующие интерфейс IStepListener или расширяющие абстрактный класс AbstractStepListener, могут быть
 * использованы для выполнения действие до каждого шага, после успешного выполнения шага или после ошибки,
 * произошедшей при выполнении шага. В данном примере после выполнения любого шага (независимо от его результата)
 * производится задержка в 200 мс.
 * Поведение управляется параметром командной строки delayStep. Этот параметр зарегистрирован в файле
 * src/test/resources/properties.xml и следовательно отображается в плагине на вкладке Настройки.
 */
@Component
public class DelayStepListener extends AbstractStepListener {

    // Получение параметра из командной строки
    private final boolean delayStep = Boolean.parseBoolean(System.getProperty("delayStep", "false"));

    @Override
    public void stepAfter(JoinPoint joinPoint, StepType stepType) {
        if (delayStep && stepType.isUiStep()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
