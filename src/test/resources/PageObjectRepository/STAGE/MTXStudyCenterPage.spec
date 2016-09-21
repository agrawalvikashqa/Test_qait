#Object Definitions
========================================================================================================
quizMe_txt                              xpath                  //h3[contains(text(), 'QuizMe')]
studyGuide_txt                          xpath                  //h3[contains(text(), 'Study Guides')]
performance_txt                         xpath                  //h3[contains(text(), 'Performance by Unit and Concept')]
helpOverlay_btn                         xpath                  //button[@ng-click='showOverlay()' and contains(text(), '?')]
helpOverlay_content                     xpath                  //div[@id='help_overlay']//div[@class='helpInner']//h3[contains(text(), 'Practice')]
closeHelpOverlay                        xpath                  //div[@id='underlay']
createQuiz_btn                          xpath                  //h3[contains(text(), 'QuizMe')]/..//button[contains(text(), 'Create a New Quiz')]
quizTitle_section                       xpath                  //h4[contains(text(), 'Quiz Title')]
dateCreated_section                     xpath                  //h4[contains(text(), 'Date Created')]
quizUnit                                xpath                  (//div[@class='form-group']//label//input)[1]
questionNumbers                         xpath                  //input[@id='numberOfQuestions']
moreQuestions_txt                       xpath                  //span[@id='hint']
maxQuestions_txt                        xpath                  //span[@id='hint']
takeQuiz_btn                            xpath                  //button[contains(text(), 'Take the Quiz')]
finishBtn                               xpath                  //button[@ng-click='finishQuiz()']
countOfQuestions                        xpath                  //div[contains(text(), 'Question')]
quizTitle_head                          xpath                  //label[@for='quizName']
quizTitle_txt                           xpath                  //div[contains(@class, 'navbar-brand ng-binding')]
saveForLater_txt                        xpath                  //button[@ng-click='closeQuiz()']
submitAnswer                            xpath                  //div[@class='button submit-button enabled']
quizInProgress_icon                     xpath                  //div[contains(@class, 'quizicon-inprogress')]
openQuiz                                xpath                  //p[@class='inside']//a[contains(@ng-click,'quizResults')]
retakeBtn                               xpath                  //button[contains(@ng-click, 'retake')]
closeQuizBtn                            xpath                  //button[contains(@ng-click, 'goBack')]
questionResults                         xpath                  //div[@class='panel-title']
collapseForm                            xpath                  (//i[@class='fa fa-plus'])[1]
expand_click                            xpath                  (//div[@class='ng-scope'])[2]
expandedForm                            xpath                  (//i[@class='fa fa-minus'])[1]
quizSocre                               xpath                  //span[@class='score-text ng-binding']
quizSubmitted_icon                      xpath                  //div[@class= 'quizicon-completed']
deleteQuiz                              xpath                  //span[contains(@ng-click, 'deleteQuiz')]
studyGuideCreate                        xpath                  //button[contains(@ng-click, 'createStudyGuide')]
unitStudyGuide                          xpath                  (//p//a[contains(@ui-sref, 'unitStudyGuides')])[1]
keyConcepts                             xpath                  //h2[contains(text(), 'Key Concepts')]
keyTerms_txt                            xpath                  //h2[contains(text(), 'Key Terms')]
keyTerms_hisTxt                         xpath                  //h3[contains(text(), 'Key Terms')]
keyEquations_txt                        xpath                  //h2[contains(text(), 'Key Equations')]
timeline_txt                            xpath                  //section[@class='contentitem']//.[contains(text(), 'Timeline')]
topic_txt                               xpath                  //section[@class='contentitem']//h3[contains(text(), 'Topics')]
keyTerms_His                            xpath                  //section[@class='contentitem']//h3[contains(text(), 'Key Terms')]
closeStudyGuide                         xpath                  //span[contains(@ng-click, 'dismiss')]
keyEquations_chkBox                     xpath                  //label[contains(text(), 'Key Equations')]/..//input
studyGuideName                          xpath                  //input[@id='studyGuideName']
saveStudyGuide                          xpath                  //button[contains(@ng-click, 'save')]
userStudyGuide                          xpath                  (//p[@class='inside'])[last()]
deleteStudyGuide                        xpath                  //span[contains(@ng-click, 'delete')]
keyConcepts_chkBox                      xpath                  //label[contains(text(), 'Key Concepts')]/..//input
keyTerms_chkBox                         xpath                  //label[contains(text(), 'Key Terms')]/..//input
flashcard_chkbox                        xpath                  //label[contains(text(), 'User Created Flashcards')]/..//input
highlights_chkbox                       xpath                  //label[contains(text(), 'User Highlights')]/..//input
notes_chkBox                            xpath                  //label[contains(text(), 'User Notes')]/..//input
flashacrd_txt                           xpath                  //h4[contains(text(), 'Flashcards')]
highlights_txt                          xpath                  //h4[contains(text(), 'Highlights')]
notes_txt                               xpath                  //h4[contains(text(), 'Quick Notes')]
print_icon                              xpath                  //span[contains(@ui-sref, 'print')]
unitGuide_tab                           xpath                  //span//a[contains(@ui-sref, 'unitStudyGuides')]
back_btn                                xpath                  //button[contains(@ng-click, 'back')]
cancelPrint                             xpath                  (//button[@class='cancel'])[1]
conceptActivity                         xpath                  (//span[contains(@ng-bind-html, 'concept.label')])[1]
practiceActivity                        xpath                  (//span[@class='btn btn-info' and contains(@ng-click, 'launchActivity')])[1]
activityTitle                           xpath                  (//h4[contains(text(), 'Activity Title')])[last()]
scoreInConcept                          xpath                  (//div[contains(@class, 'score-details')])[last()]
startPracticeActivity                   xpath                  //div[@id='rhs-start']
activityFrame                           xpath                  //iframe[contains(@ng-src, 'activityPractice')]
timeline_chkBox                         xpath                  //label[contains(text(), 'Timeline')]/..//input
topics_chkBox                           xpath                  //label[contains(text(), 'Topics')]/..//input
conceptMinus_icon                       xpath                  //i[contains(@class, 'minus')]
========================================================================================================
