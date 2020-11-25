package spring.project.integration.springdemoapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.project.integration.springdemoscenario.Demo;
import spring.project.integration.springdemoscenario.config.SpringDemoConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.containsString;

/**
 * @Description: 普通Spring 容器测试
 * @Author: jiahuiyang
 * @Date: Created in 18:01 2020/11/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDemoConfig.class)
public class SpringTest {

    @Autowired
    private Demo demo;

    @Rule


    @Test
    public void demoTest() {
        //断言方法控制台输出
        //把标准输出定向至ByteArrayOutputStream中
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        demo.demo();

        assertThat(outContent.toString(), containsString("this is a demo"));

    }

    @Test
    public void addTest() {
        demo.add(1);
    }

}
