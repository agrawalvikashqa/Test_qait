#Object Definitions
====================================================================================
unitName_link                        xpath           //a[contains(.,'${unitName}')]
chapterName_link                     xpath           //a[contains(.,'${chapterName}')]
chapterContent_link                  xpath           //div[contains(@class,'readerToolbar')]//a[@id='chapterTitle']
chapterIntroductionPage_link         xpath           //a[contains(text(),'Chapter Introduction')]
editMode_link                        xpath           //a[@id='init_editModeHover' and @title='Edit mode']
addIcon_link                         xpath           (//div[@id='ebook_document']//a[contains(@class,'addInline')])[1]
editInlineActivity                   xpath           (//a[@title='Edit'])[1]   
addedActivity_link                   xpath           //a[@href='${anotherWebURL}']
ReadSpeaker_btn                      id              readspeaker_doc_controls
chapterHeadingText                   xpath           //div[@id='ebook_document']//div[@id='header']//h1
printbtn                             xpath           //*[@alt='Print']
printPreviewHeadingText              xpath           //div[@id='print_preview']//div[@id='header']//h1
selectSmallText                      xpath           //*[@id='init_selectSmallText']      
selectMediumText                     xpath           //*[@id='init_selectMediumText']
selectLargeText                      xpath           //*[@id='init_selectLargeText']
bodyFont                             xpath           //body[@class='${fontLarge}']
deleteInline                         xpath           (//a[@title='Remove'])[1]
nextLink                             id               next1
CloseLink                            id               app_activity_frame_closeActivity
deleteIcon_link                      xpath           (.//a[@class='deleteInline deleteControl_remove'])[position()=1]
chapterTitle                         xpath            //h1
skimmerDisplay                       xpath            //ul[@class='skimlist']
verify_nextPageNavigated             xpath            .//*[@id='RIAYPP013672168']/span
tocTitle                             xpath            (//a[@data-link-type='toc'])[2]
toc_titleOnPage                      xpath            .//*[@id='WLOOFH189926437']/span[2]
skimmerNavigate                      xpath             //ul[@class='skimlist']/li[3]
activityTitle                        xpath             (//a[@class='chapterSelect'])[2]
fullChapterSelection                 xpath             //input[@id='FULL' and @type='checkbox']
continue_btn                         xpath             //a[text()='Continue']
textBox_heading                     id                 heading
textbox_sav_btn                     id                 init_save
hyperlink                           xpath              //span[text()='Insert/Edit Link']
linkBox                             id                 href
linkTitle                           id                 linktitle
linkInsert                          id                 insert
linkedText                          xpath              //a[@title='Google']
InlineEditIcon                      xpath              (//a[@class='editInlineActivity edit_editHover'])[1]
modelOptionsEditFrame               xpath              (//iframe[@id='modelOptionsEditFrame'])[2]
studentTextbox_verify               xpath               //h4[1]
openedActivity_chapterTitle         xpath               //span[@class='headingText' and text()=' How People Make Decisions ']
modelOptionsEditFrame1              xpath               //iframe[@id='modelOptionsEditFrame' and not(@style='display: none;')]
cnnlogo                             xpath               //a[@id='logo']
Print_sectionRadioButton            xpath               //input[@value='Section']
Print_chapterRadioButton            xpath               //input[@value='Chapter']
entire_ChapterContent               xpath               //div[@id='chapterOutline']
fullBook_ImageVerify                xpath               //div[@id='fm_cvr1']
====================================================================================



