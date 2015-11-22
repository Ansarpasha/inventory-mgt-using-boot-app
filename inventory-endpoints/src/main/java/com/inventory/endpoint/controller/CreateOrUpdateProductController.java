package com.inventory.endpoint.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.endpoint.service.CreateOrUpdateProductService;

import proto.Brand;
import proto.Category;
import proto.Product;

@Controller
public class CreateOrUpdateProductController {
	@Autowired
	private CreateOrUpdateProductService createOrUpdateProductService;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public @ResponseBody String addProduct(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files,
			@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "sellRate", required = false) Integer sellRate,
			@RequestParam(value = "netRate", required = false) Integer netRate,
			@RequestParam(value = "qty", required = true) Integer qty,
			@RequestParam(value = "brandId", required = false) Integer brandId,
			@RequestParam(value = "categoryId", required = false) Integer categoryId,
			@RequestParam(value = "sellerId", required = true) Integer sellerId,
			@RequestParam(value = "brandName", required = true) String brandName,
			@RequestParam(value = "categoryName", required = true) String categoryName) {

		Product product = buildProductProto(productName, names, color, description, sellRate, netRate, qty, brandId,
				categoryId, sellerId, brandName, categoryName);
		return createOrUpdateProductService.addProduct(product, files, names);
	}

	private Product buildProductProto(String productName, String[] names, String color, String description,
			Integer sellRate, Integer netRate, Integer qty, Integer brandId, Integer categoryId, Integer sellerId,
			String brandName, String categoryName) {
		Product.Builder productBuilder = Product.newBuilder();
		Brand brand = buildBrand(brandId, brandName);
		Category category = buildCategory(categoryId, categoryName);
		productBuilder.setColor(color).setDescription(description).setName(productName).setNetRate(netRate)
				.setSellRate(sellRate).setQuantity(qty).setSellerId(sellerId).setBrand(brand).setCategory(category);
		List<String> imageUrls = new ArrayList<String>();
		for(String fileName : names){
			imageUrls.add(fileName);
		}
		productBuilder.addAllImageUrls(imageUrls);
		return productBuilder.build();
	}

	private Category buildCategory(Integer categoryId, String categoryName) {
		Category.Builder builder = Category.newBuilder();
		return builder.setId(categoryId).setName(categoryName).build();
	}

	private Brand buildBrand(Integer brandId, String brandName) {
		Brand.Builder builder = Brand.newBuilder();
		return builder.setId(brandId).setName(brandName).build();
	}

}
