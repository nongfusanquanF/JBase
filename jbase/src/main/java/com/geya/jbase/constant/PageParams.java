package com.geya.jbase.constant;

import java.io.Serializable;

/**
 * 分页参数类
 */
public class PageParams implements Serializable {

    /**
     *分页参数
     */
    private static final long serialVersionUID = 1L;
    private Integer pageNo;
    private Integer pageSize;
    private long totalCount;
    private String orderBy;
    private String result;

    public PageParams(Integer pageSize) {
        super();
        this.pageSize = pageSize;
        this.pageNo = 1;
    }

    public PageParams() {
        super();
        this.pageSize = 10;
        this.pageNo = 1;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageNo() {

        return pageNo ;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void addPage() {
            pageNo++;
    }

    /**
     * 分页出错时，要回退
     */
    public void cutPage() {
        if (pageNo > 1) {
            pageNo--;
        }
    }

    public void reset() {
        pageNo = 1;
    }
}
