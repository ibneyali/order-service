package com.order.ordermanagement.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ProductTable")
public class ProductEntity {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private Long id;
	private Long productId;
	private String productName;
	private String productGroup;
	private Float productPrice;
	private Date expiryDate;

	public ProductEntity(Long id, Long productId, String productName, String productGroup, float productPrice,
			Date expiryDate) {
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productGroup = productGroup;
		this.productPrice = productPrice;
		this.expiryDate = expiryDate;
	}

	

}
