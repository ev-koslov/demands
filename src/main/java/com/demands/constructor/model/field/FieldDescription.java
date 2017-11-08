package com.demands.constructor.model.field;

import com.demands.constructor.model.LocalizationDescription;
import com.demands.constructor.model.DocumentDescription;
import com.demands.constructor.model.constraint.ConstraintDescription;
import com.demands.constructor.model.resource.ResourceDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describes custom field in {@link DocumentDescription}.
 */

public class FieldDescription {
    private long id;

    //type of field used to make input.
    //Should be used on client-side to render concrete input field with specified type
    private FieldType type;

    //type of field data
    private DataType dataType;

    //embedded object with field name localizations
    private LocalizationDescription name = new LocalizationDescription();

    //list of constraint used to check if field contains valid data
    private List<ConstraintDescription> constraints = new ArrayList<>();

    //description of resource which provides predefined data for field value
    //if field expecting string/number from user input, should be null
    private ResourceDescription resourceReference;

    //default field value
    private String defaultValue;

    public FieldDescription() {

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

    public ResourceDescription getResourceReference() {
        return resourceReference;
    }

    public void setResourceReference(ResourceDescription resourceReference) {
        this.resourceReference = resourceReference;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
