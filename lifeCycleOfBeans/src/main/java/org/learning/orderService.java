package org.learning;

import org.springframework.stereotype.Component;

@Component
public class orderService {
    private  paymentService payment;
    public  orderService(paymentService payment){
        this.payment = payment;
    }

    public  void orderPlaced(){
        System.out.println("order placed ");
        payment.pay();
    }

}
