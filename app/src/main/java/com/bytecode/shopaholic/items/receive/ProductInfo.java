package com.bytecode.shopaholic.items.receive;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tuman on 8/5/2015.
 */
public class ProductInfo implements Parcelable {

    private String createdAt;
    private String description;
    private String imageURL;
    private String name;
    private String objectId;
    private String price;
    private String query;
    private String thumbURL;
    private String updatedAt;

    public ProductInfo() {
    }

    public ProductInfo(String createdAt, String description, String imageURL, String name, String objectId, String price, String query, String thumbURL, String updatedAt) {
        this.createdAt = createdAt;
        this.description = description;
        this.imageURL = imageURL;
        this.name = name;
        this.objectId = objectId;
        this.price = price;
        this.query = query;
        this.thumbURL = thumbURL;
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "createdAt='" + createdAt + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", name='" + name + '\'' +
                ", objectId='" + objectId + '\'' +
                ", price='" + price + '\'' +
                ", query='" + query + '\'' +
                ", thumbURL='" + thumbURL + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
