package com.qait.automation.TestInitiator;

import com.cengage.mindtap.keywords.*;
import com.cengage.mtx.keywords.*;
import com.qait.automation.pojo.TopicNamePojo;
import com.qait.automation.utils.*;
import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;
import static com.qait.automation.utils.YamlReader.getData;
import static com.qait.automation.utils.YamlReader.getYamlValue;

//import static com.qait.mindtap.automation.utils.YamlReader.setYamlFilePath;


public class TestSessionInitiator {

    protected WebDriver driver;
    private final WebDriverFactory wdfactory;
    String browser;
    String seleniumserver;
    String seleniumserverhost;
    String appbaseurl;
    String applicationpath;
    String chromedriverpath;
    String datafileloc = "";
    static int timeout;
    Map<String, Object> chromeOptions = null;
    DesiredCapabilities capabilities;

    public AdminLoginPageActions adminLoginPage;
    public MasterPageActions masterPage;
    public SSOLoginPageActions ssoLoginPage;
    public InstructorLaunchPageActions instructorResourceCenterPage;
    public StudentMyHomePageActions studentMyHomePage;
    public DashBoardPageActions DashBoardPage;
    public MessageCenterPageActions MessageCenterPage;
    public ATPAppPageActions ATPAppPage;
    public FramesPageActions FramesPage;
    public WebLinkAppPageActions webLinkPage;
    public LPNPageActions lpnPage;
    public ReadingActivityPageAction readingPage;
    public searchPageAction searchPage;
    public merriamWebsterDictionaryPageAction merriamWebsterDictionaryPage; 
    public glossaryPageActions glossaryPage; 
    public fullBookPageActions fullBookPage;  
    public KalturaAppPageActions kalturaAppPage;  
    public youSeeUPageActions youSeeUPage;  
    public ReadSpeakerPageActions ReadSpeakerPage;
    public GoogleDriveAppPageActions GoogleDriveAppPage;
    public InsiteAppPageActions InsiteAppPage;
    public EvernotePageActions EvernoteAppPage;
    public SVRPageActions SVR;
    public QuestiaPageActions QuestiaPage; 
    public RssFeedPageActions RSSFeedPage;
    public MediaPageActions MediaPage;
    public FlashCardAppPageActions flashcardpage;
    public DateManagerPageActions DateManagerPage;
    public LearningLabsPageActions LearningLabsPage;
    public CSMPageActions CSMPage;
    public CSMAppIntPageActions CSMAppIntPage;
    public GradeBookAppPageAction gradebookpage;
    public GenericAppDockPageActions GenericAppDockPage;
    public StudyHubPageActions StudyHubAppPage; 
    public SpeechOutlineToolPageActions SpeechOutlineToolPage;
    public WebVideoPageAction webvideopage;
    public NonMindtapPageActions NonMindtapPage;
    public ALGAppPageActions ALGAppPage;
    public AssignableActivityPageActions AssignableActivityPage;
    public PrintPageActions printPage;
    public WeekWidgetPageActions weekwidgetPage;
    public NotificationCenterPageActions NotificationCenterPage;
    public MTXDashboardPageActions MTXDashBoardPage;
    public MTXFramesPageActions MTXFramePage;
    public MTXActivityPageAction MTXActivityPage;
    public MTXNarrativeActivityPageAction MTXNarrativePage;
    public MTXLensActivityPageActions MTXLensPage;
    public MTXMasteryActivityPageActions MTXMasteryActivityPage; 
    public MTXEssayLensActivityPageActions MTXEssayPage;
    public MTXMathReviewPageAction MTXMathReviewPage;
    public ChemistryReferencePageActions ChemistryReferencePage;
    public StudyGuideFlowPageActions StudyGuidePage;
    
   // public  StudentTakeDeletePageActions studentTakeDeletePage;

    public  StudentTakePageActions studentTakeDeletePage;
    public MTXIntroAndQuickPrepActivityPageAction MTXIntroAndQuickPrepPage;
    public MTXGradebookScoreVerificationPageAction MTXGradebookScorePage;
    public MTXQuizActivityPageAction MTXQuizActivityPage;
    public MTXConceptualTutoredPageAction MTXConceptualTutoredPage;
    public MTXIntroductionSystemSetUpPageAction MTXIntroductionActivityPage;
    public MTXChemistrySurveyPageAction MTXChemSurveyPage;
    public MTXSearchPageAction MTXSearchPage;

    public MTXStudyCenterPageAction MTXStudyCenterPage;
    public MTXAmGovtPollingApp MTXGovPolling;

