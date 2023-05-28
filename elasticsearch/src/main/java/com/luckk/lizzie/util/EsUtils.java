package com.luckk.lizzie.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckk.lizzie.exception.ErrorCode;
import com.luckk.lizzie.exception.LuckKunException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author liukun.inspire
 * @Date 2023/4/17 22:54
 * @PackageName: com.luckk.lizzie.util
 * @ClassName: EsUtils
 * @Version 1.0
 */
@Slf4j
@Component
public class EsUtils {
    protected static final Logger logger = LoggerFactory.getLogger(EsUtils.class);
    private final RestHighLevelClient client;

    public EsUtils(RestHighLevelClient client) {
        this.client = client;
    }

    public boolean createIndex(String indexName) {

        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        CreateIndexResponse response;
        try {
            response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new LuckKunException(ErrorCode.ELASTIC_SEARCH_EXCEPTION);
        }
        if (Objects.nonNull(response)) {
            return response.isAcknowledged();
        }
        return false;
    }

    public GetIndexResponse queryIndex(String indexName) {

        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        GetIndexResponse response;
        try {
            response = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new LuckKunException(ErrorCode.ELASTIC_SEARCH_EXCEPTION);
        }
        return response;
    }

    ObjectMapper mapper = new ObjectMapper();

    public <T> IndexResponse insertNewDocument(String indexName, T data) {

        IndexRequest indexRequest = new IndexRequest(indexName);
        IndexResponse response;
        try {
            indexRequest.source(mapper.writeValueAsString(data));
            response = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("");
            throw new LuckKunException(ErrorCode.ELASTIC_SEARCH_EXCEPTION);
        }

        return response;
    }


    public List<String> queryMatchAll(String idx, List<String> data) throws IOException {


        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        searchRequest.source(query);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getHits());

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }

        return Arrays.stream(response.getHits().getHits())
                .map(SearchHit::getSourceAsString)
                .collect(Collectors.toList());
    }

    public List<String> query(String indexName) throws IOException {

        SearchRequest searchRequest = new SearchRequest();
        // 字段查询
        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.matchPhraseQuery("name", "111"));
        // 分页
        query.from(2);
        query.size(10);
        // 指定特定的字段
        // 可以单独设置include和exclude
        String[] include = {};
        String[] exclude = {};
        query.fetchSource(include, exclude);
        // 排序
        query.sort("name", SortOrder.DESC);
        searchRequest.source(query);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getHits());

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }

        return Arrays.stream(response.getHits().getHits())
                .map(SearchHit::getSourceAsString)
                .collect(Collectors.toList());

    }


    public void boolQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        // 字段查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", "lkk"));
        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("sex", "男"));

        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(boolQueryBuilder);
        searchRequest.source(query);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
    }

    public void rangeQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        // 范围查询
        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.rangeQuery("age")
                        .gte(10).lte(100));
        searchRequest.source(query);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

    }

    public void fuzzyQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        // 模糊查询
        // 几个字符的模糊查询
        SearchSourceBuilder query = new SearchSourceBuilder()
                .query(QueryBuilders.fuzzyQuery("name", "liukun")
                        .fuzziness(Fuzziness.TWO));
        searchRequest.source(query);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

    }

    public void aggregationQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        // 聚合查询
        SearchSourceBuilder query = new SearchSourceBuilder()
                .aggregation(AggregationBuilders.avg("avgAge").field("age"));
        searchRequest.source(query);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        Aggregation avgAge = response.getAggregations().get("avgAge");
    }
}
