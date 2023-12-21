package ru.flamexander.spring.data.jdbc.demo.dtos;

import java.util.List;

public class PageDto<T> {
    private List<T> list;
    private Integer pageNumber;
    private Integer pageSize;

    public PageDto() {
    }

    public PageDto(List<T> list, Integer pageNumber, Integer pageSize) {
        this.list = list;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
