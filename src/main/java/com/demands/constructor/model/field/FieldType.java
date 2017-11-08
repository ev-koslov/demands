package com.demands.constructor.model.field;

import static com.demands.constructor.model.field.DataType.*;

/**
 * Enumeration of input field types. Used on client side to determine what input field to render.
 * Also provides data type which will be used to fill the field value
 */
public enum  FieldType {
    TEXT(STRING),
    PASSWORD(STRING),
    RADIO(RESOURCE),
    CHECKBOX(BOOLEAN),
    DATE(DataType.DATE),
    DATE_TIME(DataType.DATE_TIME),
    NUMBER(DataType.NUMBER),
    TEXT_AREA(STRING),
    SELECT(RESOURCE);

    private DataType dataType;

    FieldType(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }
}
