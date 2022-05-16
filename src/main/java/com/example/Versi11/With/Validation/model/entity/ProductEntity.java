package com.example.Versi11.With.Validation.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table (name="tbl_product")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    //Anotasi @NotEmpty hanya muncul jika di mavennya ditambahkan validation
    //dan memiliki fungsi untuk membuat aturan validasi, jika tidak sesuai persyaratannya makan akan muncul pesan
    @Column(name = "product_name", length = 100)
    private String name;

    @NotEmpty(message = "Name is required")
    @Column(name = "product_description", length = 500)
    private String description;

    private double price;

    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoryId", referencedColumnName = "id")
    private List<CategoryEntity> categoryEntity;

    @ManyToMany
    @JoinTable(name = "tbl_product_supplier",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn (name = "supplier_id"))
   // @JsonManagedReference //Berfungsi untuk mencegah terjadinya infinity loop di dalam JSONnya
    private Set<SupplierEntity> supplier;

    public ProductEntity(){

    }

    public ProductEntity(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<CategoryEntity> getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(List<CategoryEntity> categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Set<SupplierEntity> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<SupplierEntity> supplier) {
        this.supplier = supplier;
    }
}
