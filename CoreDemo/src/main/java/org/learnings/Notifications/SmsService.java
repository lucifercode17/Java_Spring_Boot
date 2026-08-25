package org.learnings.Notifications;

public class SmsService implements NotificationService{
    @Override
    public  void  sendNotification(){
        System.out.println("Sms send");
    }
}
