package com.code4worldpeace.capstone3.Products.Model.Response;

public class ProductResponse {
    private String sku;
    private String name;
    private int stock;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Sku: %s | Name: %s | Stock: %d", getSku(), getName(), getStock());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        ProductResponse comparator = (ProductResponse) obj;
        boolean equals = isEquals(comparator.getName(), this.getName());
        equals &= isEquals(comparator.getSku(), this.getSku());
        equals &= isEquals(comparator.getStock(), this.getStock());
        return equals;
    }

    private boolean isEquals(int comparatorInt, int thisInt) {
        return comparatorInt == thisInt;
    }

    private boolean isEquals(String comparatorString, String thisString) {
        if (comparatorString == null && thisString == null) {
            return true;
        }
        return comparatorString != null && comparatorString.equals(thisString);
    }
}
