package com.comparethemarket.enrichment.stubs;

import static com.comparethemarket.enrichment.TestConstants.BRAND_1;
import static com.comparethemarket.enrichment.TestConstants.BRAND_2;
import static com.comparethemarket.enrichment.TestConstants.BRAND_3;
import static com.comparethemarket.enrichment.TestConstants.CUSTOMER_ID;
import static com.comparethemarket.enrichment.TestConstants.WEBSITE_ID_1;
import static com.comparethemarket.enrichment.TestConstants.WEBSITE_ID_2;

import com.comparethemarket.enrichment.domain.input.Brand;
import com.comparethemarket.enrichment.domain.input.BrandsViewed;
import com.comparethemarket.enrichment.domain.input.CustomerEvent;
import com.comparethemarket.enrichment.domain.input.Purchase;
import java.math.BigDecimal;
import java.util.List;
import lombok.val;

public class CustomerEventStub {

	public static CustomerEvent purchaseEvent() {
		return CustomerEvent.builder()
			.customerId(CUSTOMER_ID)
			.brandsViewed(getBrandsViewed())
			.purchaseHistory(getBasicPurchaseHistory())
			.build();
	}

	private static List<BrandsViewed> getBrandsViewed() {
		val brandsViewed1 = BrandsViewed.builder()
			.websiteId(WEBSITE_ID_1)
			.brands(List.of(createBrandFromId(BRAND_1), createBrandFromId(BRAND_2))).build();

		val brandsViewed2 = BrandsViewed.builder()
			.websiteId(WEBSITE_ID_2)
			.brands(List.of(createBrandFromId(BRAND_3))).build();

		return List.of(brandsViewed1, brandsViewed2);
	}

	private static Brand createBrandFromId(String brandId) {
		return Brand.builder()
			.brandId(brandId)
			.brandName(convertIdToBrandName(brandId))
			.build();
	}

	public static String convertIdToBrandName(String brandId) {
		return brandId.replace("id", "name");
	}

	private static List<Purchase> getBasicPurchaseHistory() {

		val product1 = Purchase.builder()
			.brandId(BRAND_1)
			.quantityPurchased(2)
			.itemPrice(BigDecimal.valueOf(120.12)).build();

		val product2  = Purchase.builder()
			.brandId(BRAND_2)
			.quantityPurchased(1)
			.itemPrice(BigDecimal.valueOf(103.02)).build();

		return List.of(product1, product2);
	}


}
