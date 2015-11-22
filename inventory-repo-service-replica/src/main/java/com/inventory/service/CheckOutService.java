/**
 * 
 */
package com.inventory.service;

import proto.ProductCheckoutRequest;
import proto.ProductCheckoutResponse;

/**
 * @author apasha
 *
 */
public interface CheckOutService {
	
	ProductCheckoutResponse checkOut(ProductCheckoutRequest productCheckoutRequest);

}
