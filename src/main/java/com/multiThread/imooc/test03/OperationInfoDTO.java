package com.multiThread.imooc.test03;

public class OperationInfoDTO {
    Integer id;
    String name;

    public OperationInfoDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OperationInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
