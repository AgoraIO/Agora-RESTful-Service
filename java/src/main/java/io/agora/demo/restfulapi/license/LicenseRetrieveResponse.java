package io.agora.demo.restfulapi.license;

import java.util.List;

public class LicenseRetrieveResponse {
    private Long totalSize;
    private Integer pageSize;
    private Integer pageNumber;
    private Boolean hasMore;
    private List<LicenseInfo> elements;

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<LicenseInfo> getElements() {
        return elements;
    }

    public void setElements(List<LicenseInfo> elements) {
        this.elements = elements;
    }
}
