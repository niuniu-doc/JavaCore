package com.juc.lock;

public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "韩"),
    FIVE(5, "赵"),
    SIX(6, "魏");

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    private Integer retCode;
    private String retMsg;
    CountryEnum(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] myEnums = CountryEnum.values();
        for (CountryEnum countryEnum: myEnums) {
            if (index == countryEnum.getRetCode()) {
                return countryEnum;
            }
        }
        return null;
    }

}
