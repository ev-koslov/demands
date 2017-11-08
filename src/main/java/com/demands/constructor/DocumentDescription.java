package com.demands.constructor;


import com.demands.constructor.field.FieldDescription;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class DocumentDescription {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LocalizationDescription name = new LocalizationDescription();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
