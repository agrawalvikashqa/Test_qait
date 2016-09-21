#Object Definitions
==================================================================================== 
PrintButton             xpath                //*[@id='print_doc_controls']/a/img
ChaptersButton          xpath                //*[@id='scrollbox']/a[contains(text(),'Chapters')]
fontSizeLargeButton     xpath               //*[@id='fontSizer']/a[contains(@class,'fontSizeLarge')]
fontSizeMediumButton    xpath               //*[@id='fontSizer']/a[contains(@class,'fontSizeMedium')]
fontSizeSmallButton     xpath              //*[@id='fontSizer']/a[contains(@class,'fontSizeSmall')]
skimbar                 xpath              //div[@class='skimbar']
NextButton              xpath               //img[@id='next1']
BackButton              id                      back1
ChapterLinks            xpath             //*[@id='nb_modalLayer']//a[contains(@class,'CHAPTER')]
CloseChapterButton      xpath              //*[@id='nb_modalLayer']//a[@title='Close']
ChapterHeading          xpath              //*[@id='header']//h1[text()='${nameheading}']/parent::div//*[@class='chapNum']
MediaCreditText         xpath              //*[@class='mediaCredit']
fontSizeLargeSelected   xpath              //*[@class='fontSizeLarge fontSelected']
fontSizeMediumSelected  xpath              //*[@class='fontSizeMedium fontSelected']
fontSizeSmallSelected   xpath              //*[@class='fontSizeSmall fontSelected']
title_fullbook          xpath              //div[@id="21_NB_App_DockItem"]/div/h2/span
help_icon_fullbook      xpath              //a[@id='help']
PrintPreview            xpath              (//*[text()='Print Preview'])[2]
HelpButton              xpath              (//*[@id='help'])[1]
CloseAppButton          xpath              (//a[contains(@class,'closeAppHover')])[2]
CloseHelp               xpath              //*[@class='close mxui_layout_positionable']
====================================================================================