import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/4/3 22:55
 * @PackageName: PACKAGE_NAME
 * @ClassName: DownloaderTest
 * @Version 1.0
 */
public class DownloaderTest {
    public static final String PATH = "/Users/liukunkun/Downloads/test5";


    public static List<String> urlList = new ArrayList<>();

    static {

        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-03bbbd715c24750e.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-a99419bb94924e6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-736bc3917fe92142.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-7fe8c323e533f656.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-c12521fbde6c705b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-caf66b935fd00e18.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-48dd99da471ffa3f.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        urlList.add("https://upload-images.jianshu.io/upload_images/5809200-4de5440a56bff58f.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
    }


    public static final String URL = "https://img.win3000.com/m00/d6/f0/39de3b0c924e419833db0c8aab402dd6.jpg";

    @Test
    public void testFileDownload() throws IOException, InterruptedException {
        URL url = new URL(URL);
        File tempFile = File.createTempFile(PATH, ".jpg");
        FileUtils.copyURLToFile(url, tempFile);
        Thread.sleep(10000);
    }

    @Test
    public void testDownloadOriginForOneThousand() {
        RealFileDownloader realFileDownloader = new RealFileDownloader();

        LocalDateTime before = LocalDateTime.now();

        int idx = 0;
        for (int i = 0; i < 1000; i++) {
            idx++;
            realFileDownloader.downloadFile(urlList.get(idx % urlList.size()), "/Users/liukunkun/Downloads/", ".jpg");
        }
        LocalDateTime after = LocalDateTime.now();
        Duration between = Duration.between(before, after);
        long l = between.toMillis();
        System.out.println(l / 1000);

        // 28
    }

    @Test
    public void testDownloadTmpForFifty() {
        TempFileDownloader downloader = new TempFileDownloader();

        LocalDateTime before = LocalDateTime.now();

        int idx = 0;
        for (int i = 0; i < 1000; i++) {
            idx++;
            downloader.downloadFile(urlList.get(idx % urlList.size()), "/Users/liukunkun/Downloads/", ".jpg");
        }
        LocalDateTime after = LocalDateTime.now();
        Duration between = Duration.between(before, after);
        long l = between.toMillis();
        System.out.println(l / 1000);

        // 31
    }
}
