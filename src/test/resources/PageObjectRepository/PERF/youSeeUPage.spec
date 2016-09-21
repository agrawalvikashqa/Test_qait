#Object Definitions
==================================================================================== 
rubricsTab                           linktext               Rubrics
createRubricBtn                      linktext               Create Rubric
rubricInputText                      id                     casestudy_designerbundle_rubric_type_name
editRubrics                          xpath                  //td[contains(.,'${name}')]/parent::*//a[contains(@class,'icon-pencil')]
save_Btn                             xpath                   //input[@value='Save']
flashNotice                          xpath                  //div[contains(@class,'flash-message')]
backBtn                              linktext               Back
deleteRubric                         xpath                  (//td[contains(.,'${name}')]/parent::*//a[contains(@class,'icon-remove')])[1]
addAssignmentBtn                     xpath                  //*[text()='Create Assignment']
youSeeApp_ActivityName               id                     educator_activity_form_name 
activityType_radioBtn                xpath                  //input[@value='document_submission']/parent::*/span[contains(@class,'jq-radio')]
saveAndContinue_btn                  xpath                  //a[contains(.,'Save & Continue')]
instruction_txtArea                  xpath                  //textarea[@id='educator_activity_form_instructions'] 
wholeclass_btn                       id                     educator_activity_form_executorsType_0-styler
groupType_radioBtn                   xpath                  //div[@id='educator_activity_form_groupType']//label[contains(.,'No Peer Review')]/parent::*/parent::*/span[contains(@class,'jq-radio')] 
commentingType_radioBtn              xpath                  //div[@id='educator_activity_form_commentingType']//label[contains(.,'None')]/parent::*/parent::*/span[contains(@class,'jq-radio')]
saveExecutorAndReview_btn            xpath                  //a[contains(@class,'save-executors-and-reviewers')]
feedbackType_checkbox                xpath                  //input[@id='educator_activity_form_textFeedbackEnabled']/parent::*/span[contains(@class,'jq-checkbox')]
activityScore_textBox                xpath                  //input[@id='educator_activity_form_cengageActivityScore']
savegradeandfeedback_btn             xpath                  //a[contains(@class,'save-grade-and-feedback')] 
pagetitle                            xpath                  //h1[contains(.,'Available assignments.')]
addAssignment                        xpath                  //input[@value='Continue']
ddl_orderButton                      xpath                  //a[@id='order-button']/span[@class='ui-selectmenu-status']
saveActivity_btn                     linktext               Save

====================================================================================