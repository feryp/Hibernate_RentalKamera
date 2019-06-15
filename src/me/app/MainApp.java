/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.app;

import me.kamera.view.MainView;
import me.kamera.service.KameraService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author FERY
 */
public class MainApp {
    private static ApplicationContext applicationContext;
    
     public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        new MainView().setVisible(true);
        
    }
     
      public static KameraService getKameraService(){
        return (KameraService) applicationContext.getBean("KameraService");
    }
     
}
