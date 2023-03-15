package com.luckk.lizzie.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 14:18
 * @PackageName:com.luckk.lizzie.config
 * @ClassName: ElasticsearchConfiguration
 * @Version 1.0
 */
@Configuration
public class ElasticsearchConfiguration {

    @Autowired
    EsConfig esConfig;

    @Bean(destroyMethod = "close", name = "client")
    public RestHighLevelClient initRestClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(esConfig.getHost(), esConfig.getPort()))
                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(esConfig.getConnTimeout())
                        .setSocketTimeout(esConfig.getSocketTimeout())
                        .setConnectionRequestTimeout(esConfig.getConnectionRequestTimeout()));
        return new RestHighLevelClient(builder);
    }

    // 注册 rest高级客户端
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(esConfig.getHost(), esConfig.getPort(), "http")
                )
        );
        return client;
    }
}
