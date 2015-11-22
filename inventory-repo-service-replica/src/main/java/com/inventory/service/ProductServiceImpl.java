/**
 * 
 */
package com.inventory.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.Seller;
import com.inventory.entity.SellerImpl;

import proto.Brand;
import proto.Category;
import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private InventoryRepoService inventoryRepoService;

	@Override
	public Integer addProductToInventory(proto.Product productProto) {
		// getProduct object from proto object.
		Product product = buildProductEntity(productProto);
		return inventoryRepoService.addProductToInventory(product);
	}

	@Override
	public ProductSearchResonse getProductsForFilter(ProductSearchRequest productSearchRequest) {
		ProductFilter productFilter = buildProductEntity(productSearchRequest);
		List<Product> productResults = inventoryRepoService.getProductByFilter(productFilter);
		return buildProductSearchResponse(productResults);
	}

	@Override
	public List<Product> getProductByIds(List<Integer> productIds) {
		return inventoryRepoService.getProductsByIds(productIds);
	}
	
	@Override
	public ProductSearchResonse getProductById(Integer id) {
		Product product = inventoryRepoService.getProductsById(id);
		List<Product> productList = new ArrayList<>();
		if (product != null) {
			productList.add(product);
		}
		return buildProductSearchResponse(productList);
	}

	private Product buildProductEntity(proto.Product productProto) {
		Product product = new Product();
		com.inventory.entity.Category category = new com.inventory.entity.Category(
				Integer.valueOf(String.valueOf(productProto.getCategory().getId())),
				productProto.getCategory().getName());
		com.inventory.entity.Brand brand = new com.inventory.entity.Brand(
				Integer.valueOf(String.valueOf(productProto.getBrand().getId())), productProto.getBrand().getName());
		SellerImpl seller = new SellerImpl();
		seller.setId(Integer.valueOf(String.valueOf(productProto.getSellerId())));
		product.setBrand(brand);
		product.setCategory(category);
		product.setColor(productProto.getColor());
		product.setDescription(productProto.getDescription());
		product.setNetRate(BigDecimal.valueOf(productProto.getNetRate()));
		product.setSellRate(BigDecimal.valueOf(productProto.getSellRate()));
		product.setProductName(productProto.getName());
		product.setQuantity(productProto.getQuantity());
		product.setSeller(seller);
		String imgUrls = "";
		List<String> imgUrlList = productProto.getImageUrlsList();
		for (String imgUrl : imgUrlList) {
			imgUrls = imgUrls + imgUrl + ";";
		}
		product.setImgUrl(imgUrls);
		return product;
	}

	private ProductSearchResonse buildProductSearchResponse(List<Product> productResults) {
		ProductSearchResonse.Builder productSearchResponseBuilder = ProductSearchResonse.newBuilder();
		for (Product product : productResults) {
			Brand brand = buildBrand(product);
			Category category = buildcategory(product);
			proto.Product productProto = buildProduct(product, brand, category);
			productSearchResponseBuilder.addProduct(productProto);

		}
		return productSearchResponseBuilder.build();
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

	private ProductFilter buildProductEntity(ProductSearchRequest productSearchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
