import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @Author liukun.inspire
 * @Date 2023/4/3 23:03
 * @PackageName: PACKAGE_NAME
 * @ClassName: RealFileDownloader
 * @Version 1.0
 */
@Slf4j
public class RealFileDownloader implements Downloader {


    @Override
    public boolean downloadFile(String url, String prefix, String sufix) {
        String fileName = UUID.randomUUID().toString();
        URL downloadUrl = null;
        try {
            downloadUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        if (downloadUrl == null) {
            return false;
        }
        String filePath = prefix + fileName + sufix;

        try {
            FileUtils.copyURLToFile(downloadUrl, new File(filePath));
        } catch (IOException e) {
            log.error("download file fail");
            return false;
        }
        return true;
    }
}
