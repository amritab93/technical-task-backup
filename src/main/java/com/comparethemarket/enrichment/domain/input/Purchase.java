package com.comparethemarket.enrichment.domain.input;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Purchase {

	private String brandId;
	private Integer quantityPurchased;
	private BigDecimal itemPrice;

}
