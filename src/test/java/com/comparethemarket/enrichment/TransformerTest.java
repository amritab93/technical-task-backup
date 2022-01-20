package com.comparethemarket.enrichment;

import static com.comparethemarket.enrichment.TestConstants.BRAND_3;
import static com.comparethemarket.enrichment.stubs.CustomerEventStub.convertIdToBrandName;
import static com.comparethemarket.enrichment.stubs.CustomerEventStub.purchaseEvent;
import static org.assertj.core.api.Assertions.assertThat;

import com.comparethemarket.enrichment.transformer.Transformer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.val;
import org.junit.Test;

public class TransformerTest {

	private final Transformer underTest = new Transformer();

	@Test
	public void testTransformerReturnsExpectedValues() {
		val result = underTest.transform(purchaseEvent());
		val expectedAverageSpend = BigDecimal.valueOf(114.42).setScale(2, RoundingMode.UNNECESSARY);

		assertThat(result.getMarketingInfo().getAverageSpend()).isEqualTo(expectedAverageSpend);
		assertThat(result.getMarketingInfo().getBrandsForTargeting()).contains(convertIdToBrandName(BRAND_3));
		assertThat(result.getMarketingInfo().getBrandsForTargeting().size()).isEqualTo(1);
	}

}
