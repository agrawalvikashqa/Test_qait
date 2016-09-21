pagetitle: My Home

#Object Definitions
====================================================================================
courseAndMaterials_txt                    xpath                   //*[contains(text(),'My Courses') and contains(text(),'Materials')]
open_btn                                  xpath                   //a[@class='viewDetailsBtn aplia_button' and contains(@onclick,'courseKey=${coursekey}')]
open_btn_student                          xpath                   //a[@class='viewDetailsBtn aplia_button' and contains(@href,'${coursekey}')]
graceBtn                                  css                     .gracePeriodBtn
courseURL1                                 css                     #courseURL
====================================================================================