package com.demands.constructor.model.resource;

import com.demands.constructor.model.LocalizationDescription;

/**
 * Class describes resource to get predefined list of data
 * for specific {@link com.demands.constructor.model.field.FieldDescription}
 */
public class ResourceDescription {

    public ResourceDescription() {

    }

    public ResourceDescription(ResourceType type) {
        this.type = type;
    }

    private long id;

    //resource description - predefined or custom
    private ResourceType type;

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
