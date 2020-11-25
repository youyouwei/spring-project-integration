package spring.project.integration.springdemoscenario.config;

import spring.project.integration.springdemoscenario.config.PersonService;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 12:19 2020/11/19
 */
public class PersonServiceImpl implements PersonService {
//    private String name;
//
//    public void say() {
//        System.out.println("this person say something");
//    }

    @Override
    public void eat() {
        System.out.println("this person eat some thing.");
    }
}
