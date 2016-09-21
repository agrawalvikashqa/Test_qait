pagetitle: Manage Masters

#Object Definitions
====================================================================================
logout_link                         css                     #logout_link
admin_btn                           css                     .adminButtons
masterBookName_txt                  id                      nb.name
masterLPName_txt                    id                      nb.lp.name
masterDescription_txt               id                      description
coreTextISBN_txt                    id                      componentISBN
courseMode_Btn                      id                      isReaderOnly1
saveMaster_Btn                      linktext                Save
masterBookTitle_link                linktext                ${bookTitle}
masters_link                        id                      masters_link
bookList_container                  css                     .listContainer
bookSearch_inputBox                 css                     #searchField
unpublished_btn                     css                     img[alt='Not Published']
modeValue_btn                       xpath                   //div[@class='filterToggle admin_filter']/a/img[contains(@alt,'${mode}')]
modeValueActivated_btn              xpath                   //div[@class='filterToggle admin_filter']/a[@class='on']/img[contains(@alt,'${mode}')]
searchBookResults_list              classname               title
masterBook_list                     xpath                   //li[contains(@class, 'item  master admin_models_master')]
masterBookControlOptions_list       xpath                   //img[@alt='${option}']
addProvision_btn                    xpath                   //div[@class='title' and contains(text(),'${appRegistryOption1}')]/../..//img[contains(@src,'addProvision')]
MasterTab                           id                      masters_link
OrganistationTab                    id                      orgs_link
AppLibararyTab                      id                      apps_link
SettingTab                          id                      settings_link
neXtBookSearch_inputBox             css                     #searchField
neXtBookSearchInputBoxActivated     xpath                   //input[@id='searchField']
notPublished_btn                    css                     img[alt='Not Published']
Organisation_SearchField            id                      searchFieldOrg
DeployAppButton                     xpath                   //*[@class='deployApp']
categoriesAppButton                 xpath                   //*[@class='categories']
defstyle                            id                      defstyle
masstyle                            id                      masstyle
mindtap                             id                      mindtap 
knewton                             id                      knewton
companyInfo                         id                      companyInfo
productInfo                         id                      productInfo
manageAnnouncementsLink             id                      manageAnnouncementsLink
org_btn                             xpath                   //*[@id='orgs_link']
search_txt                          xpath                   //*[@id='searchFieldOrg']
course_org                          xpath                   //a[contains(@class, 'orgtitle title searchHighlightable')]
course_name                         xpath                   //a[contains(@class, 'coursetitle searchHighlightable title')]
course_admin                        xpath                   //a[contains(@class, 'selectSnapshot title')]
org_link                            xpath                   //a[contains(@class, 'coursetitle searchHighlightable title')]
impersonateUser                     xpath                   (//a[@class='impersonateUser' and text()='${User}'])[1]
go-to-course_btn                    id                      go-to-course
statusOption_list                   css                     a[class$='clui-status']
statusVerify_cover                  xpath                   (.//*[contains(@id,'status_table_body')])[1]/tr[1]/td[1]/img[contains(@src,'prog_done')]
statusVerify_Reader                 xpath                   (.//*[contains(@id,'status_table_body')])[1]/tr[2]/td[1]/img[contains(@src,'prog_done')]
statusVerify_Media                  xpath                   (.//*[contains(@id,'status_table_body')])[1]/tr[3]/td[1]/img[contains(@src,'prog_done')]
statusVerify_Metadata               xpath                   (.//*[contains(@id,'status_table_body')])[1]/tr[4]/td[1]/img[contains(@src,'prog_done')]
=================================================================================
