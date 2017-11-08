package com.demands.constructor.field;

import com.demands.constructor.LocalizationDescription;
import com.demands.constructor.constraint.ConstraintDescription;
import com.demands.constructor.resource.ResourceDescription;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class describes custom field in {@link com.demands.constructor.DocumentDescription}.
 */

@Entity
public class FieldDescription {

    @Id
    @GeneratedValue
    private long id;

    //type of field used to make input.
    //Should be used on client-side to render concrete input field with specified type
    @Enumerated(value = EnumType.STRING)
    private FieldType type;
    //type of field data
    @Enumerated(value = EnumType.STRING)
    private DataType dataType;

    //embedded object with field name localizations
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LocalizationDescription name = new LocalizationDescription();

    //list of constraint used to check if field contains valid data
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ConstraintDescription> constraints;

    //description of resource which provides predefined data for field value
    //if field expecting string/number from user input, should be null
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ResourceDescription resourceType;

    //default field value
    private String defaultValue;

    public FieldDescription() {
        constraints = new ArrayList<>();
    }

    public FieldDescription(FieldType type) {
        this.type = type;
        this.dataType = type.getDataType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public LocalizationDescription getName() {
        return name;
    }

    public void setName(LocalizationDescription name) {
        this.name = name;
    }

    public List<ConstraintDescription> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<ConstraintDescription> constraints) {
        this.constraints = constraints;
    }

    public ResourceDescription getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceDescription resourceType) {
        this.resourceType = resourceType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
