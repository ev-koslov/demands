package com.demands.constructor.constraint;

import com.demands.constructor.LocalizationDescription;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class used to describe validation rule for specific {@link com.demands.constructor.field.FieldDescription} data
 */
@Entity
public class ConstraintDescription {

    public ConstraintDescription() {

    }

    public ConstraintDescription(ConstraintType type) {
        this.type = type;
    }

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(value = EnumType.STRING)
    private ConstraintType type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
