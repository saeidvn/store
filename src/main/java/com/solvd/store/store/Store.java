package com.solvd.store.store;

import java.util.ArrayList;

public class Store {

    private ArrayList<Section> sections = new ArrayList<>();
    public void addSection(Section section) {
        this.sections.add(section);
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
}
