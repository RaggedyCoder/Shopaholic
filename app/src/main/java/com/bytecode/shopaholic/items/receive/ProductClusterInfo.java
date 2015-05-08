package com.bytecode.shopaholic.items.receive;

import java.util.List;

/**
 * Created by tuman on 8/5/2015.
 */
public class ProductClusterInfo {

    List<ProductInfo> results;

    public ProductClusterInfo() {
    }

    public ProductClusterInfo(List<ProductInfo> results) {
        this.results = results;
    }

    public List<ProductInfo> getResults() {
        return results;
    }

    public void setResults(List<ProductInfo> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ProductClusterInfo{" +
                "results=" + results +
                '}';
    }
}
