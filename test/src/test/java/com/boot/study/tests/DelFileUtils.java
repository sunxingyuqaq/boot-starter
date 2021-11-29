package com.boot.study.tests;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/5/26 19:49
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
@Slf4j
public class DelFileUtils {

    @Test
    public void del() {
        delFiles("C:\\Users\\12870\\.m2\\repository");
    }

    private void delFiles(String filePath) {
        File file = FileUtil.file(filePath);
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File info : files) {
                    if (info.exists() && info.isDirectory()) {
                        if ("unknown".equals(info.getName())) {
                            log.info(info.getAbsolutePath());
                            FileUtil.del(info);
                        }
                        else {
                            delFiles(info.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    @Test
    public void getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "新煜一畅涵秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗昕羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔昀枝思丽";
        String boy = "昊宇敏权伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧昀冠策腾楠榕风航弘";
        String name = "顾";
        File girlFile = FileUtil.file("d:/jar/girl.txt");
        File boyFile = FileUtil.file("d:/jar/boy.txt");
        List<String> girlList = new ArrayList<>();
        List<String> boyList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int m = random.nextInt(girl.length() - 1);
            int n = random.nextInt(girl.length() - 1);
            String girlName = name + "陈" + girl.split("")[m];
            String boyName = name + "陈" + boy.split("")[n];
            if (!girlList.contains(girlName)) {
                girlList.add(girlName);
            }
            if (!boyList.contains(boyName)) {
                boyList.add(boyName);
            }
        }
        FileUtil.writeLines(girlList, girlFile, "utf-8");
        FileUtil.writeLines(boyList, boyFile, "utf-8");
    }

    @Test
    public void encode() {
        ces();
    }

    public void ces() {
        String classname = new Exception().getStackTrace()[1].getClassName(); //获取调用者的类名

        String method_name = new Exception().getStackTrace()[1].getMethodName(); //获取调用者的方法名

        StackTraceElement[] stacks = (new Throwable()).getStackTrace();
        for (StackTraceElement stack : stacks) {
            System.out.println(stack.getClassName() + "-" + stack.getMethodName());
        }
        log.info("{},{},111", classname, method_name);
        boolean ping = NetUtil.isOpen(new InetSocketAddress("192.168.219.107", 8080), 500);
        System.out.println(ping);
    }

    @Test
    public void testString(){
        String s1 = "aa";
        String s2 = "bb";
        String s3 = "aa";
        String s4 = s1 + s2;
        String s5 = "aa" + "bb";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(s5.hashCode());
        HttpRequest.post("").form("file",new File(""),new File("")).execute();
    }

}
