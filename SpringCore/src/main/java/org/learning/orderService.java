package org.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class orderService {
    private paymentService payment;


//    @Autowired
//    public orderService(paymentService payment){
//        this.payment = payment;
//    }
    // another method
    @Autowired
    public void setPayment (paymentService payment){
        this.payment =payment;
    }

    public void placeOrder(){
        payment.pay();
        System.out.println("order placed");
    }
}