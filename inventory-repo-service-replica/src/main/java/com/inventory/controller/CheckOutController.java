/**
 * 
 */
package com.inventory.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.service.CheckOutService;

import proto.ProductCheckoutRequest;
import proto.ProductCheckoutResponse;

/**
 * @author apasha
 *
 */
@Controller
public class CheckOutController {
	@Autowired
	private CheckOutService checkOutService;

	@RequestMapping(value = "/products/checkout", method = RequestMethod.GET)
	public @ResponseBody String test(){
		return "tested and working";
	}
	
	@RequestMapping(value = "/products/checkout", method = RequestMethod.POST)
	public @ResponseBody ProductCheckoutResponse checkOutProducts(final InputStream inputStream) {
		ProductCheckoutRequest productCheckoutRequest = null;
		try {
			productCheckoutRequest = ProductCheckoutRequest.parseFrom(inputStream);
		} catch (IOException e) {
			String message = "Unable to get probuf from input stream";
			System.err.println(message);
			e.printStackTrace();
			throw new RuntimeException(message);
		}
		
		return checkOutService.checkOut(productCheckoutRequest);
	}
}
