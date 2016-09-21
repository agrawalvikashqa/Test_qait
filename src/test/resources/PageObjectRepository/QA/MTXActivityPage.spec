#Object Definitions
==================================================================================== 
getlbl_TutoredActivity                         xpath                           //div[contains(@class,'week-current')]//div[contains(@data-activity-name,'${description}')]
titleOfActivity                                xpath                           //div[@id='appFrames']//div[contains(@style,'block')]//*[@class[contains(.,'nb_actTitle nb_math')]]
link_submitForTutored                          xpath                           //li[contains(text(),'Submit for Grading')]
CloseActivityButton                            xpath                           //div[@id='appFrames']//div[contains(@style,'block')]//a[@class='closeActivity']
IntoQuickPrep                                  xpath                           (//span[contains(text(),'Introduction and Quick')])[1]
getFrame_Content                               xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Assessments App')]
getFrame_StudyCenter                           xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Study Center App')]
checkPreparationStatus                         xpath                           //*[text()='Preparation']
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
img_DoneActivity                               xpath                           //div[@class='nb_statusIcon']//img[@alt='Submitted']
checkOverviewStatus                            xpath                           //li[contains(@id, 'nav-group-overview') and contains(text(), 'Overview')]
get_StateForSubmit                             xpath                           //div[@class='nav-groups']//div[contains(@class,'group selected')]
getbtn_Next                                    xpath                           //div[text()='Next']
ActivitySubmitted                              xpath                           //div[text()='SUBMITTED!']
SubmitMastery                                  xpath                           //button[contains(@class, 'submit-final')]
MasteryGroup                                   xpath                           (//div[contains(@class, 'text')])[1]
PicturingHistory                               xpath                           (//span[contains(text(),'Picturing History')])[1]
startActivityHistory                           xpath                           //button[contains(text(), 'Start Activity')]
checkAnswer                                    xpath                           //button[contains(text(), 'Check Answer')]
getHistoryFrame_Content                        xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'MindApp CXP App')]
NarrativeConceptual                            xpath                           (//span[contains(text(),'A Growing World')])[1]
LensActivity                                   xpath                           (//span[contains(text(),'Lens')])[1]
EssayActivity                                  xpath                           (//span[contains(text(),'Essay Activity')])[1]
ParentActivityChoice                           xpath                           (//span[@class='ci-choice-indicator']/input[contains(@class,'ci-input')])[1]
ChoiceContinuebtn                              xpath                           //button//span[contains(text(), 'Continue')]
HistoryParentFrame                             xpath                           //div[@id='subactivity-container']/iframe[@name='activityService']
CloseSubmit                                    xpath                           //button[contains(text(), 'Close and Submit')]
LastBHead                                      xpath                           (//div[contains(@data-ng-class, '$index==selectedIndex')])[last()]
CloseSubmitWarning                             xpath                           //button[contains(text(), 'Close and Submit') and contains(@class, 'btn-secondary left orange')]
activityLaunch_Link                            xpath                           //div[@class='assignmentName' and @data-activity-name = '${value}']
activityOverview_Header                        xpath                           //b[text()='${value}']
cancel_btn                                     xpath                           //button[text()='Cancel']
gradeLabel                                     xpath                           //p[contains(text(), 'This is a graded activity worth')]
attemptLabel                                   xpath                           //p[contains(text(),'You can attempt each question set up to')]
connectionLost_Label                           xpath                           //p[contains(text(),'If you lose connection during your attempt, you will be able to resume the assignment within a few minutes')]
startActivity_btn                              xpath                           //button[text()='Start Activity']
continue_btn                                   xpath                           //button[text()='Continue']
activityInfo_icon                              xpath                           //span[text()='Activity Overview']
activityReading_btn                            xpath                           //span[text()='${value}']
activityTitle                                  xpath                           //div[text()='${value}']
activityScore                                  xpath                           //li[contains(text(),'points')]
activityManual                                 xpath                           //li[text()='Manually Graded Activity']
submittedDecorator                             xpath                           //div[@class='nb_statusIcon']/img[@alt='Submitted']
review_btn                                     xpath                           //input[@value='Review']
submitted_btn                                  xpath                           //button[(contains(text(),'Submitted'))]
close_activity                                 xpath                           //a[@id='app_activity_frame_closeActivity']
activity_overview_btn                          xpath                           //span[text()='Activity Information']
collapse_link                                  xpath                           //button[contains(text(),'Collapse')]
expandLink                                     xpath                           (//div[@class='accordion-collapsed-mask'])[1]
InProg_SI                                      xpath                            //div[@data-activity-name='${value}']/..//i[@title='In Progress']
submitted_SI                                   xpath                            //div[@data-activity-name='${value}']/..//i[@title='Submitted']
check_answer_btn                               xpath                            //button[contains(text(),'Check Answer')]
dis_board_post_new_message_btn                 xpath                            //button[contains(text(),'Post new message')]
close_and_submit_btn                           xpath                            //button[contains(text(),'Close and Submit')]
discussion_board_tips_link                     xpath                            .//*[@id='postArea']//a/h5[contains(.,'Discussion board writing tips')]
unit_study_guide_heading                       xpath                            .//*[@id='study-guide']//h4[contains(.,'Unit Study Guide')]
infoIcon                                       xpath                           //span[@class='glyphicon glyphicon-info-sign']
overview_Continue_btn                          xpath                           //button[text()='Continue']
try_again_btn                                  xpath                            //button[contains(text(),'Try Again')]
activityDate                                   xpath                            //div[@class='nb_actStatus' and contains(text(),'Due')]
sourceContent_loadVerify                       xpath                            //div[@class='ci-question']
returnActivity_btn                             xpath                            //button[text()='Return to the Activity']
closeSubmitButton_lensPage                     xpath                            //button[text()='Close and Submit']
performanceDot                                 xpath                            //div[contains(@id, 'perfPopup')]//strong[contains(text(), '${description}']
possibleScoreInActivity                        xpath                            //span[@id='lhs-possible-score']
submitAns_btn                                  xpath                            //div[text()='Submit Answer']
nextbtn                                        xpath                           //div[@class='button sel-next enabled']
submitAns_btn                                  xpath                           //div[text()='Submit Answer']
======================================================================================================================================================



