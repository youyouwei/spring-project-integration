package spring.project.integration.springdemoapp;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:42 2020/5/7
 *
 * 执行 test 类
 * before class:begin this class=============
 * before every test method---------
 * this is test 1
 * after every test method------------
 * before every test method---------
 * this is test 2
 * after every test method------------
 * after class:end this class=============
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)  //支持spring framework test
public class TestJunitAnnotation {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class:begin this class=============");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class:end this class=============");
    }

    @Before
    public void before() {
        System.out.println("before every test method---------");
    }

    @After
    public void after() {
        System.out.println("after every test method------------ ");
    }

    /**
     * 单独执行test后的结果
     * before class:begin this class=============
     * before every test method---------
     * this is test 1
     * after every test method------------
     * after class:end this class=============
     */
    @Test
    public void test() {
        System.out.println("this is test 1");
    }

    @Test
    public void test2() {
        System.out.println("this is test 2");
    }

    public static void method() {
        System.out.println("static method");
    }
}
