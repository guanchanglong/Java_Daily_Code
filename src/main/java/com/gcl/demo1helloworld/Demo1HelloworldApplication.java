package com.gcl.demo1helloworld;

import com.gcl.demo1helloworld.bean.Pet;
import com.gcl.demo1helloworld.bean.User;
import com.gcl.demo1helloworld.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages="com.gcl")
public class Demo1HelloworldApplication {

    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(Demo1HelloworldApplication.class, args);

        //2、查看容器里面的组件
        String [] names = context.getBeanDefinitionNames();
        //打印容器里面的所有组件
//        for (String name:names){
//            System.out.println(name);
//        }

//        //3、从容器中获取组件
//        Pet pet1 = context.getBean("cat", Pet.class);
//        Pet pet2 = context.getBean("cat", Pet.class);
//        //判断@Bean注解标注的组件是否是单实例的
//        System.out.println("组件："+(pet1==pet2));//结果返回true，可知@Bean标注的组件是单实例的
//
//        MyConfig bean = context.getBean(MyConfig.class);
//        //结果：com.gcl.demo1helloworld.config.MyConfig$$EnhancerBySpringCGLIB$$b19d16f6@7e97551f
//        System.out.println(bean);
//
//        //获取到的bean本身就是一个代理对象
//        //如果@Configuration(proxyBeanMethods = true)中的proxyBeanMethods值为true
//        //那么外部每次使用配置类的方法都会从容器中找组件，获取到的就是代理对象
//        //否则获取到的就不是代理对象
//        //当proxyBeanMethods = true时，结果为true，
//        //当proxyBeanMethods = false时，结果为false，
//        User user1 = bean.user01();
//        User user2 = bean.user01();
//        System.out.println(user1 == user2);
//
//
//        //当proxyBeanMethods = true时，结果为true，
//        //即：user.setPet(pet01());中的pet01()没有创建新的Pet对象，还是使用容器中已经加载好的Pet对象
//        //当proxyBeanMethods = false时，结果为false，
//        //即：user.setPet(pet01());中的pet01()创建了一个新的Pet对象，容器取消判断容器中是否有重复的组件
//        User user = context.getBean("user01",User.class);
//        Pet cat = context.getBean("cat",Pet.class);
//        System.out.println(user.getPet()==cat);


//        //从容器中获取组件
//        System.out.println("==============");
//        String[]type1 = context.getBeanNamesForType(User.class);
//        for (String type:type1){
//            System.out.println(type);
//        }

        boolean config = context.containsBean("myConfig");
        System.out.println("组件中包含config?"+config);

        boolean user01 = context.containsBean("user01");
        System.out.println("组件中包含user01?"+user01);

        boolean user02 = context.containsBean("user02");
        System.out.println("组件中包含user02?"+user02);

        boolean cat = context.containsBean("cat");
        System.out.println("组件中包含cat?"+cat);
    }
}
