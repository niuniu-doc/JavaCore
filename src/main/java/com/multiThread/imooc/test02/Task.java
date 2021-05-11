package com.multiThread.imooc.test02;

public class Task {
    String words;
    int leftCount;

    public Task(String words, int leftCount) {
        this.words = words;
        this.leftCount = leftCount;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(int leftCount) {
        this.leftCount = leftCount;
    }

    @Override
    public String toString() {
        return "Task{" +
                "words='" + words + '\'' +
                ", leftCount=" + leftCount +
                '}';
    }
}
