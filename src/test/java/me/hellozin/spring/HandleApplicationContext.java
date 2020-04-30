package me.hellozin.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.StaticApplicationContext;

@SpringBootTest
public class HandleApplicationContext {

    @Test
    public void registerBean() {
        /* ApplicationContext 가져오기 */
        StaticApplicationContext applicationContext = new StaticApplicationContext();

        /* 'sumCalculator Bean Definition 정의' */
        RootBeanDefinition sumCalculatorDef = new RootBeanDefinition(Calculator.class);

        /* 'sumCalculator Bean 등록 */
        applicationContext.registerBeanDefinition("sumCalculator", sumCalculatorDef);

        /* 'computer' Bean Definition 정의 */
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, 1);
        argumentValues.addIndexedArgumentValue(1, new RuntimeBeanReference("sumCalculator"));

        RootBeanDefinition computerDef = new RootBeanDefinition(Computer.class, argumentValues, null);

        /* 'computer' Bean 등록 */
        applicationContext.registerBeanDefinition("computer", computerDef);

        /* 테스트 */
        Computer computer = (Computer) applicationContext.getBean("computer");
        assertThat(computer.calculate(1, 2)).isEqualTo(3);
    }

}
