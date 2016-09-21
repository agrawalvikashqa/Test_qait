#Object Definitions
================================================================================================================================= 
plus_btn                                    xpath                               (//i[@class='glyphicon glyphicon-plus'])[5]
createnewpoll_btn                           xpath                               //div[@id='unitWrap4']//button[text()='Create a New Poll']
pollTitle_txt                               css                                 #pollTitleField
pollDescription_txt                         css                                 #pollDescriptionArea
pollQuestion_txt                            css                                 #pollQuestionArea
pollChoiceField_txt                         css                                 #pollChoiceField_0
pollChoiceField1_txt                        css                                 #pollChoiceField_1
pollChoiceField2_txt                        css                                 #pollChoiceField_2
addChoice_btn                               css                                 #addChoiceBtn  
pollChoiceField3_txt                        css                                 #pollChoiceField_3
savePoll_btn                                css                                 #savePollBtn
studentpoll_link                            xpath                               //h4[contains(text(),'${text}')]
question_link                               css                                 p[class='ng-binding']
answer_link                                 css                                 label[class='ng-binding']
answer_radiobtn                             css                                 label[class='ng-binding'] input
vote_btn                                    css                                 .btn.btn-success
polldelete_btn                              css                                 .btn.btn-xs.btn-link.btn-delete