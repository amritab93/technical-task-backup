package com.comparethemarket.enrichment.transformer;

import static com.comparethemarket.enrichment.transformer.TransformerUtils.calculateAverageSpend;
import static com.comparethemarket.enrichment.transformer.TransformerUtils.getBrands;

import com.comparethemarket.enrichment.domain.input.CustomerEvent;
import com.comparethemarket.enrichment.domain.output.MarketingInfo;
import com.comparethemarket.enrichment.domain.output.MarketingTargetEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Transformer {
	public MarketingTargetEvent transform(CustomerEvent event) {

		return MarketingTargetEvent.builder()
			.customerId(event.getCustomerId())
			.marketingInfo(getMarketingInfo(event))
			.purchaseHistory(event.getPurchaseHistory())
			.build();
	}

	private MarketingInfo getMarketingInfo(CustomerEvent event) {

		return MarketingInfo.builder()
			.averageSpend(calculateAverageSpend(event))
			.brandsForTargeting(getBrands(event))
			.build();
	}

}
