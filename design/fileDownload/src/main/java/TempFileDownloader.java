import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * @Author liukun.inspire
 * @Date 2023/4/3 23:08
 * @PackageName: PACKAGE_NAME
 * @ClassName: TempFileDownloader
 * @Version 1.0
 */
public class TempFileDownloader implements Downloader {
    @Override
    public boolean downloadFile(String url, String prefix, String sufix) {

        String uuid = UUID.randomUUID().toString();

        prefix += uuid;

        URL downloadUrl = null;
        try {
            downloadUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        File tmpFile = null;
        try {
            tmpFile = File.createTempFile(prefix, sufix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileUtils.copyURLToFile(downloadUrl, tmpFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
