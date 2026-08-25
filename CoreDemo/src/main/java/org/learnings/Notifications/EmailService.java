package org.learnings.Notifications;

public class EmailService implements  NotificationService{
    @Override
    public void sendNotification(){
        System.out.println("email sent successfully ");
    }
}
