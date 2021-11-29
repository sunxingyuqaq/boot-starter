package com.boot.study.tests;

import java.util.Random;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/27 19:05
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class ForTests {

    private Integer power;
    private Object data;

    public void generateNext() {
        System.out.println("产生遗传算法初始化种群");
    }

    public void operate() {
        System.out.println("执行操作");
        for (int d = 1; d < 1000; d++) {
            int i = processData(d);
            if (i >= 365) {
                boolean compute = compute();
                if (compute) {
                    System.out.println("收敛，over");
                    break;
                } else {
                    System.out.println("不收敛，继续执行");
                    operate();
                }
            }
        }
    }

    public static void main(String[] args) {
        ForTests forTests = new ForTests();
        forTests.setPower(300);
        forTests.setData("data");
        System.out.println("输入：" + forTests.getPower() + "---" + forTests.getData());
        forTests.generateNext();
        forTests.operate();
    }

    public boolean compute() {
        System.out.println("计算适应度");
        return new Random().nextInt(10) >= 5;
    }

    public int processData(int i) {
        return i + new Random().nextInt(300);
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
