#Object Definitions
================================================================================================================================= 
InsiteLink                                                id                             InSite
Paper_AssignmentRadio_Button                              id                             paper
CreateAssignmentButton                                    id                             createNewAssignment
AssignmentTitle_textbox                                   id                             assignmentTitle
GradedRadio_Button                                        id                             gradingMode_graded
Submit_Button                                             id                             assignmentSubmit
More_Options                                              xpath                          //a[text()='More Options']
sav_btn                                                   xpath                          //span[text()='Save']
Peermark_AssignmentRadio_Button                           id                             peermark
Continue_PeerButton                                       xpath                          .//input[@class='continuePeerMark']
Done_PeerButton                                           xpath                          //input[@class='peerMarkDone']
peer_AssignTab                                            xpath                          //a[@class='btn-link assignment-tab']
peermark_DisagreeButton                                   xpath                           .//form[@id='agree-form']/a
peermark_AgreeButton                                      xpath                          .//form[@id='agree-form']/input[2]


AssignmentName_TextBox                                  xpath                           //input[@id='title']
AssignmentDescription_TextBox                          xpath                           //textarea[@id='description']
GradedTypeRadioButton                                   xpath                           //input[@id='${value}']
PossibleScore_TextBox                                   id                              pointsPossible
SubmitButton                                            id                              submit     
upload_Button                                           xpath                           //span[@title='Upload']
filepath                                              xpath                                //a[@id='submission_select']
submissionTitle                                     id                                  submission_title
copyPaste_Button                                    xpath                               //a[@class='btn-link paste-link']
submissionTextArea                                     xpath                               //textarea
submissionFrame_Button                                  xpath                           //a[@class='btn btn-primary continue']
acceptSubmission_btn                            xpath                               //a[@class='btn btn-small btn-primary text-accept']   
instructor_GradeIcon                            xpath                               //i[@class='icon icon-pencil']   
gradeField                                      xpath                               //input[@class='field' and @value='--']
error_Validate                                  xpath                               //span[@class='error help-block' and text()='Please enter at least 4 characters.']
score_validate                                  xpath                               //span[@class='error help-block' and text()='Please enter only digits.']
settingsTab                                     xpath                               //a[text()='Settings']
optionalSettings_link                           xpath                               //b[text()='Optional settings']
lateSubmission_NoRadioButton                      xpath                            //input[@id='late_accept_flag2']
lateSubmission_YesRadioButton                   xpath                               //input[@id='late_accept_flag1']
checkbox_compareSubmitAssignment                xpath                               //label[@class='checkbox']
uncheckCheckbox_studentpaperRepository          xpath                               //label[@class='checkbox'][1]
viewOriginalityReport_Checkbox                  xpath                               //input[@name='s_view_reports' and @value="${value}"]
peermark_Checkbox                               xpath                               //input[@name='peermark' and @value="${value}"]
defaultNoRubric                                 xpath                               //select[@id='rubric']//option[@label="No rubric"]
launchRubric_Link                               xpath                               //a//span[text()='Launch Rubric Manager']
additionalOption                                xpath                               //a[@data-toggle='dropdown']       
googleDrive                                     xpath                               //a[contains(@class,'google-link')]
insite_title                                    xpath                               //input[@id='title']
insite_descrpition                              xpath                               //textarea[@id='description']
practice_Radio                                  xpath                               //input[@id='practiceRadio']


================================================================================================================================= 