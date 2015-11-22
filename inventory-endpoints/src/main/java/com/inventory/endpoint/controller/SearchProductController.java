package com.inventory.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.endpoint.service.ProductSearchService;

import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

@Controller
@RequestMapping("/search")
public class SearchProductController {
	@Autowired
	private ProductSearchService productSearchService;

	@RequestMapping("/test")
	public String test() {
		return "tested and its working ";
	}

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody ProductSearchResonse getProductById(final @PathVariable Integer productId) {
		return productSearchService.getProductById(productId);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public @ResponseBody ProductSearchResonse getProductByName(
			final @RequestParam(value = "productName", required =true) String productName) {
		return productSearchService.getProductByName(productName);
	}

	@RequestMapping(value = "/product/filter", method = RequestMethod.GET)
	public @ResponseBody ProductSearchResonse getProductByFilter(
			final @RequestParam(value = "sellerId") Integer productId,
			final @RequestParam(value = "brandId") Integer brandId,
			final @RequestParam(value = "bgId") Integer businessGroupId,
			final @RequestParam(value = "categoryId") Integer categoryId,
			final @RequestParam(value = "productName") String productName) {

		return productSearchService.getProductByFilter(productId, brandId, businessGroupId, categoryId, productName);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody ProductSearchResonse getProductByFilter(final ProductSearchRequest productSearchRequest) {

		return null;
	}
	
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}
}
