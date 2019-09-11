package com.julius.wisdom_teaching.domain.entity;

/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:21
 * describe:
 * 下拉框数据基础类
 */
public class SelectBase {
    private String label;
    private String value;
    private String url;
    public final String getUrl() { return url; }
    public final void setUrl(String url) { this.url = url; }
    public final String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    public final String getValue() {
        return value;
    }

    public final void setValue(String value) {
        this.value = value;
    }
}
