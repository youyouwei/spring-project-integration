package spring.project.integration.springdemoapp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;

import java.io.Reader;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 14:20 2020/5/15
 */
public class MybatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        try (Reader reader = Resources.getResourceAsReader("")){

        }
    }


}
