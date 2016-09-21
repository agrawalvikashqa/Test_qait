#Object Definitions
==================================================================================== 
addFeed_btn                  xpath                      //*[@id='initAppDock_rssFeedAddIcon']
feedUrl_TB                   xpath                      //*[@id='feed_url']
feedTitle_TB                 xpath                      //*[@id='feed_title']
save_btn                     xpath                      //input[@id='feed_save']
savelpn_btn                  xpath                      //*[@id='init_save']
lpn_act                      xpath                      //h3[@class='lpn_name']/a[contains(text(),'${description}')]
del_rss                      xpath                      //a[contains(text(),'${description}')]/../../..//img[contains(@src,'delete')]
inline_add                   xpath                      //*[@id='init_editModeHover']
plus_icon                    xpath                      (//a[contains(@class, 'addInline addControl_addHere')])[1]
inline_act                   xpath                      //*[@id='feedTitle']/strong[contains(text(),'${description}')]
inline_rmv                   xpath                      (//a[contains(@class, 'deleteInline deleteControl_remove')])[1]
appdock_RSS                  xpath                      //a[(contains(text(),'${description}'))]
AD_Delete                    xpath                      //a[contains(text(),'${description}')]//..//a[contains(@class, 'clui-delete')]
titlename                    xpath                      //a[contains(.,'${description}')]/parent::*
delete_btn                   xpath                      //*[@id='feed_yes_button']
====================================================================================
