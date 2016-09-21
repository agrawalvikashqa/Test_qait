
#Object Definitions
========================================================================================================
lbl_appName                          xpath          //div[contains(@class,'dockGroup')]/li/a/img
dockGroup1                           xpath          //div[@id='dockGroup1']/li
appNameLink                          xpath          //div[contains(@class,'dockGroup')]/li/a
HeadingNameOfTheApp                  xpath          //div[contains(@id,'NB_App_DockItem') and contains(@style,'display: block')]//h2/span[text()="${appName}"]
getCollapse                          xpath          //div[contains(@id,'NB_App_DockItem') and contains(@style,'display: block')]//a[contains(@class,'hideApp')]
getCollapse                          xpath          //div[contains(@id,'NB_App_DockItem') and contains(@style,'display: block')]//a[contains(@class,'hideApp')]
FullGradebook                        id             allScores
getTab_Week                          xpath          //*[@panes='tabs']//li[contains(@title,'Week View')]
getTab_DateManager                   xpath          //*[@panes='tabs']//li[contains(@title, 'Date Manager')]
getTab_ListView                      xpath          //*[@panes='tabs']//li[contains(@title, 'List View')]
getTab_Unit                          xpath          //*[@panes='tabs']//li[contains(@title, 'Unit View')]
LPNUnitImg                           xpath          (//*[@id='lpn_list_area']//div[@class='thumbBar']/img[contains(@src,'unit')])[1]
Search_TxtBox                        xpath           //input[contains(@class, 'search') and contains(@type, 'text')]
StudyCenter_txt                      xpath           //h3[contains(text(), 'QuizMe')]
RssFeed_txt                          xpath           //span[contains(text(), 'Available Feeds')]
chemistryReference_txt               xpath           //a[contains(text(), 'Elements')]
Flashcard_txt                        xpath           //span[contains(@class, 'ui-selectmenu-status')]
FullBook_txt                         xpath           //a[contains(text(), 'Chapters')]
Glossary_txt                         xpath           //span[contains(text(), 'Glossary Terms')]
Gradebook_txt                        xpath           //div[contains(text(), 'Gradebook')]
studentGradebook                     id              studentName
Dictionary_txt                       xpath           //p[contains(text(), 'Merriam-Webster')]
Unit_Back                            xpath           //span[contains(@style,'display: block')]/a[contains(text(), 'back') and contains(@class, 'navLink')]
========================================================================================================