    /**
     * Initiating the page objects
     */
    public TakeScreenshot takescreenshot;
    public TopicNamePojo topicNameValue;
    private final String testname;

    public Random randomGenerator;

    public WebDriver getDriver() {
        return this.driver;
    }

    private void _initPage() {
        topicNameValue = new TopicNamePojo();
        adminLoginPage = new AdminLoginPageActions(driver);
        ssoLoginPage = new SSOLoginPageActions(driver);
        DashBoardPage = new DashBoardPageActions(driver);
        MessageCenterPage = new MessageCenterPageActions(driver);
        ATPAppPage = new ATPAppPageActions(driver);
        FramesPage = new FramesPageActions(driver);
        masterPage = new MasterPageActions(driver);
        instructorResourceCenterPage = new InstructorLaunchPageActions(driver);
        studentMyHomePage = new StudentMyHomePageActions(driver);
        webLinkPage = new WebLinkAppPageActions(driver);
        lpnPage = new LPNPageActions((driver));
        readingPage = new ReadingActivityPageAction(driver);
        searchPage = new searchPageAction(driver);
        merriamWebsterDictionaryPage = new merriamWebsterDictionaryPageAction(driver);
        glossaryPage = new glossaryPageActions(driver);
        fullBookPage = new fullBookPageActions(driver);
        kalturaAppPage = new KalturaAppPageActions(driver);
        youSeeUPage = new youSeeUPageActions(driver);
        ReadSpeakerPage=new ReadSpeakerPageActions(driver);
        GoogleDriveAppPage = new GoogleDriveAppPageActions(driver);
        InsiteAppPage = new InsiteAppPageActions(driver);
        EvernoteAppPage = new EvernotePageActions(driver);
        SVR= new SVRPageActions(driver);
        RSSFeedPage = new RssFeedPageActions(driver);
        MediaPage = new MediaPageActions(driver);
        DateManagerPage = new DateManagerPageActions(driver);
        LearningLabsPage = new LearningLabsPageActions(driver);
        CSMPage = new CSMPageActions(driver);
        CSMAppIntPage = new CSMAppIntPageActions(driver);
        QuestiaPage = new QuestiaPageActions(driver);
        gradebookpage = new GradeBookAppPageAction(driver);
        flashcardpage = new FlashCardAppPageActions(driver);
        SpeechOutlineToolPage = new SpeechOutlineToolPageActions(driver);
        webvideopage = new WebVideoPageAction(driver);
        GenericAppDockPage = new GenericAppDockPageActions(driver);
        StudyHubAppPage = new StudyHubPageActions((driver));
        NonMindtapPage = new NonMindtapPageActions(driver);
        ALGAppPage = new ALGAppPageActions(driver);
        AssignableActivityPage = new AssignableActivityPageActions(driver);
        printPage = new PrintPageActions(driver);
        AssignableActivityPage = new AssignableActivityPageActions(driver);
        printPage = new PrintPageActions(driver);
        AssignableActivityPage = new AssignableActivityPageActions(driver);
        printPage = new PrintPageActions(driver);
        weekwidgetPage = new WeekWidgetPageActions(driver);
        NotificationCenterPage =new NotificationCenterPageActions(driver);
        MTXDashBoardPage =new MTXDashboardPageActions(driver);
        MTXFramePage =new MTXFramesPageActions(driver);
        MTXActivityPage =new MTXActivityPageAction(driver);
        studentTakeDeletePage = new StudentTakePageActions(driver);
        MTXNarrativePage = new MTXNarrativeActivityPageAction(driver);
        MTXLensPage = new MTXLensActivityPageActions(driver);
        studentTakeDeletePage = new StudentTakePageActions(driver);
        MTXIntroAndQuickPrepPage = new MTXIntroAndQuickPrepActivityPageAction(driver);
        MTXEssayPage = new MTXEssayLensActivityPageActions(driver);
        MTXMathReviewPage = new MTXMathReviewPageAction(driver);
        MTXMasteryActivityPage = new MTXMasteryActivityPageActions(driver);
        MTXGradebookScorePage = new MTXGradebookScoreVerificationPageAction(driver);
        MTXQuizActivityPage = new MTXQuizActivityPageAction(driver);
        MTXConceptualTutoredPage = new MTXConceptualTutoredPageAction(driver);
        MTXIntroductionActivityPage = new MTXIntroductionSystemSetUpPageAction(driver);
        MTXChemSurveyPage = new MTXChemistrySurveyPageAction(driver);
        MTXSearchPage = new MTXSearchPageAction(driver);

        MTXStudyCenterPage =new MTXStudyCenterPageAction(driver);
        StudyGuidePage = new StudyGuideFlowPageActions(driver);
        ChemistryReferencePage = new ChemistryReferencePageActions(driver);
        MTXGovPolling = new MTXAmGovtPollingApp(driver);

    }

