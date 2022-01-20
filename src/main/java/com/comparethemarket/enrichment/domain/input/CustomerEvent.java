package com.comparethemarket.enrichment.domain.input;

import java.util.List;
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
public class CustomerEvent {

	private String customerId;
	private List<Purchase> purchaseHistory;
	private List<BrandsViewed> brandsViewed;

}
