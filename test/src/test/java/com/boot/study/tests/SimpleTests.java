package com.boot.study.tests;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/27 18:49
 * @apiNote
 * @see Object
 * @since jdk1.8
 */
public class SimpleTests {

    private Integer resolutionRatio;
    private Boolean defaultConfig;

    public String operate() {
        if (this.resolutionRatio > 1600) {
            if (this.defaultConfig) {
                return "按照默认布局打开页面";
            }
            return "打开双屏布局";
        } else {
            return "打开单屏布局";
        }
    }

    public Integer getResolutionRatio() {
        return resolutionRatio;
    }

    public void setResolutionRatio(Integer resolutionRatio) {
        this.resolutionRatio = resolutionRatio;
    }

    public Boolean getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(Boolean defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public static void main(String[] args) {
        SimpleTests simpleTests = new SimpleTests();
        simpleTests.setResolutionRatio(1400);
        simpleTests.setDefaultConfig(false);
        String operate = simpleTests.operate();
        System.out.println(operate);
        simpleTests.setDefaultConfig(true);
        String operate1 = simpleTests.operate();
        System.out.println(operate1);
        simpleTests.setResolutionRatio(1700);
        simpleTests.setDefaultConfig(false);
        System.out.println(simpleTests.operate());
        simpleTests.setResolutionRatio(1700);
        simpleTests.setDefaultConfig(true);
        System.out.println(simpleTests.operate());
    }
}
