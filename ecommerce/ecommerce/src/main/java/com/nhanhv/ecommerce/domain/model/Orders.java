package com.nhanhv.ecommerce.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

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

    private Long customerId;
    private String orderDate;
    private String address;
    private String amount;
    private String description;
}
