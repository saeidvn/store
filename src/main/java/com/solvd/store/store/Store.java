package com.solvd.store.store;

import java.util.List;

public class Store {

    private String name;
    private List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
