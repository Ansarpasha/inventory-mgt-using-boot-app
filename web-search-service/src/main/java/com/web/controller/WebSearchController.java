package com.web.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.WebService;

import proto.Product;
import proto.ProductSearchResonse;

@Controller
public class WebSearchController {
	@Autowired
	private WebService webService;

	@RequestMapping(value = "/test")
	public @ResponseBody String test() {
		return "tested and its working";
	}

	@RequestMapping(value = "/web/product", method = RequestMethod.GET)
	public @ResponseBody String getProducts(final InputStream inputStream) {

		return "tested and its working";
	}

	@RequestMapping(value = "/web/product/{productId}", method = RequestMethod.GET)
	public @ResponseBody ProductSearchResonse getProduct(final @PathVariable("productId") int productId) {
		return webService.getProductById(productId);
	}

	@RequestMapping(value = "/web/product", method = RequestMethod.POST)
	public @ResponseBody String addProducts(final InputStream inputStream) {
		Product product = null;
		try {
			product = Product.parseDelimitedFrom(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		webService.addProduct(product);
		return webService.addProduct(product).toString();
	}

	@RequestMapping(value = "/web/product", method = RequestMethod.PUT)
	public @ResponseBody String updateProducts(final InputStream inputStream) {
		return "tested and its working";
	}

	@RequestMapping(value = "/web/product", method = RequestMethod.DELETE)
	public @ResponseBody String removeProducts(final Integer productId) {
		return "tested and its working";
	}

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

}
