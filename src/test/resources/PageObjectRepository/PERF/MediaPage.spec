#Object Definitions
==================================================================================== 
uncheck_sso                 xpath                      //*[@id='filterByIsbn']
media_type                  xpath                      //*[@id='filterbymediatype']
img_media                   xpath                      //tr[contains(@class, 'asset media_models_asset')][1]
img_type                    xpath                      //*[@id='init_image']
bfr_txt                     xpath                      //*[@id='beforeText']
afr_txt                     xpath                      //*[@id='afterText']
continue_btn                xpath                      //input[contains(@class, 'save media_continue')]
title_txt                   xpath                      //*[@id='name']
save_btn                    xpath                      //*[@id='init_save']
lpn_act                     xpath                      //h3[@class='lpn_name']/a[contains(text(),'${description}')]
del_media                   xpath                      //a[contains(text(),'${description}')]/../../..//img[contains(@src,'delete')]
edit_media                  xpath                      //a[contains(text(),'${description}')]/../../..//img[contains(@src,'edit')]
save_changes                xpath                      //input[contains(@class, 'save')]
search_txt                  xpath                      //input[contains(@class, 'search ui_search')]
search_result               xpath                      //div[contains(text(), 'AAMMAS958585318')]
search_count                xpath                      //div[contains(text(), 'Showing 1-1 of 1')]
next_btn                    xpath                      //a[contains(@class, 'next next_gridinit')]
next_search                 xpath                      //div[contains(text(), 'Showing 11-20')]
previous_btn                xpath                      //a[contains(@class, 'prev prev_gridinit')]
previous_search             xpath                      //div[contains(text(), 'Showing 1-10')]
search_icon                  css                      .searchicon
filterByIsbn                 id                        filterByIsbn
unit_lpn                    xpath                      //h3[@class='lpn_name group']/a[contains(text(),'${description}')]
reader_inline               xpath                      //span[@class='moduleLabel']/a[contains(text(),'${description}')]
plus_icon                    xpath                     (//div[contains(@style,'block')]//a[contains(@class,'addControl_addHere')])[1]
inline_add                   xpath                      //*[@id='init_editModeHover']
inline_verify               xpath                       //div[contains(@class,'mediaDescription')]//em[contains(text(),'Fed Chairman')]
inline_rmv                  xpath                       (//a[contains(@class, 'deleteInline deleteControl_remove')])[1]
====================================================================================

