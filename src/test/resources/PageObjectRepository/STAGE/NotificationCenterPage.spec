#Object Definitions
==================================================================================== 
getTitle_Clickable                         xpath                           //h2[@class='nb_panelName']//span[contains(text(),'Message Center')]
GetTextBox                                 id                              message
lnk_ViewMore                               id                              viewMore
lnk_SengMsgToIndividual                    xpath                           //*[@id='send']/a
get_listOfMessages                         xpath                           //*[@id='messagelist']/li
get_TimeAndDateOfMessage                   xpath                           //*[@id='messagelist']/li[${description}]/div/div[3]
refreshButton                              id                              refresh
settingIcon                                xpath                           //img[@title='User settings']
urgentCheckbox                             id                              isUrgent
settingIcon                                xpath                           //img[@title='User settings']
userEmailText                              xpath                           //li[text()='${description}']
label_settingNotiToEmail                   xpath                           //label[text()='Forward notifications to my email']
label_settingNotiToPhone                   xpath                           //label[text()='Forward notifications to my cell phone']
form_settingNotiToEmail                    xpath                           //form[@class='user_email']
form_settingNotiToPhone                    xpath                           //form[@class='user_mobile']
urgentMessage                              xpath                           //img[contains(@class, 'messageejs_urgent')]
====================================================================================

