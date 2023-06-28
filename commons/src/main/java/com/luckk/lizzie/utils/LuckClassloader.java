package com.luckk.lizzie.utils;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @Author liukun.inspire
 * @Date 2023/6/24 23:30
 * @PackageName: com.luckk.lizzie.utils
 * @ClassName: LuckClassloader
 * @Version 1.0
 */
public class LuckClassloader extends URLClassLoader {
    public LuckClassloader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public LuckClassloader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }


    public LuckClassloader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
