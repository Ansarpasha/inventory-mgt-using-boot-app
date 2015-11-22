/**
 * 
 */
package com.inventory.search.service;

import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
public interface ProductSearchService {

	ProductSearchResonse getProductById(Integer productId);

	ProductSearchResonse getProductByName(String productName);

	ProductSearchResonse getProductByFilter(Integer productId, Integer brandId, Integer businessGroupId,
			Integer categoryId, String productName);

}
