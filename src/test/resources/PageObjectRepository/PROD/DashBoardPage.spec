#Object Definitions
====================================================================================
app_name   		             xpath           //a[contains(@id,'${appName}')]
expandDockBtn                        xpath           //a[@class='nb_expandDock']
appActionFrameTitle                  xpath           //div[contains(@style,'display: block') and contains(@id,'DockItem')]
addContent_btn                       xpath           //span[@class='lpn_create']
addActivity_link                     xpath           //*[@class='lpn_create active']//*[@class='menu_item activity']/a    
addedActivity_text                   xpath           //h1[text()='Add Activity'] 
activityName_link                    xpath           //h3[contains(text(),'${activityName}')]
add_title                            xpath           //input[@id='name']
add_Discription                      xpath           //textarea[@id='description']
selectMenu_Order                     xpath           //div[@class='order_select']//span[contains(@class,'ui-selectmenu-status')]
selectPosition                       xpath           //ul[@id='order-menu']//li['${position}'] 
saveActivity_btn                     xpath           //span[@id='init_save']
view_tab                             xpath           //li[@title='${_view_Tab}']  
activityTitle_link                   xpath           (//h3[@class='lpn_name']/a[contains(.,'${activity_title}')])[1]
FolderTitle_link                     xpath            //h3[@class='lpn_name group']/a[contains(.,'${activity_title}')]
lpnActivity_link                     xpath           //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*
activityDelete_icon                  xpath           //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*//a[@title='Delete']
close_Activity                       xpath           //a[@title='Close Activity']
activityEdit_icon                    xpath           //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*//a[@title='Edit']  
editOption_btn                       xpath           //input[contains(@class,'editOptions ') and @value='Edit Options']
aboutCengageLink                     xpath           .//a[text()='About Cengage Learning']
AboutUs                              xpath           .//*[@id='splash_contentdiv']/h3[contains(text(),'About Us')]
copyrightStatmentLink                xpath           .//a[text()='Copyright Statement']
copyrightInfo                        xpath           .//*[@id='header']/h1[contains(text(),'Copyright')]
serviceAgreementLink                 xpath           .//a[contains(text(),'Service Agreement')]
serviceAgreementInfo                 xpath           .//*[@id='splash_contentdiv']/h3[contains(text(),'SERVICE AGREEMENT')]
CourseName                           xpath           //span[@class='courseName']
creditsLink                          xpath           .//a[text()='Credits']
creditsInfo                          xpath           .//h1[contains(text(),'Credits')]
bookCoverLink                        xpath           .//a[text()='Book Cover']
coverImage                           xpath           .//div[@class='splash_cover']/img
closeButton                          xpath           .//a[contains(@class,'splash_close nb_closeIcon')]
getCengageLogo                       xpath           //div[@class='nb_logoBox']
helpIcon                             id              help
helpoverlayPane                      xpath           //*[contains(@class,'ui_help_overlay')]
helpoverlayPaneButton                xpath           //*[contains(@class,'ui_help_overlay')]//a
wdgt_weekview                        id              weekview
AllScoreLink                         id              allScores    
getTab_Week                          xpath           //*[@panes='tabs']//li[2]
getTab_DateManager                   xpath           //*[@panes='tabs']//li[4]
getTab_Unit                          xpath           //*[@panes='tabs']//li[3]
OpenFullGradebook                    xpath           //*[@class='perfLinks']/a[text()='Open Full Gradebook']
getProgressFrame                     xpath           //iframe[@data-app-name='Cengage.Progress']
getGradebookHeading                  xpath           .//*[@id='headerTabs']//div[text()='Gradebook']
apphidebtn                           xpath           //a[contains(@onclick,'${Progress}') and contains(@class,'hideApp')]
AllNotifications                     id             linkAllNotifications
AllNotificationsFrame                xpath            //iframe[@data-app-name='Cengage.MessageCenter']
MessageTextBox                       xpath           .//*[@id='message']
weekviewArea                         id              weekview
lpnListArea                          id              lpn_list_area
dateManagerArea                      id              date_manager_area
app_toggleBtn                        id              app_toggle
lbl_appName                          xpath           //div[contains(@class,'dockGroup')]/li/a/img
dockGroup1                           xpath           //div[@id='dockGroup1']/li
appNameLink                          xpath          //div[contains(@class,'dockGroup')]/li/a
HeadingNameOfTheApp                  xpath          //div[contains(@id,'NB_App_DockItem') and contains(@style,'display: block')]//h2/span[text()="${appName}"]
getCollapse                          xpath          //div[contains(@id,'NB_App_DockItem') and contains(@style,'display: block')]//a[contains(@class,'hideApp')]
logout_link                          linktext       Logout
userMenuOpts                         xpath          //a[@class='menuItem' and contains(text(),'${menuOption}')]
CourseSettingsDialog                 id             course_settings
closeIcon                            xpath         //a[@class='nb_closeIcon nb_closeRight']
add_link                             xpath         //span[@class='lpn_create']
menu                                 xpath         //ul[@class="menu"]
newFolder_link                       linktext      Add Folder
adminForm                            xpath          //div[contains(@class,'mxui_layout_modal')]
folderTitle                          xpath         //input[@id='name']
save_btn                             linktext      Save
order-menu                           xpath         /ul[@id='order-menu']/li[${position}]
unitName                             id            name
lpn_description                      xpath         //span[@class='lpn_description' and contains(.,'${description}')]
inline_description                   xpath         //span[@class='inlineTextBefore' and contains(.,'${description}')]

description_textField                id            description
activitiesList                       xpath         //div[@id='activitiesList']/li
cancelbutton                         id            cancelbtnId
activitiesList                       xpath         //div[@id='activitiesList']/li 
typeList                             xpath         //ul[contains(@class,'typeList')]/div/li
StudentEmail                         xpath         //span[contains(@data-e2e-id,'StudentEmail')]
Instructor_collapse                  xpath         //span[text()='Instructor and TA Permissions']
Dashboard_collapse                   xpath         //span[text()='Dashboard']
Student_ID_collapse                  xpath         //span[text()='Student ID Collection']
Partner_App_collapse                 xpath         //span[text()='Partner App Opt-Out']
Gradebook_collapse                   xpath         //*[text()='Gradebook Settings']
Instructor_auto_collapse             xpath         //*[text()='Instructor Automation (Instructor)']
save_Button                          xpath         //button[text()='Save Permissions']
Dashboard_View                       xpath         //select
SaveSetting_Dashboard                xpath         (//button[text()='Save Settings'])[1]
StudentID_Dashboard                  xpath         (//button[text()='Save Settings'])[2]
PartnerApp_Dashboard                 xpath         (//button[text()='Save Settings'])[3]
Studentid_CheckBox                   xpath         //input[@name='studentIdCheckbox']
Studentid_CB_enable                  xpath         //*[@class='secondarySettingsGroup disabled']
Partner_app_enable                   xpath         //input[@name='app_36']
SystemCheck_title                    xpath         (//span[text()='System Check'])[1] 
Browser                              xpath         //*[text()='Browser'] 
Javascript                           xpath         //*[text()='Javascript']
Cookies                              xpath         //*[text()='Cookies']
Flash                                xpath         //*[text()='Flash']
Popups                               xpath         //*[text()='Popups']
Browser_pass                         xpath         //*[@class='messagebox passed' and @id='browser']
JavaScript_pass                      xpath         //*[@class='messagebox passed' and @id='javascript']
Flash_pass                           xpath         //*[@class='messagebox passed' and @id='flash']
Popups_fail                          xpath         //*[@class='messagebox failed' and @id='popups']
Popups_pass                          xpath         //*[@class='messagebox passed' and @id='popups']
Cookies_pass                         xpath         //*[@class='submessage passed' and @id='localcookies']
CustomerSupport                      xpath         //*[text()='Customer Support']
LogOut_Msg                           xpath         //*[text()='You have logged out or timed out of your MindTap session.']
HomeButton                           xpath         //a[contains(.,'Home')]
YesButton                            xpath         //a[contains(.,'Yes')]
NoButton                             xpath         //a[contains(.,'No, please create a new case')]
SignInButton                         xpath         //a[contains(.,'Sign-in')]  
aboveAverge                          xpath         //div[@class='perfScoresWrapper ng-scope']/following-sibling::div[@class='perfTitleAndLinks']
DefaultPercent                       xpath         //*[@class='inner-score ng-binding' and contains(text(),'%')]
ClassAverageScore                    xpath         //*[@class='inner-score ng-binding']
classUpdateScore                     xpath         //*[@class='class_average']
WeekViewActive                       xpath         //*[@class='ng-scope active pane-week pane']
DragPos                              xpath         .//*[@id='weekSlider']/div[02]
DragPosWeek2                         xpath         .//*[@id='weekSlider']/div[03]
DropPos                              xpath         .//*[@id='weekSlider']/div[26]
NavButtonRight                       xpath         //*[@class='navButton right']
NavButtonLeft                        css           #prevWeek
verifyWeek                           xpath         //*[text()='Week 25']
noActivity                           xpath         //div[@week='currentWeek']//following-sibling::div[@class='special-week-content']//div//div[text()='No activities due this week.']
unitView                             xpath         //li[@title='Unit View']
startDate                            xpath         .//*[@id='startDate']
dueDate                              xpath         .//*[@id='endDate']
setDone                              css           button[class*='date-clear date-close']
checkAct                             xpath         (//span[contains(.,'Distinct Web Link Activity')])[1]
dashboardCheckbox                    xpath         //input[@name='dashboardCheckbox']
dashboard_Cb_Disable                 xpath         //select[@disabled='disabled']
lpnTitle                             xpath         (//span[@class='lpn_title ng-binding'])[1]
pathEdit                             css           .required.validates
pathSave                             xpath         //a[contains(.,'Save')]
barGraph                             xpath         (//*[@class='progress-bar'])[1]
Progress                             xpath         (//span[@class='ng-scope' and contains(@title,'submitted')])[1]
gradableIcon                         css           li[class$='activity-gradable']
PracticeIcon                         css           li[class$='activity-practice']
SubmittedPresent                     xpath         (//i[@title='Submitted'])[1]
DueSoonPresent                       xpath         (//i[@title='Due Soon'])[1]
inProgressPresent                    xpath         (//i[@title='In Progress'])[1]
PerformanceWidgetTitle               xpath         //*[@id='perfTitleText']
dotLength                            xpath        .//*[contains(@id,'perfPopup')]
notGraded                            xpath        .//*[@class='notGraded']
notGradedScore                       xpath        .//*[@id='perfPopup-2']/div[2]/p[1]/span
notGradedAttempt                     xpath        .//*[@id='perfPopup-2']/div[2]/p[1]
notGradedDate                        xpath        .//*[@id='perfPopup-2']/div[2]/p[2]
lpnActivity_link                     xpath         //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*
activityHide_icon                    xpath         //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*//a[@title='Show/Hide'] 
activityShow_icon                    xpath         //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*//img[@class='show buttonsejs_show'] 
myGrade                              xpath         //*[text()='My Grades']
Grades_label                         xpath         //a[contains(text(),'${description}')]/../..//img[@title='Counts toward grade']
Practice_label                       xpath         //a[contains(text(),'${description}')]/../..//img[@title='Practice Activity']
addtolocation                        xpath           //label[contains(text(),'Add to Location')]/..//span[contains(@class,'ui-selectmenu-status')]
nb_thumbTitle                        xpath           //div[contains(@style, 'block')]//div[@class="nb_thumbTitle"]
Remove_InLine                        xpath           (//div[contains(@style, 'block')]//a[@title="Remove"])[${description}]
activityShow_icon                    xpath           //h3[contains(@class,'lpn_name') and contains(.,'${activity_title}')]/parent::*/parent::*/parent::*//img[@class='show buttonsejs_show']
selectchapter_location               xpath           //li[contains(@class,'unit_icon')]/a[contains(text(),'${description}')]
selectTop_location                   xpath           //li[contains(@class,'path_icon')]/a[contains(text(),'${description}')]
YellowDot                            xpath           (//*[@class='fair'])[1]
mtlogo                               xpath             //img[@alt='MindTap Logo']
search_app_tips_txt                  xpath           .//*[@id='init_whatCanI']
====================================================================================