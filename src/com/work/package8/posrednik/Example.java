package com.work.package8.posrednik;

import java.util.Date;

class ChatroomMediator{
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatroomMediator.showMessage(this,message);
    }
}

public class Example {
    public static void main(String[] args) {
        User dinesh= new User("Dinesh");
        User anamika= new User("Anamika");

        dinesh.sendMessage(" Hey! Anamika!");
        anamika.sendMessage("Yes! Dinesh!");
    }
}
