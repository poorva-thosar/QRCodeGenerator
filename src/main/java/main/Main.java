package main;

import URL.CheckValidURL;
import URL.URLShortner;
import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import qrcode.GenerateQRCode;
import qrcode.ReadQRCode;
import window.ShowWindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //main() method
    public static void main(String args[]) throws WriterException, IOException, NotFoundException, InterruptedException {
        while(true) {
            String urlList[] = { "http://google.com/", "http://google.com",
                    "http://www.yahoo.com", "http://yahoo.com/", "http://amazon.com",
                    "http://amazon.com/page1.php", "http://amazon.com/page2.php",
                    "http://flipkart.in", "http://rediff.com",
                    "http://techmeme.com", "http://techmeme.com /tech",
                    "http://techcrunch.com", "www.lifehacker.com",
                    "http://lifehacker.com", "http://icicibank.com",
                    "https://www.example.com/generate-qr-code" };

            int min = 0, max = 15;
            int randomNumber = (int)(Math.random()*(max-min+1)+min);

            //data that we want to store in the QR code
            String str = urlList[randomNumber];

            // CHECK VALID URL
            CheckValidURL checkvalidurl = new CheckValidURL();
            if (checkvalidurl.isValid(str))
            {
                System.out.println("Provided valid URL");
            }
            else
            {
                System.out.println("***Provided invalid URL***");
                continue;
            }

            // SHORTEN THE GIVEN URL
            URLShortner urls = new URLShortner(5, "www.shortenedurl.com/");
            String shortenedUrl = urls.shortenURL(str);
            System.out.println("URL:" + str + "\tShortened: "
                    + shortenedUrl + "\tExpanded: "
                    + urls.expandURL(urls.shortenURL(str)));

            // GENERATE QR CODE
            //path where we want to get QR Code
            String path = "C:\\Users\\Poorva\\Desktop\\QRDemo\\URLSpecific\\"+randomNumber+"Quote.png";
            //Encoding charset to be used
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            //generates QR code with Low level(L) error correction capability
            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            //invoking the user-defined method that creates the QR code
            GenerateQRCode generateqrcode = new GenerateQRCode();
            generateqrcode.generateQRcode(str, path, charset, hashMap, 400, 400);//increase or decrease height and width accodingly
            //prints if the QR code is generated
            System.out.println("QR Code created successfully and stored at the path :" + path);

            // READ QR CODE URL
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            //generates QR code with Low level(L) error correction capability
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            ReadQRCode readqrcode = new ReadQRCode();
            System.out.println("Data stored in the QR Code is: "+ readqrcode.readQRcode(path, charset, hintMap));

            // DISPLAY QR CODE ON WINDOW
            ShowWindow shwWindow = new ShowWindow();
            shwWindow.createJFrame();
            shwWindow.displayQRCode(path, urlList[randomNumber], shortenedUrl);
            Thread.sleep(10000);
            shwWindow.disposeJFrame();
        }

    }

}
