package com.luckk.lizzie.service;

import com.luckk.lizzie.service.ElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.MainResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 14:03
 * @PackageName:com.luckk.lizzie
 * @ClassName: ElasticSearchService
 * @Version 1.0
 */
@Service
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private final RestHighLevelClient restHighLevelClient;

    public ElasticSearchServiceImpl(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }


    @Override
    public String getIndex() {
        try {
            MainResponse info = restHighLevelClient.info(RequestOptions.DEFAULT);
            return info.getVersion().getNumber();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
