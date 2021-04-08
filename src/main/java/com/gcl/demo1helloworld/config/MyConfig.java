package com.gcl.demo1helloworld.config;

import ch.qos.logback.core.db.DBHelper;
import com.gcl.demo1helloworld.bean.Pet;
import com.gcl.demo1helloworld.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/5 17:44
 */

/**
 * @Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类，
// 配置类本身也是一个组件
//proxyBeanMethods：代理bean的方法
//  Full(proxyBeanMethods = true)
//  Lite(proxyBeanMethods = false)
//  组件依赖
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(value = Pet.class)
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册的方法调用多少次
     * 获取到的都是之前注册容器中的单实例对象
     * @return
     */
//    @ConditionalOnBean(name = "tom")//当容器中有名为tom的组件的时候，下面的方法才注册为组件
    @Bean
    //相当于xml文件中的bean标签，作用是给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型。
    //返回的值，就是组件在容器中的实例

//    @ConditionalOnMissingBean(value = User.class)
    //一般来说在这里使用@ConditionalOnMissingBean注解，
    //当容器中有名为user02的组件的时候，下面的方法不会注册为组件
    //但是，这里有一个执行顺序的问题，当执行这条语句的时候，
    //下面的user02组件还未注册，所以下面的方法是一定会被注册为组件的
    public User user01(){
        User user = new User("张三",19);
        user.setPet(pet01());
        return user;
    }

    @Bean
//    @ConditionalOnMissingBean(name = "user01")
    public User user02(){
        User user = new User("张三",19);
        user.setPet(pet01());
        return user;
    }

    @Bean("cat")
    //@Bean注解标注的组件是单实例的
    public Pet pet01(){
        return new Pet("cat");
    }
}
