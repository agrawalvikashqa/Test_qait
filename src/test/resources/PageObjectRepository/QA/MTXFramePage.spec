
#Object Definitions
========================================================================================================
dockFrame                            xpath                     //iframe[contains(@id, '_NB_Dock_IFrame') and contains(@data-app-name, '${description}')]
nb_Main_Frame                        xpath                     //iframe[contains(@id, '_NB_Main_IFrame')]
ReaderEditIFrame                     xpath                     //iframe[contains(@id, 'easyXDM_activityService')]
getFrame_Content                     xpath                     //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'MindApp CXP App')]
getFrameContent                      xpath                     //*[contains(@id,'_NB_Dock_IFrame')]
dboard_frame                         xpath                     //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Discussion Board App')]
study_center_frame                   xpath                     //*[contains(@id,'_NB_Main_IFrame') and contains(@title,'Study Center App')]
dictionary_frame                     xpath                     //iframe[contains(@id, '_NB_Dock_IFrame') and contains(@data-app-name, 'Merriam-Webster Dictionary Lookup')]
distinct_Activity_Frame              id                         distinct_activity_create_frame      
========================================================================================================

