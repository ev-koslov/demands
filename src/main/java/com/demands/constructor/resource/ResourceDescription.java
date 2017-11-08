package com.demands.constructor.resource;

import com.demands.constructor.LocalizationDescription;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class describes resource to get predefined list of data
 * for specific {@link com.demands.constructor.field.FieldDescription}
 */

@Entity
public class ResourceDescription {

    public ResourceDescription() {

    }

    public ResourceDescription(ResourceType type) {
        this.type = type;
    }

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(value = EnumType.STRING)
    private ResourceType type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LocalizationDescription name = new LocalizationDescription();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public LocalizationDescription getName() {
        return name;
    }

    public void setName(LocalizationDescription name) {
        this.name = name;
    }
}
