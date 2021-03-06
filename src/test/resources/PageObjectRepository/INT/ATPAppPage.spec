#Object Definitions
==================================================================================== 
CreateANewTestBtn             xpath                //div[@class='panel-heading']/following-sibling::div[@class='panel-body']/button[text()='Create A New Test']
ChapterTestCheckBoxes         xpath                //input[@type='checkbox' and contains(@ng-model,'chapter')]
totalSelectedItems            xpath                //span[contains(@class,'text-info') and contains(@ng-bind,'totalSelectedItems')]
homeBtn                       xpath                //i[contains(@class,'home')]
previewtabtitle               xpath                //span[@class='brand' and text()='Adaptive Test Prep']
chaptersNames                 xpath                (//span[contains(@class,'chapterTitle')])[${index}]
takeTestNow_btn               xpath                //h3[text()='Test Overview']//../following-sibling::div[@class='panel-footer']/button[text()='Take Test Now']
QuestionCount                 xpath                //input[@id='totalItems']
dropdown-toggle               xpath                //i[@class='fa fa-th']
navigateToPage                xpath                //span[@class='ng-binding' and text()='${QuestionCount}']
disablednextBtn               xpath                //li[@class='btn btn-primary disabled']
submitAndReviewBtn            xpath                //a[text()='Submit & Review Test'] 
submitBtn                    xpath                 //button[@class='btn btn-primary' and text()='Submit']
pastAttemptsTabTitle         xpath                 //a[contains(@ng-click,'review')]
pastAttemptsbtn              xpath                 //button[contains(@ng-click,'review')]  
retakeButton                 xpath                 //button[contains(@class, 'btn btn-primary') and text()='Retake This Test']
Retakecriteria               xpath                 //input[@type='radio']/following-sibling::strong[contains(text(),'${criteria}')]
takeTestNowButton            xpath                 //button[contains(@class,'btn btn-primary') and contains(@ng-disabled,'retake')]
attemptedQuestion            xpath                 //i[contains(@class,'${type}')]
attemptedQuestionwithIndex   xpath                 (//i[contains(@class,'${type}')])[1]
CurrentTest_Radio             xpath                 (//input[@type='radio'])[1]
Next_Btn                     xpath                 //li[@class='btn btn-primary']
inLineVideo_Img              xpath                 (//a[contains(@ng-click,"Video")]/img)[1]
dismiss_btn                 xpath                 //i[contains(@ng-click,"dismiss")]
eReader_link                xpath                 //span[text()='eReader']
dockFrameTitle              xpath                 (//span[@class='appActionFrame_actionLabel'])[2]
close_Btn                   xpath                 (//a[@title='Close App'])[${appIndex}]
Feedback_text               xpath                 (//span[text()='Feedback: '])[1]
====================================================================================