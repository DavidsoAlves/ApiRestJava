package com.api.productcontrol.models;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT_CONTROL")
public class ProductControlModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 70)
    private String productSupplier;
    @Column(nullable = false, length = 70)
    private String productCategory;
    @Column(nullable = false, length = 70)
    private String productBrand;
    @Column(nullable = false, length = 150)
    private String productDescription;
    @Column(nullable = false, length = 4)
    private String productUnit;
    @Column(nullable = false, length = 20)
    private BigDecimal productQuantity;
    @Column(nullable = false, length = 20)
    private BigDecimal productValue;
    @Column(nullable = false)
    private LocalDateTime productRegistrationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public BigDecimal getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(BigDecimal productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    public LocalDateTime getProductRegistrationDate() {
        return productRegistrationDate;
    }

    public void setProductRegistrationDate(LocalDateTime productRegistrationDate) {
        this.productRegistrationDate = productRegistrationDate;
    }
}
