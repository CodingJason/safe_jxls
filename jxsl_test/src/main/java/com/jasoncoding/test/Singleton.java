package com.jasoncoding.test;

public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (singleton){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}


