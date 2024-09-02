package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponShopData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost;
    private String category;
    private String categoryText;

    @OneToOne(cascade = CascadeType.ALL)
    private WeaponShopDataGridPosition gridPosition;

    private String image;
    private String newImage;
    private String newImage2;
    private String assetPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

    public WeaponShopDataGridPosition getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(WeaponShopDataGridPosition gridPosition) {
        this.gridPosition = gridPosition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public String getNewImage2() {
        return newImage2;
    }

    public void setNewImage2(String newImage2) {
        this.newImage2 = newImage2;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }
}
