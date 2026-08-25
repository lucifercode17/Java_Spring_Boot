package org.learnings;

import org.learnings.Notifications.EmailService;
import org.learnings.Notifications.NotificationService;
import org.learnings.Notifications.SmsService;

public class OrderServices {
    NotificationService notification;
    public  OrderServices(NotificationService notification) {
        this.notification = notification;
    }

    public void PlaceOrder(){

        System.out.println("Order placed Successfully ");
        notification.sendNotification();

    }

}
