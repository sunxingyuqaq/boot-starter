package com.boot.study.jpa;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.webservice.SoapClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/7/8 11:49
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class SimpleTests {

    @Test
    public void test(){
        // 新建客户端
        SoapClient client = SoapClient.create("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("web:getSupportCity", "http://WebXml.com.cn/")
                // 设置参数，此处自动添加方法的前缀：web
                .setParam("byProvinceName", "江苏");
        String send = client.send(true);
        Console.log(send);
    }

    @Test
    public void testCity(){
        // 新建客户端
        SoapClient client = SoapClient.create("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx")
                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
                .setMethod("web:getWeatherbyCityName", "http://WebXml.com.cn/")
                // 设置参数，此处自动添加方法的前缀：web
                .setParam("theCityName", "苏州");
        String send = client.send(true);
        Console.log(send);

        String words = "试测你好号案件2222见覅滴滴反间谍法\n" +
                "辅导辅导辅导费测试你好号案件2222见覅滴滴反间谍法\n" +
                "辅导辅导辅导费李婆婆大幅度发反反复复\n" +
                "辅导费 神鼎飞丹砂哦拉开了辅导辅导费\n" +
                "李婆婆大幅度发反反复复测试你好号案件2222见覅滴滴反间谍法\n" +
                "辅导辅导辅导费李婆婆大幅度发反反复复\n" +
                "辅导费 神鼎飞丹砂哦拉开了辅导辅导费\n" +
                "测试你好号案件2222见覅滴滴反间谍法\n" +
                "辅导辅导辅导费李婆婆大幅度发反反复复\n" +
                "辅导费 神鼎飞丹砂哦拉开了辅导辅导费\n" +
                "发电房的地方付付付或或或\n" +
                "辅导费 神鼎飞丹砂哦拉开了辅导辅导费";
        int count = ReUtil.count("(测试)", words);
        int count1 = ReUtil.count("(反反复)", words);
        int count2 = ReUtil.count("(开了)", words);
        int count3 = ReUtil.count("(付或或或)", words);
        Console.log("{},{},{},{}",count,count1,count2,count3);
    }
}
