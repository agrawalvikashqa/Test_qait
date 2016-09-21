
#Object Definitions
========================================================================================================
edit_csm_app_int_course_link           xpath               //a[contains(.,'CSM_App_Integrations')]/../..//a[@title='Edit Course']
user_menu_link                         xpath              //div[@id='nb_menu_overlay']//a[@class='user-menu-link tb_item']
course_settings_link                   xpath              //a[contains(text(),'Course Settings')]
course_settings_title                  xpath              //h2[@id='manageUsersTitle' AND contains(text(),'Course Settings')]
inst_ta_expand                         xpath              //span[text()='Instructor and TA Permissions']
teach_assist_expand                    xpath              //*[@id='capabilitiesDiv']//h4[text()='mt ta (Teaching Assistant)']
ta_capabilities_allchkboxes            xpath              //h4[contains(.,'Teaching Assistant')]/..//input
ta_manage_lpn_cap_chkbox               xpath              //h4[contains(.,'Teaching Assistant')]/..//label[contains(.,'Manage learning path')]/input
aplia_settings_btn                     xpath              //*[@id='btn_glob_asmt_settings_enabled']
cnow_appdock_icon                      xpath              //a[@id='app_selected_text']//img[contains(@src,'http://cnow.apps.preclass.ng.cengage.com/media/img/mindapps/cnowIconBigV2.png')]
cnow_popup_close_btn                   xpath              //button[contains(.,'close')]
cnow_assignments                       xpath              //h2[contains(.,'Assignments')]
add_activity_header                    xpath              //h1[contains(@id,'addActivity')]
web_video_link                         xpath              //h3[contains(@id,'WebVideoSearch')]
youtube_img                            xpath              //img[@id='init_altYouTubeVid']
cancel_btn                             xpath              //a[@data-i18n='create_cancel']
web_link                               xpath              //h3[contains(@id,'WebLinkActivity')]
enter_url_txt                          xpath              //span[contains(text(),'Enter URL')]
rss_app_link                           xpath              //h3[contains(@id,'RSSFeed')]
rssfeed_title_header                   xpath              //h3[@id='feed_title_header']/span
ysu_link                               xpath              //h3[@id='YouSeeU(QA-A)']
ysu_title_header                       xpath              //h1[@class='page-title' AND contains(.,'Select assignment')]
svr_link                               xpath              //h3[@id='SpeechVideoRepository']
svr_txt                                xpath              //span[@id='speech' AND contains(.,'Speech Video')]
questia_link                           xpath              //h3[@id='Questia']                                                                 
questia_project_txt                    xpath              //strong[contains(.,'Active pro')]
flashcards_link                        xpath              //h3[@id='Flashcards']


========================================================================================================
