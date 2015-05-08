package com.bytecode.shopaholic.items;

/**
 * Created by ultimate on 5/8/2015.
 */
public class Scart {
    public String __type;
    public String className;
    public String objectId;

    public Scart(String __type, String className, String objectId) {
        this.__type = __type;
        this.className = className;
        this.objectId = objectId;
    }

    public String get__type() {
        return __type;
    }

    public void set__type(String __type) {
        this.__type = __type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "Scart{" +
                "__type='" + __type + '\'' +
                ", className='" + className + '\'' +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
