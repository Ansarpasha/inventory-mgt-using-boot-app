package com.inventory.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.endpoint.service.CheckoutService;

import proto.ProductCheckoutRequest;
import proto.ProductCheckoutResponse;
import proto.RequestedProduct;

@Controller
public class CheckoutProductController {
	@Autowired
	private CheckoutService checkoutService;

	@RequestMapping(value = "/checkOut", method = RequestMethod.POST)
	public @ResponseBody ProductCheckoutResponse checkOut(@RequestParam("productIds") Integer productIds[],
			@RequestParam("qtys") Integer qtys[], @RequestParam("buyerId") Integer buyerId,
			@RequestParam("pciInfo") String pciInfo) throws Exception {
		ProductCheckoutRequest productCheckoutRequest = buildProductCheckoutRequest(productIds, qtys, buyerId, pciInfo);
		return checkoutService.checkOutProduct(productCheckoutRequest);
	}

	private ProductCheckoutRequest buildProductCheckoutRequest(Integer[] productIds, Integer[] qtys, Integer buyerId,
			String pciInfo) {
		ProductCheckoutRequest.Builder productCheckoutRequestBuilder = ProductCheckoutRequest.newBuilder();
		productCheckoutRequestBuilder.setBuyerId(buyerId).setPciInfo(pciInfo);
		for (int i = 0; i < productIds.length; i++) {
			RequestedProduct requestedProduct = buildRequestedProduct(productIds[i], qtys[i]);
			productCheckoutRequestBuilder.addRequestedProduct(requestedProduct);
		}
		return productCheckoutRequestBuilder.build();
	}

	private RequestedProduct buildRequestedProduct(Integer productId, Integer qty) {
		RequestedProduct.Builder requestedProductBuilder = RequestedProduct.newBuilder();
		requestedProductBuilder.setProductId(productId).setQty(qty);
		return requestedProductBuilder.build();
	}
}
