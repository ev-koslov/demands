package com.demands.constructor.model;


import com.demands.constructor.model.field.FieldDescription;

import java.util.ArrayList;
import java.util.List;


public class DocumentDescription {

    private long id;

    private LocalizationDescription name = new LocalizationDescription();

    private List<FieldDescription> fields = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalizationDescription getName() {
        return name;
    }

    public void setName(LocalizationDescription name) {
        this.name = name;
    }

    public List<FieldDescription> getFields() {
        return fields;
    }

    public void setFields(List<FieldDescription> fields) {
        this.fields = fields;
    }
}
