//import io.appium.java_client.MobileElement;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import static io.appium.java_client.touch.offset.PointOption.point;
//
//public class SocraticAudio {
//
//    private AndroidDriver driver;
//    String test_cases_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/test_cases.csv";
//    String img_folder_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/images";
//    String output_file_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/output.csv"; //Auto create file if not there
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appium:platformVersion", "13");
//        desiredCapabilities.setCapability("appium:deviceName", "Pixel 4");
//        desiredCapabilities.setCapability("appium:appPackage", "com.google.socratic");
//        desiredCapabilities.setCapability("appium:appActivity", "com.google.android.apps.education.bloom.app.home.HomeActivity");
//        desiredCapabilities.setCapability("appium:noReset", true);
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//    }
//
//
//    @Test
//    public void SocraticAudio() throws InterruptedException {
//
//
//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Take a picture of a question");
//        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Speak a question");
//        el2.click();
//
//
//            MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Start/Stop the voice query");
//            el3.click();
//            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//
//            // Code to play the audio file for this loop.
//            // Note that this plays the audio from your computer's speakers
//            try {
//                FileInputStream audio;
//                audio = new FileInputStream(
//                        new File("/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/audio.mp3"));
//                BufferedInputStream buffer = new BufferedInputStream(audio);
//                Player player = new Player(buffer);
//                player.play();
//            } catch (FileNotFoundException | JavaLayerException e) {
//
//                e.printStackTrace();
//            }
//
//            // If Socratic doesn't auto complete, then manually enter the 'stop' button
////            el1 = (MobileElement) driver.findElementByAccessibilityId("Start/Stop the voice query");
////            try {
////                if (el1 != null && el1.isDisplayed())
////                    el1.click();
////            } catch (NoSuchElementException e) {
////            }
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//            // Get the text from the output element
////            MobileElement el4 = (MobileElement) driver.findElementById("com.google.socratic:id/query_text");
////            Thread.sleep(5000);
//
//            // Compare our expected outputs with the actual output
////            if(outputs[i].toLowerCase().contains(el2.getText().toLowerCase()) ||
////                    el2.getText().toLowerCase().contains(outputs[i].toLowerCase()) ||
////                    el2.getText().toLowerCase().equals(outputs[i])) {
////                System.out.println("PASS:" + " Audio" + (i+1));
////            }
////            // If the outputs don't match, then the test case fails
////            else {
////                System.out.println("FAIL: " + " Audio" + (i+1));
////            }
//            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//            Thread.sleep(2000);
//
//            // Go back to the speaker starting position for the next test in the loop
////            MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
////            el5.click();
////            Thread.sleep(2000);
//    }
//}