    /**
     * Page object Initiation done
     *
     * @param testname
     */
    public TestSessionInitiator(String testname) {
        wdfactory = new WebDriverFactory();
        testInitiator(testname);
        this.testname = testname;
        getSystemIPAddress();
    }
  
        
    public TestSessionInitiator(String testname, String browserName) {
        wdfactory = new WebDriverFactory(browserName);
        testInitiator(testname);
        this.testname = testname;

    }
    
    
    public void getSystemIPAddress() {
        // TODO code application logic here
        
        try {
           InetAddress IP = InetAddress.getLocalHost();
           System.out.println(IP.toString());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

    }

    private void testInitiator(String testname) {
        YamlReader.setYamlFilePath();
        _configureBrowser();
        _initPage();
        takescreenshot = new TakeScreenshot(testname, this.driver);
    }

    private void _configureBrowser() {
        driver = wdfactory.getDriver(_getSessionConfig());
        if (!_getSessionConfig().get("browser").toLowerCase().trim().equalsIgnoreCase("mobile")) {
            driver.manage().window().maximize();
        }
        driver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(getProperty("timeout")),
                        TimeUnit.SECONDS);
    }

    private Map<String, String> _getSessionConfig() {
        String[] configKeys = {"tier", "browser", "seleniumserver",
            "seleniumserverhost", "timeout", "driverpath", "appiumServer",
            "mobileDevice"};
        Map<String, String> config = new HashMap<String,String>();
        for (String string : configKeys) {
            config.put(string, getProperty("./Config.properties", string));
        }

        return config;
    }

    public void launchApplication() {
        launchApplication(getYamlValue("base_url"));
        String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println("Current OS Browser configuration:" + uAgent);
        
        
        
    }

    public void launchApplication(String base_url) {
        ReportMsg.info(" The application url is :- " + base_url);
        String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println("Current OS Browser configuration:" + uAgent);
        driver.manage().deleteAllCookies();
        driver.get(base_url);
    }
    
  
    

    public void openUrl(String url) {
        System.out.println("Aplication URl: "+url);
        driver.get(url);
    }

    public void closeBrowserSession() {
        ReportMsg.info("The Test: " + this.testname.toUpperCase() + " COMPLETED!" + "\n");
        try {
            driver.quit();
        } catch (Exception b) {
            b.getMessage();
        }
    }

    public void closeTestSession() {
        closeBrowserSession();
    }

    public void GoogleDriveAppPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void launchApplication(String username, String userPassword,String CourseKey,String ISBN) {
       System.out.println("******************* Test Data ****************");
       System.out.println("Login ID:- "+username );
       System.out.println("Login Password:- "+userPassword );
       System.out.println("Course Key :- "+CourseKey );
       System.out.println("Book ISBN:- "+ISBN );

        System.out.println("*********************************************");

        System.out.println("**********************************************");

        try {
            String ssoToken = getSSOToken(username, userPassword);
            String destinationURL = buildLaunchUrl(ssoToken,CourseKey,ISBN);
            openUrl(destinationURL);
            PropFileHandler.writeProperty("buildURL", destinationURL);
        } catch (JSONException e) {
            Reporter.log("[ERROR]: Could not log in to application, trouble authenticating: " + e.toString(), true);
        }
    }
    
     private String getSSOToken(String username, String password) throws JSONException {
        Object postBody = ("{\"uid\":\"" + username + "\", \"password\":\"" + password + "\"}");
        HttpClient httpclient = new HttpClient();
        ClientResponse response = httpclient.postHttpResponse(getData("SSO_TOKEN_URL"), postBody);
        String entity = response.getEntity(String.class);
        return new JSONObject(entity).getString("token");
    }

    private String buildLaunchUrl(String ssoToken, String CourseKey, String ISBN) {
        StringBuilder sb = new StringBuilder();
        sb.append(getData("PRODUCT_URL"));
        sb.append("?token=");
        sb.append(ssoToken);
        sb.append("&courseKey=");
        sb.append(CourseKey);
        sb.append("&eISBN=");
        sb.append(ISBN);
        return sb.toString();
    }

 

}
