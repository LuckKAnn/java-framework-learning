package com.luckk.lizzie.service;

import com.luckk.lizzie.domain.UserDO;
import com.luckk.lizzie.service.ElasticSearchService;
import com.luckk.lizzie.util.EsUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
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

    private final EsUtils esUtils;

    public ElasticSearchServiceImpl(RestHighLevelClient restHighLevelClient, EsUtils esUtils) {
        this.restHighLevelClient = restHighLevelClient;
        this.esUtils = esUtils;
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

    @Override
    public void addDocument() {

        UserDO userDO = new UserDO();
        userDO.setName("luck");
        userDO.setTel("133333333");
        userDO.setSex("man");
        IndexResponse response = esUtils.insertNewDocument("index", userDO);



    }
}
