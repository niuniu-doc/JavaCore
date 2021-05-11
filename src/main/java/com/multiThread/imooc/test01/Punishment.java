package com.multiThread.imooc.test01;

public class Punishment {
    // store copyCounts and words
    private String word;
    private Integer leftCopyCount;

    public Punishment(Integer leftCopyCount, String word) {
        this.word = word;
        this.leftCopyCount = leftCopyCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getLeftCopyCount() {
        return leftCopyCount;
    }

    public void setLeftCopyCount(Integer leftCopyCount) {
        this.leftCopyCount = leftCopyCount;
    }
}
