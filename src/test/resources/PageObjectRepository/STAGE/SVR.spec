#Object Definitions
====================================================================================
outlineBuilder_icon                                         xpath                              //img[contains(@src,'svr')]
categoryHeader                                              xpath                              //span[@class='appActionFrame_actionLabel']
more_link                                                   xpath                              //a[@title='Expand Dock']
search_Box                                                  id                                  search_text
radio_Btn                                                   xpath                              //input[@type='radio']
continue_Btn                                                xpath                              //div[@id='search-activity-page']//input[@value='Continue']
create_Btn                                                  xpath                              //input[@value='Create']
title_VerifyText                                            xpath                              //span[@class='resultText']/a 
paragraph_VerifyText                                        xpath                              (//span[@class='resultText']/span[contains(@class,'videoDescription')])[1]
save_btn                                                    css                                #init_save
unitTitle                                                   id                                 name
closePreview                                                xpath                              //a[@class='closePreview']
title_inputField                                            xpath                              //input[contains(@class,'required validates')]
ddl_orderButton                                             xpath                              //a[@id='order-button']/span[@class='ui-selectmenu-status']
description_inputField                                      id                                 description
inputTitle                                                  xpath                              //input[@id='name']
inputDesc                                                   xpath                              //textarea[@id='description']
edit_Btn                                                    xpath                              //input[@class='editOptions']
continueFromEdit                                            xpath                              //input[@value='Continue']
submitBtn                                                   id                                 submit
save_Btn                                                    xpath                              //button[contains(@class,'btn-success') and contains(.,'Save')]
addAcomment                                                 xpath                              //div[contains(@class,'modal-comment')]/a
commentArea                                                 xpath                              //textarea[contains(@class,'comment-input')]
commentArea                                                 xpath                              //textarea[contains(@class,'comment-input')]
postCommentButton                                           xpath                              //div[@class='control']/button[contains(@class,'btn-primary')]
editPoints                                                  xpath                              //button[contains(.,'Edit Score')]
viewBtn                                                     xpath                              //button[contains(.,'View')]
closeActivity_btn                                           className                           closeActivity
StudentName                                                 xpath                              //div[contains(@class,'ag-cell-value') and contains(.,'${StudentName}')]
gradeBookAppIcon                                            xpath                              //img[@alt='Progress' or @title='Progress']
reviewActivity                                              xpath                              //span[contains(@class,'ag-cell-value') and contains(.,'${title}')]

====================================================================================