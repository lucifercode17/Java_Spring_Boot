package org.learning;

import org.springframework.stereotype.Component;

@Component
public class paymentService {
    public void  pay(){
        System.out.println("payment done");
    }
}
