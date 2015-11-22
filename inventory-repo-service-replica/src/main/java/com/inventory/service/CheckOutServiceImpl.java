/**
 * 
 */
package com.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Orders;
import com.inventory.entity.OrdersDetail;
import com.inventory.entity.Product;
import com.inventory.repo.OrdersRepo;

import proto.Brand;
import proto.Category;
import proto.OrderDetail;
import proto.ProductCheckoutRequest;
import proto.ProductCheckoutResponse;
import proto.RequestedProduct;

/**
 * @author apasha
 *
 */
@Service
public class CheckOutServiceImpl implements CheckOutService {
	@Autowired
	private OrdersRepo ordersRepo;
	@Autowired
	private ProductService productService;

	@Override
	public ProductCheckoutResponse checkOut(ProductCheckoutRequest productCheckoutRequest) {
		//Call for payment gate way with PCI info
		//on success
		Orders order = buildOrdersFromRequest(productCheckoutRequest);
		Orders savedOrder =ordersRepo.createOrUpdate(order);
		return buildProductCheckoutResponse(savedOrder);
		
		//on failure throw exception
	}

	private ProductCheckoutResponse buildProductCheckoutResponse(Orders savedOrder) {
		ProductCheckoutResponse.Builder builder = ProductCheckoutResponse.newBuilder();
		Set<OrdersDetail> orderDetails =savedOrder.getOrdersDetail();
		for(OrdersDetail ordersDetail : orderDetails){
			builder.addOrderDetail(buildOrderDetail(ordersDetail));
		}
		return builder.build();
	}

	private OrderDetail buildOrderDetail(OrdersDetail ordersDetail) {
		OrderDetail.Builder builder = OrderDetail.newBuilder();
		builder.setOrderDetailId(ordersDetail.getId());
		builder.setProduct(buildProductProto(ordersDetail.getProduct()));
		return builder.build();
	}

	private proto.Product buildProductProto(Product product) {
		Brand brand = buildBrand(product);
		Category category = buildcategory(product);
		return buildProduct(product, brand, category);
	}

	private proto.Product buildProduct(Product product, Brand brand, Category category) {
		proto.Product.Builder productBuilder = proto.Product.newBuilder();
		productBuilder.setBrand(brand).setCategory(category);
		productBuilder.setId(product.getId()).setColor(product.getColor()).setDescription(product.getDescription())
				.setName(product.getProductName()).setNetRate(product.getNetRate().longValue())
				.setQuantity(product.getQuantity()).setSellRate(product.getSellRate().longValue())
				.setSellerId(product.getSeller().getId());
		// ImageUrls
		if (product.getImageUrls() != null) {
			for (String imgUrl : product.getImageUrls()) {
				productBuilder.addImageUrls(imgUrl);
			}
		}
		// product.getCategory().
		// Recommendation
		if (product.getRecommendations() != null) {
			for (Product recmdProduct : product.getRecommendations()) {
				// productBuilder.addRecommendations(recmdProduct);
			}
		}
		return productBuilder.build();
	}

	private Category buildcategory(Product product) {
		Category.Builder categoryBuilder = Category.newBuilder();
		categoryBuilder.setId(product.getCategory().getId()).setName(product.getCategory().getCategoryName());
		if (product.getCategory().getRecommendationCategory() != null) {
			categoryBuilder
					.setRecommededCategoryId(product.getCategory().getRecommendationCategory().getCategory().getId());
		}
		return categoryBuilder.build();
	}

	private Brand buildBrand(Product product) {
		Brand.Builder brandBuilder = Brand.newBuilder();
		brandBuilder.setId(product.getBrand().getId()).setName(product.getBrand().getBrandName());
		return brandBuilder.build();
	}

	private Orders buildOrdersFromRequest(ProductCheckoutRequest productCheckoutRequest) {
		Orders orders = new Orders();
		orders.setOrdersDetail(buildOrderDetail(productCheckoutRequest));
		orders.setPaymentId(1);
		orders.setShippingId(1);
		orders.setBuyerId(productCheckoutRequest.getBuyerId());
		return orders;
	}

	private Set<OrdersDetail> buildOrderDetail(ProductCheckoutRequest productCheckoutRequest) {
		Set<OrdersDetail> orderDetails = new HashSet<>();
		Map<Integer, Product> productMap = getProducts(productCheckoutRequest.getRequestedProductList());
		for(RequestedProduct requestedproduct : productCheckoutRequest.getRequestedProductList()){
			OrdersDetail orderDetail = new OrdersDetail();
			Product product = productMap.get(requestedproduct.getProductId());
			product.setQuantity(product.getQuantity()-requestedproduct.getQty());
			orderDetail.setProduct(product);
			orderDetail.setQty(requestedproduct.getQty());
			orderDetails.add(orderDetail);
		}
		return orderDetails;
	}

	private Map<Integer, Product> getProducts(List<RequestedProduct> requestedProductList) {
		Map<Integer, Product> productMap = new HashMap<>();
		List<Integer> productIds = new ArrayList<>();
		for(RequestedProduct requestedproduct : requestedProductList){
			productIds.add(requestedproduct.getProductId());
		}
		List<Product> productList =productService.getProductByIds(productIds);
		for(Product product : productList){
			productMap.put(product.getId(), product);
		}
		return productMap;
	}

}
