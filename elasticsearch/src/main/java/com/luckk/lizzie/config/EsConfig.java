package com.luckk.lizzie.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 14:19
 * @PackageName:com.luckk.lizzie.config
 * @ClassName: EsConfig
 * @Version 1.0
 */
@Data
@Component
public class EsConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.connTimeout}")
    private int connTimeout;

    @Value("${elasticsearch.socketTimeout}")
    private int socketTimeout;

    @Value("${elasticsearch.connectionRequestTimeout}")
    private int connectionRequestTimeout;
}

