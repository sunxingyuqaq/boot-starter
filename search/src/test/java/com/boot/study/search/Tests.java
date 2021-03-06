package com.boot.study.search;

import cn.hutool.json.JSONUtil;
import com.boot.study.entity.Hero;
import com.boot.study.tests.BaseWebApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/9/15 13:46
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class Tests extends BaseWebApplicationTests {

    @Autowired
    @Qualifier("remoteHighLevelClient")
    private RestHighLevelClient client;

    @Test
    public void createIndex() throws IOException {
        IndexRequest request = new IndexRequest("hero");
        request.id("1");
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "??????");
        map.put("country", "???");
        map.put("birthday", "??????155???");
        map.put("longevity", "65");
        request.source(map);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        long version = indexResponse.getVersion();
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        assertEquals(1, version);
    }

    @Test
    public void bulkRequestTest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("hero").id("2")
                .source(XContentType.JSON,"id", "2", "name", "??????", "country", "???", "birthday", "??????161???", "longevity", "61"));
        request.add(new IndexRequest("hero").id("3")
                .source(XContentType.JSON,"id", "3", "name", "??????", "country", "???", "birthday", "??????182???", "longevity", "61"));
        request.add(new IndexRequest("hero").id("4")
                .source(XContentType.JSON,"id", "4", "name", "?????????", "country", "???", "birthday", "??????181???", "longevity", "53"));
        request.add(new IndexRequest("hero").id("5")
                .source(XContentType.JSON,"id", "5", "name", "?????????", "country", "???", "birthday", "??????179???", "longevity", "72"));
        request.add(new IndexRequest("hero").id("6")
                .source(XContentType.JSON,"id", "6", "name", "??????", "country", "???", "birthday", "??????163???", "longevity", "49"));
        request.add(new IndexRequest("hero").id("7")
                .source(XContentType.JSON,"id", "7", "name", "??????", "country", "???", "birthday", "??????160???", "longevity", "60"));
        request.add(new IndexRequest("hero").id("8")
                .source(XContentType.JSON,"id", "8", "name", "??????", "country", "???", "birthday", "??????175???",  "longevity", "35"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        assertFalse(bulkResponse.hasFailures());
    }

    @Test
    public void updateTest() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("country", "???");
        UpdateRequest request = new UpdateRequest("hero", "7").doc(jsonMap);
        UpdateResponse updateResponse = client.update(request,  RequestOptions.DEFAULT);
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
    }

    @Test
    public void insertOrUpdateOne(){
        Hero hero = new Hero();
        hero.setId(5);
        hero.setName("??????");
        hero.setCountry("???");
        hero.setBirthday("??????187???");
        hero.setLongevity(39);
        IndexRequest request = new IndexRequest("hero");
        request.id(hero.getId().toString());
        request.source(JSONUtil.toJsonStr(hero), XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);   //  1
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selectByUserTest(){
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("country", "???"));
        // ?????????mysql?????????limit 1???
        builder.size(1);
        request.source(builder);
        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            assertEquals(1, hits.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void boolQueryTest(){
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(termQuery("country", "???"));
        boolQueryBuilder.must(rangeQuery("longevity").gte(50));
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.from(0).size(2);
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.sort("longevity", SortOrder.DESC);
        request.source(sourceBuilder);
        SearchResponse response = null;
        try {
            response = client.search(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("Query by Condition execution failed: {}", e.getMessage(), e);
        }
        assert response != null;
        assertEquals(0, response.getShardFailures().length);
        SearchHit[] hits = response.getHits().getHits();
        List<Hero> herosList = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            herosList.add(JSONUtil.toBean(hit.getSourceAsString(), Hero.class));
        }
        log.info("print info: {}, size: {}", herosList.toString(), herosList.size());
    }

}
