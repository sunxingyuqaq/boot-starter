package com.boot.study.vip;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2021/4/14 13:55
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {


    }
}
