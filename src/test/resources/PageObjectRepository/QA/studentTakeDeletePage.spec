#Object Definitions
========================================================================================================
link_student                               xpath                   //div[@data-e2e-class='StudentName' and contains(., '${studentname}')]
allActivities                              xpath                   //div[contains(@class, 'ag-row-level-1')]//div[contains(@class, 'score') and contains(text(), '%')]
Score_activity                             xpath                   (//div[contains(@class, 'ag-row-level-1')]//div[contains(@class, 'score') and contains(text(), '%')])[1]
delete_btn                                 xpath                   //button[contains(text(), 'Delete')]
ConfirmDeletion                            xpath                   //button[contains(text(), 'Confirm')]
Cancelbtn                                  xpath                   //button[contains(@class, 'close')]
firstActivity                              xpath                   (//div[contains(@class, 'ag-row-level-0')])[1]
scoreVerification                          xpath                   //span[text()='${description}']/../../../..//div[@colid='score']
recordedScore                              xpath                   //strong[text()='Recorded Score']/../..//strong[contains(@ng-bind-html, 'getPercentageScoreToString')]
possibleScore_Gradebook                    xpath                   //strong[contains(@ng-bind-html, 'getTotalPointsPossibleAsString')]
========================================================================================================

