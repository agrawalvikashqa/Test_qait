#Object Definitions
==================================================================================== 
AddAA_txt                       xpath                         (//input[contains(@class,'activitySelector')])[1]
continue_btn                    xpath                         //div[contains(@class,'prebuiltActivitySelector')]//input[contains(@class,'continueButton navButton')]
AAType_dropdown                 xpath                         //select[contains(@name,'assignableType') and contains(@class,'field')]
continueAA_btn                  xpath                         //form[contains(@class,'assignmentOptionsSelector')]//input[contains(@class,'continueButton navButton')]
Practice_checkbox               xpath                         //*[@id='gradingMode_practice']
Nav_back                        xpath                         //span[contains(@class,'lpn_back')]
Save_btn                        xpath                         //input[contains(@class,'continueButton navButton') and contains(@value,'Save Changes')]
SubmitActivity_btn              xpath                         //a[contains(text(), 'Submit Activity')]
Submit_btn                      xpath                         //input[contains(@class, 'submitGrading')]
Hidden_text                     xpath                         //a[contains(text(),'${description}')]/../..//span[contains(text(),'Hidden From Students')]
Hide_datemanager                xpath                         //div[contains(@title,'${description}')]//img[contains(@title,'Hidden from Students')]
Progress_Overview               xpath                         //div[contains(text(), 'Overview')]
rmv_hidden                      xpath                         //a[contains(@class, 'navLink courseejs_removehidden')]
lpn_title                       xpath                         //div[@id='lpn_toolbar']/h2
hide_activity                   xpath                         //a[contains(text(), '${description}')]
set_duedate                     xpath                         (//div[contains(@title, '${description}')]/..//img[contains(@class, 'datemanageractivity_enddate')])[1]
done_btn                        xpath                         //button[contains(text(),'Done')]
dueDate_lpn                     xpath                         //a[contains(text(), '${description}')]/../..//ul/li[contains(text(), 'Due')]
overview_PA                     xpath                         //div[contains(text(),'Overview')]
hiddenactivity_PA               xpath                         (//span[contains(@title,'${description}')])[1]
====================================================================================

