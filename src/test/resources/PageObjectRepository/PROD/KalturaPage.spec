#Object Definitions
================================================================================================================================= 
IconSelectorVideo                           id                          init_video
IconSelectorImage                           id                          init_image
IconSelectorAudio                           id                          init_audio
IconSelectorvideoCapture                    id                          init_videoCapture
IconKalturaAppHelp                          xpath                       //a[contains(@class,'helpicon kaltura_helpHover')]
more_link                                   xpath                       //img[@alt='Expand Dock']
myContent_icon                              xpath                       //img[contains(@src,'my_content_icon')]
categoryHeader                              id                          category_aggregator
title                                       id                          name
kalturaApp_icon                             xpath                       //img[contains(@src,'kaltura_icon')]
myContentMenuTypeSelector                   xpath                       //h3[@class='activityName' and contains (.,'My Content')]
kalturaMenuTypeSelector                     xpath                       //h3[@class='activityName' and text()='Kaltura']
kalturaMediaList                            id                          kalturaMediaList
upload_btn                                  id                          Upload_Browse
browse_btn                                  id                          Upload_Browse 
mostRecent                                  linktext                    Most Recent
alpha                                       linktext                    Alpha
videoSort_btn                               id                          VIDEO
audioSort_btn                               id                          AUDIO 
videoCaptureSort_btn                        id                          KVCAPTURES 
imageSort_btn                               id                          IMAGE
sharedMediaFile                             id                          showSharedMediaId 
mediaFile_radioBtn                          xpath                      (//div[@id='kalturaMediaList']//div[@class='checkbox']//input[@type='radio'])[1]
continue_btn                                id                          addActContinue
save_btn                                    id                          addActConfirm
title_inputField                            xpath                       //input[contains(@class,'required validates')]
description_inputField                      id                          description
save_btn1                                   xpath                       //span[@id='init_save']
ddl_orderButton                             xpath                       //a[@id='order-button']/span[@class='ui-selectmenu-status']
mediaFile                                   id                          kplayerAct 
closeActivity                               xpath                       //*[@title='Close Activity']
activityName                                xpath                       //h3[contains(@class,'lpn_name') and contains(.,'${title}')]
MediaPresent                                xpath                       (//img[@alt='IMAGE'])[1]
MediaFile_CheckBox                          css                         .addToNbChkBox
KalturaApp                                  xpath                       .//*[@id='app_Kalura_Videos']/img
NoSharedFile                                xpath                       .//*[@id='nosharedfilemsg_theKalturaApp']
ShowShared_chkBox                           css                         #showSharedMediaId
Media_ChkBox_Disable                        xpath                       //input[@class='addToNbChkBox' and contains(@value,'false')]
FileShared                                  xpath                       //input[@class='addToNbChkBox' and not(contains(@value,'false'))] 
Vedio_Button                                css                         #VIDEO
Image_Button                                css                         #init_image
Audio_Button                                css                         #AUDIO
VedioCapture_Button                         css                         #init_videoCapture
Media_CheckBox                              css                         .addToNbChkBox
Capture_Button                              css                         #capture
Capture_error                               css                         .message
Capture_close                               css                         .closeCapture
Hover_edit                                  css                         .mediaSlide.selected.kaltura_edit
edit_button                                 xpath                       //a[contains(@class,'show_editHover')]//img[@alt='Edit']
Media_name                                  css                         #fileNameEditId
Media_no                                    xpath                       .//*[@id='notToBeSharedRadio' and contains(@name,'shareWithStudents_1') ]
Media_save                                  xpath                        //input[@value='Save']
ShowHover                                   xpath                        //a[contains(@class,'show_editHover')]
editNameVerify                              xpath                        //*[contains(text(),'MediaFileEdited.png')]
Media_Remove                                xpath                        //input[@value='Remove']
Hover_edit1                                 xpath                       (//*[@class='mediaSlide selected kaltura_edit'])[1]  
textBefore_textBox                          css                         #textBefore
textAfter_textBox                           css                          #textAfter
image_Button                                xpath                        .//*[@id='container']/img[@title='View Image']
audio_Button                                xpath                        .//*[@id='container']/img[@title='Play Audio']
media_Title                                 xpath                        .//*[@id='contentTitle']
closePreview                                xpath                        .//*[@id='closePreview']
Media_first                                 xpath                        (.//*[@id='container']/img[1])[1]
alpha_sort                                  css                          #init_alpha
Hover_audio                                 css                          .kEntry_AUDIO.media_thumb_cell
mostRecent_sort                             css                          #init_mostRecent
saveDistinctActivity                        id                           addActConfirm
================================================================================================================================= 