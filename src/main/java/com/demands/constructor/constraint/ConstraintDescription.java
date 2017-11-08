package com.demands.constructor.constraint;

import com.demands.constructor.LocalizationDescription;


/**
 * Class used to describe validation rule for specific {@link com.demands.constructor.field.FieldDescription} data
 */

public class ConstraintDescription {

    public ConstraintDescription() {

    }

    public ConstraintDescription(ConstraintType type) {
        this.type = type;
    }

    private long id;

    //constraint type - custom or predefined
    private ConstraintType type;

    private LocalizationDescription name = new LocalizationDescription();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ConstraintType getType() {
        return type;
    }

    public void setType(ConstraintType type) {
        this.type = type;
    }

    public LocalizationDescription getName() {
        return name;
    }

    public void setName(LocalizationDescription name) {
        this.name = name;
    }
}
