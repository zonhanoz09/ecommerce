package com.nhanhv.ecommerce.domain.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @CreatedBy
//    private ObjectId creatorId;
//    @LastModifiedBy
//    private ObjectId modifierId;
//
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime modifiedAt;

    private String name;
    private String unitPrice;
    private String image;
    private String productDate;
    private String available;
    private Long categoryId;
    private Integer quantity;
    private String description;
    private String discount;
    private String viewCount;
    private String special;
}
