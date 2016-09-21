
#Object Definitions
====================================================================================
courseName_link                       xpath              //a[contains(@href,'courseKey=${coursekey}')]
book_link                              id                productISBN
edit_csm_course_link                  xpath              //a[contains(.,'Automation_CSM')]/../..//a[@title='Edit Course'] 
add_inst_ta_link                      xpath              //a[contains(text(),'Additional Instructor or TA')]
add_coinst_email_txtbox               xpath              //input[@id='instructorEmail']                
add_btn                               xpath              //input[@id='AddButton']
course_info_header                    xpath              //h1
save_changes_btn                      xpath              //a[contains(text(),'Save Changes')]
heading_manage_courses                xpath              //h1[contains(text(),'Manage')]
user_menu_link                        xpath              //div[@id='nb_menu_overlay']//a[@class='user-menu-link tb_item']
logout_link                           linktext           Logout
logout_mt_text                        xpath              //div[@id='logout']/h1
course_settings_close_btn             xpath              //a[@class='nb_closeIcon nb_closeRight']
course_settings_link                  xpath              //a[contains(text(),'Course Settings')]
course_settings_title                 xpath              //h2[@id='manageUsersTitle' AND contains(text(),'Course Settings')]
inst_ta_expand                        xpath              //span[text()='Instructor and TA Permissions']
co_inst_expand                        xpath              //*[@id='capabilitiesDiv']//h4[text()='Inst24 Mtx (Instructor)']
primary_inst_expand                   xpath              //*[@id='capabilitiesDiv']//h4[text()='Instructor Automation (Instructor)']
teach_assist_expand                   xpath              //*[@id='capabilitiesDiv']//h4[text()='mt ta (Teaching Assistant)']
co_inst_capabilities_allchkboxes      xpath              //h4[contains(.,'Inst24')]/..//input
ta_capabilities_allchkboxes           xpath              //h4[contains(.,'Teaching Assistant')]/..//input
ta_manage_lpn_cap_chkbox              xpath              //h4[contains(.,'Teaching Assistant')]/..//label[contains(.,'Manage learning path')]/input
ta_grade_capability_chkbox            xpath              //h4[contains(.,'Teaching Assistant')]/..//label[contains(.,'Gradebook')]/input
save_permissions_btn                  xpath              //button[text()='Save Permissions']
csm_done_btn                          xpath              //button[contains(.,'Done')]
ta_set_dd_chkbox                      xpath              (//li/input[@type='checkbox'])[1]
ta_dd_calender                        xpath              (//a[@title='Due Date']/following-sibling::img)[2]
date_manager_view_tab                 xpath              //div[@id='viewtoggle']//..//li[@title='Date Manager View']
date_manager_done_btn                 xpath              //*[@id='ui-datepicker-div' and contains(@style,'block')]//button[text()='Done']
date_manager_clear_btn                xpath              //*[@id='ui-datepicker-div' and contains(@style,'block')]//button[text()='Clear']
remove_coinst_ta_cross_btn            xpath              //a[@class='linkDeleteInstructor']
====================================================================================