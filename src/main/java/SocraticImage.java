import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.apache.commons.lang3.text.WordUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SocraticImage {

    private AndroidDriver driver;
    String test_cases_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/test_cases.csv";
    String img_folder_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/images";
    String output_file_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/output.csv"; //Auto create file if not there

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "13");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 4");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.socratic");
        desiredCapabilities.setCapability("appium:appActivity", "com.google.android.apps.education.bloom.app.home.HomeActivity");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }



    @Test
    public void sampleTest() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Take a picture of a question");
        el1.click();


//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        Boolean FirstFlag = true;
//        int counter = 0;
//
////Initialize output file in image directory
//        try (FileWriter outputFile = new FileWriter(output_file_csv_dir, true);
//             BufferedWriter bw = new BufferedWriter(outputFile);
//             PrintWriter output = new PrintWriter(bw)){
//            //Init reading test_cases.csv
//            File myObj = new File(test_cases_csv_dir);
//            Scanner myReader = new Scanner(myObj);
//            System.out.println("Created Output File at "+output_file_csv_dir);
//
//
//
//            looping: for (int i = 1; i<=20;i++) {
//                counter = i;
//                if (i>0 && i<=19) {
////                    String[] test_case_data = myReader.nextLine().split(",");
//                    String fileName = counter +".jpeg";
//
//
//                    //Remove all files in device/download
//                    if (FirstFlag) {
//                        try {
//                            driver.pushFile("/sdcard/download/"+fileName, new File(img_folder_dir+fileName));
//                            List<String> lsArgs = Arrays.asList("/sdcard/download/*.*");
//                            Map<String, Object> lsCmd = ImmutableMap.of("command", "rm", "args", lsArgs);
//                            driver.executeScript("mobile: shell", lsCmd);
//                            System.out.println("Cleared Downloads");
//                            FirstFlag = false;
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    else {
//                        List<String> lsArgs = Arrays.asList("/sdcard/download/*.*");
//                        Map<String, Object> lsCmd = ImmutableMap.of("command", "rm", "args", lsArgs);
//                        driver.executeScript("mobile: shell", lsCmd);
//                        System.out.println("Cleared Downloads");
//                    }
//                    driver.pushFile("/sdcard/download/"+fileName, new File(img_folder_dir+fileName));


////////////////////////////
////////Change from here to your app's sequences
////////////////////////////

                    //Wait for loading and click on gallery
//                    wait.until(ExpectedConditions.elementToBeClickable(By.id("com.fws.plantsnap2:id/btn_choose")))
//                            .click();
//                    //click image
//                    MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.documentsui:id/icon_thumb");
//                    el2.click();
//                    //done cropping
//                    MobileElement el3 = (MobileElement) driver.findElementById("com.fws.plantsnap2:id/crop_image_menu_crop");
//                    el3.click();


                    //Read result and extract content
//                    String content = "N/A";
//                    Thread.sleep(6000);
//                    MobileElement ele = driver.findElementById("com.fws.plantsnap2:id/primary_result_common_name");
//                    content = ele.getAttribute("text");
//                    try {
//                        ele = driver.findElementById("com.fws.plantsnap2:id/primary_result_species_name");
//                        content = ele.getAttribute("text");
//                    }
//                    catch (NoSuchElementException e) {
//                        System.out.println("No result");
//                    }
//                    finally {
//                        //output to csv
//                        String output_string = "";
//                        for (String str : test_case_data) {
//                            output_string = output_string + str + ",";
//                        }
//                        output_string = output_string + WordUtils.capitalize(content) + ",";
//                        if (WordUtils.capitalize(content).trim().contains(test_case_data[7])) output_string = output_string + "Success";
//                        else output_string = output_string + "Fail";
//                        System.out.println(output_string);
//                        output.println(output_string);
//
//                        //close ads and Back to app's homepage
//                        driver.navigate().back();
//                        Thread.sleep(1000);
//                        new TouchAction(driver).tap(PointOption.point(976, 275)).perform();
//                        Thread.sleep(1000);
//                        continue looping;
//                    }

////////////////////////////
////////Change ends here of your app sequence
////////////////////////////


//                }
//                else {
//                    if (i==0) {}//output.println(myReader.nextLine());
//                    else myReader.nextLine();
//                }
//            }
//
//            myReader.close();
//            output.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }



        //com.google.socratic:id/try_example_button
        //com.google.socratic:id/image_view
        //Crop a question, select just one question
        ////android.widget.ImageView[@content-desc="Crop a question, select just one question"]
        //com.google.socratic:id/accept_button





//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Take a picture of a question");
//        el1.click();
//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Speak a question");
//        el1.click();
//
//        for (int i = 0; i < 9; i++) {
//            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Start/Stop the voice query");
//            el1.click();
//            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//
//            // Code to play the audio file for this loop.
//            // Note that this plays the audio from your computer's speakers
//            try {
//                FileInputStream audio;
//                if (i == 0)
//                    audio = new FileInputStream(
//                            new File("/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/audio.mp3"));
//                else
//                    audio = new FileInputStream(
//                            new File("/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/audio.mp3"));
//                BufferedInputStream buffer = new BufferedInputStream(audio);
//                MediaPlayer player = MediaPlayer.create(audio);
//
//                player.play();
//            } catch (FileNotFoundException | JavaLayerException e) {
//
//                e.printStackTrace();
//            }
//
//            // If Socratic doesn't auto complete, then manually enter the 'stop' button
//            el1 = (MobileElement) driver.findElementByAccessibilityId("Start/Stop the voice query");
//            try {
//                if (el1 != null && el1.isDisplayed())
//                    el1.click();
//            } catch (NoSuchElementException e) {
//            }
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//            // Get the text from the output element
//            MobileElement el3 = (MobileElement) driver.findElementById("com.google.socratic:id/query_text");
//            Thread.sleep(5000);
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
//            MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
//            el3.click();
//            Thread.sleep(2000);
//        }
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}

