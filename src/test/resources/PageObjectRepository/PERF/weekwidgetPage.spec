#Object Definitions
==================================================================================== 
wdgt_weekview                         id                           weekview
accept_btn                            xpath                        //a[contains(text(),'Accept')]
btn_allApps                           id                           app_toggle
getLink_Notification                  id                           linkAllNotifications
getPerformanceWidget                  id                           performanceContent
getCurrentScoreWidget                 xpath                        //*[@id='perfClassAverageScoreWidget']//div[contains(text(),'%')]
getMessages                           xpath                        //*[@id='notificationsSummaryView']//div[contains(@class,'messageText')]
CengageLearningLogo                   xpath                        //a[@class='nb_logoBox' and @title='About this Course']/img
btn_conceptMap                        xpath                        //div[@class='perfLinks']/a[contains(text(),'Concept')]
accept_btn_stud                       xpath                        //a[contains(text(),'Accept')]
get_UserMenu                          xpath                        //*[@class[contains(.,'user-menu-link')]]
UserMenuCustomerSupport               xpath                        //a[contains(text(),'Customer Support')]
CustomerSupportText                   xpath                        //span[@id='support_link']//*[contains(text(),'Customer Support')]
UserMenuLogout                        xpath                        //a[contains(text(),'Logout')]
UserMenuSystemCheck                   xpath                        //a[contains(text(),'System Check')]
weekSlider                            id                           weekSlider
weekSliderPointer                     id                           slider-pointer
previousWeekArrow                     id                           prevWeek
nextWeekArrow                         id                           nextWeek
unitHeaderInActiveWeek                xpath                        //div[contains(@class,'week-current')]//h2
DueDateUnderUnitHeading               xpath                        //div[contains(@class,'week-current')]//*[@class='dayLabel']/span
specificWeek                          xpath                        //*[@id='weekSlider']/div[${description}]
specificWeek2                         xpath                        //*[@id='weekSlider']/div[${description}+1]
totalNumberOfWeeks                    xpath                        //*[@id='weekSlider']/div[contains(@class,'sliderDivider')]
CurrentVisibleWeekValue               xpath                        //*[contains(@class,'week-current')]//h2
get_ReqWeek                           xpath                        //*[@id='calendar']//*[contains(@class,'week-current')]//h2[contains(text(),'Week ${description}')]
ActivityInActiveWeek                  xpath                        //*[contains(@class,'week-current')]//*[@class='available-date-label']
PiIconInActiveWeek                    xpath                        //div[contains(@class,'week-current')]//*[contains(@class,'studentProgressContainer')]
MessagesInNotificationWidget          xpath                        (//*[@id='notificationsSummaryView']//div[contains(@class,'messageText')])[1]
MessagesTimestampInNW                 xpath                        (//*[@id='notificationsSummaryView']//div[contains(@class,'messageFooter ')])[1]
getLink_AllScore                      id                           allScores
btn_allApps                           id                           app_toggle
lbl_appName                           xpath                        //div[@class='dockGroup']/li/a/img
NoActivities                          xpath                        (//div[contains(@class,'emptyWeekMessage')]//div[contains(text(),'No activities')])[1]
ListOfStatusIcon                      xpath                        //div[contains(@class,'week-current')]//i[contains(@class,'statusIcon')]
ListOfAssignmentName                  xpath                        //div[contains(@class,'week-current')]//div[contains(@class,'assignmentName')]
getSubmittedIndicator                 xpath                        //div[contains(@class,'week-current')]//ul[contains(@class,'assignments ')]//*[contains(text(),'${description}')]/parent::div/parent::div/parent::div/i[contains(@title,'Submitted')]
getInProgressIndicator                xpath                        //*[contains(@class,'week-current')]//ul[contains(@class,'assignments ')]//*[contains(text(),'${description}')]/parent::div/parent::div/parent::div/i[contains(@title,'Progress')]
getNotStartedindicator                xpath                        //*[contains(@class,'week-current')]//ul[contains(@class,'assignments ')]//*[contains(text(),'${description}')]/parent::div/parent::div/parent::div/i[@title='']
====================================================================================
