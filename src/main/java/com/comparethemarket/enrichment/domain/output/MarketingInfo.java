package com.comparethemarket.enrichment.domain.output;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingInfo {

	private BigDecimal averageSpend;
	private List<String> brandsForTargeting;

}
