import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SampleTest {

    private AndroidDriver<AndroidElement> driver;
    double pass_rate = 0.0;
    private ArrayList<String[]> elems = new ArrayList<String[]>();
    String test_cases_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/test_cases.csv";
    String img_folder_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/images";
    String output_file_csv_dir = "/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/output.csv"; //Auto create file if not there

    @Before
    public void setUp() throws MalformedURLException, FileNotFoundException {
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
        desiredCapabilities.setCapability("autoDismissAlerts", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        Scanner scanner = new Scanner(new File("/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/answer_elements.txt"));

        while (scanner.hasNextLine()) {
            String[] item = scanner.nextLine().split(",");
            elems.add(item);
        }
        scanner.close();
    }

    @Test
    public void sampleTest() throws InterruptedException, FileNotFoundException {
        Scanner s = new Scanner(new File("/Users/Mary/Documents/Fall22/CMPE187/Socratic/src/main/resources/texttestcases.txt"));
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> chapterPass = new HashMap<String, Integer>();
        HashMap<String, Integer> chapterCount = new HashMap<String, Integer>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();

        if (isElementPresent("id", "com.google.socratic:id/later_button")) {
            MobileElement el5 = (MobileElement) driver.findElementById("com.google.socratic:id/later_button");
            el5.click();
            Thread.sleep(1500);
        }

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Type a question");
        el1.click();
        double num_test_cases = list.size();
        double pass_count = 0.0;

        for (int j = 0; j < list.size(); j++) {
            if (isElementPresent("id", "com.google.socratic:id/later_button")) {
                MobileElement el5 = (MobileElement) driver.findElementById("com.google.socratic:id/later_button");
                el5.click();
                Thread.sleep(1500);
            }
            String[] phrase = list.get(j).split(":");
            if (chapterCount.containsKey(phrase[1])) {
                chapterCount.put(phrase[1], chapterCount.get(phrase[1]) + 1);
            } else {
                chapterCount.put(phrase[1], 1);
            }
            Thread.sleep(1500);
            if (!isElementPresent("id", "com.google.socratic:id/text_query")) {
                while (!isElementPresent("id", "com.google.socratic:id/text_query")) {
                    driver.launchApp();
                    Thread.sleep(1500);
                    MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId("Type a question");
                    el13.click();
                    Thread.sleep(1500);
                }
            }

            MobileElement el2 = (MobileElement) driver.findElementById("com.google.socratic:id/text_query");
            el2.sendKeys(phrase[0]);
            Thread.sleep(1500);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(point(986, 2059)).perform();
            Thread.sleep(1500);

            pass_rate = 0;
            for (String[] elem : elems) {
                String res1 = "none";
                if (isElementPresent(elem[0], elem[1])) {
                    if (elem[1] == "com.google.socratic:id/alertTitle") {
                        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
                        el8.click();
                        res1 = "FAIL";
                    }
                    MobileElement el15 = (MobileElement) driver.findElementById(elem[1]);
                    res1 = el15.getText().toLowerCase();
                    if (res1.equals("")) {
                        res1 = "none";
                    }
//                    res1 = res1.substring(0, res1.length() - 1);

                    for (int i = 2; i < phrase.length; i++) {
                        if (res1.length() > 2){
                            res1 = res1.substring(0, res1.length() - 2);
                        }
                        if (res1.contains(phrase[i]) || res1.startsWith(phrase[i]) || phrase[i].contains(res1)) {
                            ++pass_rate;
                        }
                    }
                    if (phrase[0].toLowerCase().contains(res1)) {
                        pass_rate = phrase.length;
                    }
                }
            }


            if (pass_rate >= 1) {

                System.out.println("PASS");
                ++pass_count;
                if (chapterPass.containsKey(phrase[1])) {
                    chapterPass.put(phrase[1], chapterPass.get(phrase[1]) + 1);
                } else {
                    chapterPass.put(phrase[1], 1);
                }

            } else {
                System.out.println("TEST FAILED");
            }

            Thread.sleep(1500);
            touchAction.tap(point(77, 154)).perform();
            Thread.sleep(1500);

        }
        System.out.println(chapterPass);
        double overall_pass_rate = pass_count / num_test_cases;
        System.out.println(overall_pass_rate);
        System.out.println();
        HashMap<String, Double> passByChapter = new HashMap<>();
        for (HashMap.Entry<String, Integer> entry : chapterCount.entrySet()) {
            double total = entry.getValue();
            double divider = chapterPass.get(entry.getKey());
            passByChapter.put(entry.getKey(), divider / total);
        }
        System.out.println(passByChapter);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected boolean isElementPresent(String type, String by) {

        try {

            if (type.equals("id")) {
                driver.findElementById(by);
            } else if (type.equals("xpath")) {
                driver.findElementByXPath(by);
            }

            return true;

        } catch (NoSuchElementException e) {

            return false;

        }
    }
}

