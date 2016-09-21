#Object Definitions
==================================================================================== 
TextArea_MessageBox             id        message
btn_messageSubmit               id        message_submit
Frame_MessageCenter             xpath     //*[contains(@id,'_NB_Dock_IFrame') and contains(@src,'messagecenter')]
btn_PostedMessage               xpath     //*[@class='messagetext' and contains(.,'${messString}')]
postedMessage_seemore           xpath     //*[@class='messageText ng-binding' and contains(.,'${messString}')]/span[@class='linkToMessage ng-scope']
urgentCheckbox                  xpath     //*[text()='Urgent']//parent::div/input
UrgentIcon                      xpath     .//ul[@id='messagelist']/li//img[@title='Urgent']
SettingOptionsbtn               id        messagecenterOptions
email_textfld                   id        email 
Addbtn                          xpath     //input[@value='Add']
success_message                 xpath     //div[@class='nb_success success_message']
deleteEmailbtn                  xpath     //img[contains(@src,'delete')]

====================================================================================