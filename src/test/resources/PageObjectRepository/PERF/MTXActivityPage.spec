#Object Definitions
==================================================================================== 
getlbl_TutoredActivity                         xpath                           //div[contains(@class,'week-current')]//div[contains(@data-activity-name,'${description}')]
titleOfActivity                                xpath                           //div[@id='appFrames']//div[contains(@style,'block')]//*[@class[contains(.,'nb_actTitle nb_math')]]
link_submitForTutored                          xpath                           //li[contains(text(),'Submit for Grading')]
CloseActivityButton                            xpath                           //div[@id='appFrames']//div[contains(@style,'block')]//a[@class='closeActivity']
IntoQuickPrep                                  xpath                           (//span[contains(text(),'Introduction and Quick Prep')])[1]
getFrame_Content                               xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Assessments App')]
getFrame_StudyCenter                           xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Study Center App')]
checkOverviewStatus                            xpath                           //*[text()='Preparation']
link_submitForIntro                            id                              submit
lbl_Mastery                                    xpath                           (//span[contains(text(),'Mastery')])[1]
lbl_Review                                     xpath                           (//span[contains(text(),'Review')])[1]
lbl_Challenge                                  xpath                           (//span[contains(text(),'Challenge')])[1]
lbl_StudyGuide                                 xpath                           (//span[contains(text(),'Study Guide')])[1]
gettxt_KeyConcepts                             xpath                           //*[@class='title' and contains(text(), 'Key Concepts')]
CloseStudyGuide                                xpath                           //span[contains(@class,'glyphicon-remove-circle')]
startActivityForTutored                        xpath                           //*[contains(text(),'Start Activity')]
submitForTutored                               id                              nav-group-submit
SubmitActivity                                 xpath                           //div[text()='Submit Activity for Grading']
SubmitConfirm                                  xpath                           //button[@id='warning-submit']
img_DoneActivity                               xpath                           //img[@alt='Done']
checkOverviewStatus                            xpath                           //*[text()='Overview']/parent::div[@class='sel-item']
get_StateForSubmit                             xpath                           //div[@class='nav-groups']//div[contains(@class,'group selected')]
getbtn_Next                                    xpath                           //div[text()='Next']
ActivitySubmitted                              xpath                           //div[text()='SUBMITTED!']
SubmitMastery                                  xpath                           //button[contains(@class, 'submit-final')]
MasteryGroup                                   xpath                           (//div[contains(@class, 'text')])[1]
====================================================================================


