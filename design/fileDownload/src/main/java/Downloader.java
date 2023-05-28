/**
 * @Author liukun.inspire
 * @Date 2023/4/3 23:04
 * @PackageName: PACKAGE_NAME
 * @ClassName: Downloader
 * @Version 1.0
 */
public interface Downloader {


    boolean downloadFile(String url, String prefix, String sufix);
}
