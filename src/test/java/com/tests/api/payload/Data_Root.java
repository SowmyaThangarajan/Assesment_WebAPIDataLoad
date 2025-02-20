package com.tests.api.payload;

public class Data_Root {
    private Data data;
    private Support support;

    public Data_Root(Support support, Data data) {
        this.support = support;
        this.data = data;
    }

    public Data_Root() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "Data_Root{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
