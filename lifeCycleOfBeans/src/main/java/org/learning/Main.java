package org.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// spring beans life cycle
// 1. IOC Container start
// 2. read configuration from Appconfig.java  and create all the reflection of the class and make the beans it also it make the beans of appConfig because inside configuration the @componet is called, and it is all maintained by spring
// 3. it creates all the bean def first then create object one by one
// 4. Dependencies injection is done
// 5. aware interfaces in which we can change the  bean name by Overriding the setBeanName() note -> it is only use if it  needs
// 6. Initialization  Callbacks
     // there are three types of  callback initialization
      // 1. afterPropertiesSet() in Intiializingbeans interface
      // 2.init  -> the that bean in app config tell the method in () inside the beans annotation brackets
      // 3. most use method for this is postConstruct just make a method and give annotation of postConstruct
//7. beans is ready to use
//8. destruction beans
   // there are also three method
   // 1. destroybean same use implementation  and override method
   // 2. init method give method in the beans in app config
   // 3. most use method preDestroy annotation

// 9. bean is destroyed


public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world ");

        // we are study about the beans of creation , manage beans and delection of beans
        // mainly we study about singleton than after prototype beans creation
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        orderService order = context.getBean(orderService.class);
//        order.orderPlaced();
        cartService cart = context.getBean(cartService.class);
        System.out.println(cart.getValue(1));



    }
}