#Object Definitions
==================================================================================== 
ReadSpeakerapp                 xpath         //*[@id='app_player_setting']/img
speaker_speed_Dropdown         xpath         //*[@id='userprefdivid']/div/div[2]/select
init_mediumSpeed_option        xpath         //*[@id='init_mediumSpeed']
speaker_voice_Dropdown         xpath         //*[@id='userprefdivid']/div/div[3]/select
init_maleVoice_option          xpath         //*[@id='init_maleVoice']
ReadSpeedSelectedValue         xpath         //*[@id='userprefdivid']/div/div[2]/select/option[@selected]
VoiceSelectValue               xpath         //*[@id='userprefdivid']/div/div[3]/select/option[@selected]
speaker_speed_select           xpath         //select[@class='speaker_speed_select']/option[text()='${val}']
speaker_voice_select           xpath         //*[@id='userprefdivid']/div/div[3]/select/option[text()='${val}']
====================================================================================