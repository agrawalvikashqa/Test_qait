/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cengage.mindtap.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


/**
 *
 * @author kratijain
 */
public class ReadSpeakerPageActions  extends BasePageActions {

    public ReadSpeakerPageActions(WebDriver driver) {
 super(driver,"ReadSpeakerPage");
    }

    public boolean DropdownOnReadSpeaker() {
     boolean flag1, flag2;   
     flag1=element("speaker_speed_Dropdown").isDisplayed();
     flag2=element("speaker_voice_Dropdown").isDisplayed();
     if(flag1==true && flag2==true)
         return true;
     else 
        return false;  
    }

    public boolean clickOnspeaker_speed_Dropdown() {
     boolean flag1, flag2, flag3;
     element("speaker_speed_Dropdown");
     flag1=isElementDisplayed("speaker_speed_select", "Slow");
     flag2=isElementDisplayed("speaker_speed_select", "Medium");
     flag3=isElementDisplayed("speaker_speed_select", "Fast");
     if (flag1==true && flag2==true && flag3==true)
       return true;
    else 
       return false;
    }

    public void clickOnspeaker_voice_Dropdown() {
     element("speaker_voice_Dropdown");
     isElementDisplayed("speaker_voice_select", "Male");
     isElementDisplayed("speaker_voice_select", "Female");
    }

    public void clickOninit_mediumSpeed_option() {
     element("init_mediumSpeed_option");
}

    public void clickOninit_maleVoice_option() {
       element("init_maleVoice_option");
    }
      public void clickOnVoiceSelectValue(String expectedValue) {
        Assert.assertEquals(element("VoiceSelectValue").getText(), expectedValue, "Assert Failed: incorrect selected");
    }

    public void clickOnReadSpeedSelectedValue(String expectedValue) {
    Assert.assertEquals(element ("ReadSpeedSelectedValue").getText(),expectedValue, "Assert Failed: incorrect selected");
    }

}
