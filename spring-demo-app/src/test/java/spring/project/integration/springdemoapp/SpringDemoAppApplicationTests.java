package spring.project.integration.springdemoapp;

import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 使用 Junit4 进行单元测试 其中测试类和所有测试方法都要使用public修饰
 *
 * 一、unit中集中基本注解，是必须掌握的。
 *
 * @BeforeClass – 表示在类中的任意public static void方法执行之前执行
 * @AfterClass – 表示在类中的任意public static void方法执行之后执行
 * @Before – 表示在任意使用@Test注解标注的public void方法执行之前执行
 * @After – 表示在任意使用@Test注解标注的public void方法执行之后执行
 * @Test – 使用该注解标注的public void方法会表示为一个测试方法
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringDemoAppApplication.class})
@AutoConfigureMockMvc
@WebAppConfiguration  //设置 webapp的目录 如果没有前端页面或则jsp脚本不用设置
public class SpringDemoAppApplicationTests {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    static {
        // 提前设置变量，防止 Test启动后设置慢
        System.setProperty("DEPLOY_ENV", "dev");
        System.setProperty("CONFIG_SERVER_URL", "172.29.14.241:8888");
        System.setProperty("NACOS_GROUP", "genesis");
        System.setProperty("NACOS_ENABLE", "true");
        System.setProperty("SPRING_DISCOVERY_ENABLE", "false");
    }


    @BeforeClass
    public static void beforeInit() {
        System.out.println("=========================before init=================");

    }

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }




    @Test
    public void contextLoads() {
    }

    @Test
    public void mockMvcGet() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/orders/11")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("SUCCESS"))
                .andExpect(MockMvcResultMatchers.jsonPath("data.id").value("11"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    private ResultHandler print() {
        return null;
    }

    @Test
    public void method() {

    }

}
