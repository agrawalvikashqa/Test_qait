#Object Definitions
==================================================================================== 
checkPreparationStatus                         xpath                           //*[text()='Preparation']
getFrame_Content                               xpath                           //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Assessments App')]
currentScore                                   xpath                           //div[@class='scoreIndicator']
nextbtn                                        xpath                           //div[@class='button sel-next enabled']
checkbox1                                      xpath                           (//input[@class='ci-input'])[1]
checkbox2                                      xpath                           (//input[@class='ci-input'])[2]
checkbox3                                      xpath                           (//input[@class='ci-input'])[3]
feedback_title                                 xpath                           //div[@class='ci-feedback-title']
tryAnotherVersion                              xpath                           //div[contains(@class, 'retry-button enabled')]
unlimitedAttempts                              xpath                           //div[contains(text(),'Unlimited question attempts remaining')]
QuestionItems                                  xpath                           //div[contains(text(), 'Question')]
backBtn                                        xpath                           //div[@class='button sel-prev enabled']
disableBackBtn                                 xpath                           //div[@class='button sel-prev']
submitAnswer                                   xpath                           //div[contains(text(), 'Submit Answer')]
currentScoreSubmit                             xpath                           //div[@id='scoreDisp']
link_submitForIntro                            id                              submit
SubmitActivity                                 xpath                           //div[text()='Submit Activity for Grading']
currentScoreDashboard                          xpath                           //div[@class='perfScoresLeft']//div[@class='inner-score ng-binding']
classAverage                                   xpath                           //div[@class='perfScoresRight']//div[@class='inner-score ng-binding']
backVerification                               xpath                           //p[contains(text(), '${value}')]
possibleScoreInActivity                        xpath                           //span[contains(@id, 'lhs-possible-score')]
submittedText                                  xpath                           //*[@id='rhs-part-submit']/p
autoSave                                       xpath                           //div[contains(@class, 'autosave')]
======================================================================================================================================================

