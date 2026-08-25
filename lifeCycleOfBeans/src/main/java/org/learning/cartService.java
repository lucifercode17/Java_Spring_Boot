package org.learning;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


//@Component
public class cartService /* implements InitializingBean */{
    Map<Integer,String> mp;
    public cartService(){
        mp = new HashMap<>();
        System.out.println("cartService Constructor called ");
    }




    public void cart(){
        System.out.println("added to cart");
    }




    public  void start(){
        System.out.println("bean is ready ");
        mp.put(1,"Dheeraj");
        mp.put(2,"Virat");
    }
    public String getValue(int key){
        return mp.get(key);
    }

//    @Override
    //    public void afterPropertiesSet() throws Exception {
//        System.out.println("bean is ready ");
//        mp.put(1,"Dheeraj");
//        mp.put(2,"Virat");
//    }


}
