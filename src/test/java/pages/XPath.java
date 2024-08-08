package pages;

import base.BasePage;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import java.time.Duration;
import java.util.Iterator;

public class XPath extends BasePage {
    //The Elements
    @FindBy(xpath = "/html/body/div/div/section/div/div/article/div[2]/form/div[1]/p/img")
    private WebElement captchaImageElement;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/form/div[1]/div[1]/input")
    private WebElement captchaTextBox;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/form/div[1]/div[2]/input")
    private WebElement captchaClickButton;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[1]/h1")
    private WebElement captchaTitle;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/form/div[2]/p[2]")
    private WebElement captchaWrongMessage;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[2]/form/div[2]/p[1]")
    private WebElement captchaCorrectMessage;
    @FindBy(xpath = "/html/body/div/div/section/div/div/article/div[3]/nav/div[1]/a")
    private WebElement olderBlogerButton;
    @FindBy(xpath = "/html/body/div[1]/div/section/div/div/article/div[3]/nav/div[2]/a")
    private WebElement newerBlogerButton;
    @FindBy(xpath = "/html/body/div[1]/div/header/div[3]/div[1]/div/div[2]/div/nav/ul/li[2]/a")
    private WebElement practiceTab;










    public XPath(WebDriver driver) {
        //Constructor
        super(driver);
    }

    //The Methods
    public String isTitleTrue(){
        return captchaTitle.getText();
    }
    public String isOlderBlogerButtonWorking(){
        // النقر على الزر
        olderBlogerButton.click();

        // انتظار الانتقال إلى الصفحة الجديدة (استبدل "new_page_url" بعنوان URL الفعلي للصفحة الجديدة)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://practicetestautomation.com/"));

        // التحقق من أن العنوان URL الحالي هو العنوان المتوقع
        return driver.getCurrentUrl();
    }
    public String isNewerBlogerButtonWorking(){
        // النقر على الزر
        newerBlogerButton.click();

        // انتظار الانتقال إلى الصفحة الجديدة (استبدل "new_page_url" بعنوان URL الفعلي للصفحة الجديدة)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://practicetestautomation.com/"));

        // التحقق من أن العنوان URL الحالي هو العنوان المتوقع
        return driver.getCurrentUrl();
    }
    public String checkCaptchaIsCorrect(){
        visibilityOfElement(driver,captchaImageElement);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            BufferedImage fullImg = ImageIO.read(screenshot);
            BufferedImage newImage = setDPI(fullImg, 300);
            Rectangle rect = captchaImageElement.getRect();
            BufferedImage captchaImage = newImage.getSubimage(rect.x, rect.y, rect.width, rect.height);
            File captchaFile = new File("captcha.png");
            ImageIO.write(captchaImage, "png", captchaFile);

            // استخدام Tesseract لتحليل النص من الصورة
            ITesseract instance = new Tesseract();
            instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // تأكد من تعديل المسار حسب بيئتك
            String result = instance.doOCR(captchaFile);
            System.out.println("The CAPTCHA text is: " + result);
            // إدخال النص في مربع النص
            setTextElementText(captchaTextBox,result.trim());
            captchaClickButton.click();
            return captchaCorrectMessage.getText();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        return "";
    }
    public String checkCaptchaIsWrong(){
        visibilityOfElement(driver,captchaImageElement);

        try {
            // إدخال النص في مربع النص
            setTextElementText(captchaTextBox,"535453");
            captchaClickButton.click();
            visibilityOfElement(driver,captchaWrongMessage);
            return captchaWrongMessage.getText();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        return "";
    }
    public void isBackWorking(){
        backToDashboard();
        visibilityOfElement(driver,captchaTitle);
    }
    public Practice isPracticeTabWorking(){
        practiceTab.click();
        return new Practice(driver);
    }
    public static BufferedImage setDPI(BufferedImage image, int dpi) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();

        // إنشاء ملف مؤقت لحفظ الصورة المعدلة
        File tempFile = new File("temp.png");

        // الحصول على الكاتب المناسب لنوع الملف
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = writers.next();

        // إعداد البيانات الوصفية (metadata) لضبط DPI
        ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
        IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, null);

        if (metadata.isReadOnly() || !metadata.isStandardMetadataFormatSupported()) {
            throw new IllegalArgumentException("Cannot modify metadata");
        }

        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
        IIOMetadataNode dimension = new IIOMetadataNode("Dimension");
        IIOMetadataNode horizontalPixelSize = new IIOMetadataNode("HorizontalPixelSize");
        IIOMetadataNode verticalPixelSize = new IIOMetadataNode("VerticalPixelSize");

        double inchesPerMeter = 39.3701;
        horizontalPixelSize.setAttribute("value", Double.toString(1.0 / (dpi / inchesPerMeter)));
        verticalPixelSize.setAttribute("value", Double.toString(1.0 / (dpi / inchesPerMeter)));

        dimension.appendChild(horizontalPixelSize);
        dimension.appendChild(verticalPixelSize);
        root.appendChild(dimension);
        metadata.mergeTree("javax_imageio_1.0", root);

        // كتابة الصورة الجديدة مع metadata إلى ملف
        ImageOutputStream stream = ImageIO.createImageOutputStream(tempFile);
        writer.setOutput(stream);
        writer.write(metadata, new IIOImage(image, null, metadata), null);
        stream.close();

        // إعادة قراءة الصورة الجديدة مع ضبط DPI
        return ImageIO.read(tempFile);
    }




}
