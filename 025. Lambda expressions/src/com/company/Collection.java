package com.company;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private String name;
    private List<Aggregation> aggregation;

    public Collection(String name) {
        this.name = name;
        aggregation = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Aggregation> getAggregation() {
        return aggregation;
    }

    public void setAggregation(List<Aggregation> aggregation) {
        this.aggregation = aggregation;
    }
}
