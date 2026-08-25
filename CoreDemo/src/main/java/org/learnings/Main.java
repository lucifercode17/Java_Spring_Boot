package org.learnings;

//import org.learnings.Notifications.EmailService;
import org.learnings.Notifications.NotificationService;
import org.learnings.Notifications.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        NotificationService notification = new SmsService();
        OrderServices order = new OrderServices(notification);

        order.PlaceOrder();


    }
}