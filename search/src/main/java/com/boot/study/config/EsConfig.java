package com.boot.study.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/9/15 13:50
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Configuration
public class EsConfig {

    @Value("${elasticsearch.host}")
    public String host;

    /**
     * 之前使用transport的接口的时候是9300端口，现在使用HighLevelClient则是9200端口
     */
    @Value("${elasticsearch.port:9200}")
    public int port;

    public static final String SCHEME = "http";

    @Value("${elasticsearch.username:elastic}")
    public String username;

    @Value("${elasticsearch.authenticationPassword:123456}")
    public String authenticationPassword;

    @Bean(name = "remoteHighLevelClient")
    @ConditionalOnProperty(prefix = "elasticsearch.enable",value = "true",matchIfMissing = true)
    public RestHighLevelClient restHighLevelClient() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username,
                authenticationPassword));
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, SCHEME)).
                setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);
    }
}
