package org.hepx.proext.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页基本数据
 * User: hepanxi
 * Date: 15-1-5
 * Time: 下午5:30
 * 针对EXTJS封装
 */
public class Page<T> implements Serializable {

    //分页 参数
    public int start;

    public int limit=20;//默认第页20条记录

    public long total;

    private List<T> dataList;//对应的当前页记录

    public Page(){}

    public Page(int start, int limit, long total, List<T> dataList) {
        this.start = start;
        this.limit = limit;
        this.total = total;
        this.dataList = dataList;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
