package com.comparethemarket.enrichment.domain.output;

import com.comparethemarket.enrichment.domain.input.Purchase;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingTargetEvent {
	private String customerId;
	private List<Purchase> purchaseHistory;
	private MarketingInfo marketingInfo;
}
