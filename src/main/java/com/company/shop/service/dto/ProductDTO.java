package com.company.shop.service.dto;

import javax.validation.constraints.*;

import com.company.shop.domain.Comments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A DTO for the {@link com.company.shop.domain.Product} entity.
 */
public class ProductDTO implements Serializable {

    private String id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer price;

    private ArrayList<Comments> comments;

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> cm) {
        this.comments = cm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (productDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + getId() + ", name='" + getName() + "'" + ", description='" + getDescription()
                + "'" + ", quantity=" + getQuantity() + ", price=" + getPrice() + "}";
    }
}
