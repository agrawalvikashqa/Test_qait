#Object Definitions
====================================================================================
title_flashcard                      xpath                //h2/span[@class='appActionFrame_actionLabel']
btn_createCard		             xpath               //input[@id='create-card']
text_keyTerm                         xpath              //input[@id='create_term_id']
text_definition                      xpath              //textarea[@id='create_def_id']
btn_save                             xpath             //button[@id='card-form-save']
link_flipCard                        xpath              //div[@class='viewer-card' and contains(@style,'block')]//a[@class='flipCardLink']
radio_btn_chapter                   xpath                  (//input[@type='radio' and contains(@title,'1')])[1]
btn_continue                         xpath                 //input[@class='addActivity cardlistejs_continue']
link_hideFlashCard                   xpath                 //a[@class='hideApp appActionFrame_closeAppHover']
newflashcard                         xpath               //div[@class='viewer-card'][contains(@style,'display: block')]//span[text()='${term}']
link_close                           xpath                 //a[@title='Close Activity']
card_deck                            xpath                 //input[@id='shuffle-deck']
edit_card                            xpath                   //div[@class='viewer-card' and contains(@style,'left: 0%')]//a[@class='editcustomcard']
delete_card                         xpath                   //button[@id='card-form-delete']
keyterm                             xpath                   //div[@class='viewer-card' and contains(@style,'left: 0%')]//div[@class='key-term']
card_count                          xpath                       //div[@class='viewer-card' and contains(@style,'block')]//div[@class='cardCount']//span[2]
link_hidecard                       xpath                       //div[contains(@style,'left: 0%;')]//a[@class='removecard']
txt_currentflashcard                xpath                      //div[contains(@style,'left: 0%;')]//span[@class='cardcount-count']
img_setting                         css                         img[alt='Settings']
btn_restore                         id                          restoreDeckId
btn_nextcard                        id                              next-card
btn_previouscard                    id                              previous-card
link_shuffledeck                    id                              shuffle-deck
dialog_print                        xpath                       //div[@aria-describedby='printdivid']
img_settings                        css                         img[alt='Settings']
link_restoreCard                    id                              restoreDeckId
btn_restoredeck                     id                              trash-restore
link_print                          id                              print-cards
btn_printclose                      xpath                        //div[contains(@class,'ui-dialog ui-widget') and contains(@style,'block')]//span[contains(.,'Close')]
  
====================================================================================