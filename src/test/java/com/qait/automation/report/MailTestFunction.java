/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.report;

import org.testng.annotations.Test;

/**
 *
 * @author qainfotech
 */
public class MailTestFunction {
    @Test
    public void sampleTest(){
       System.out.println("Checking mail functionality"
               + "\n console outputs"
               + "\n integers :12345"
               + "html content"
               + "<html>"
               + "<body><a href='https://www.google.com'>Click here to subscribe</a>"
               + "<\\html>"
               + "THANKS!!"); 
    }
}
