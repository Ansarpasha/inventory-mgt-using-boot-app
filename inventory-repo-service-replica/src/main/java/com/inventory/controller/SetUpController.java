/**
 * 
 */
package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.entity.BusinessGroup;
import com.inventory.entity.Category;
import com.inventory.entity.RecommendationCategory;
import com.inventory.entity.SellerImpl;
import com.inventory.repo.BusinessGroupJpa;
import com.inventory.repo.CategoryJpa;
import com.inventory.repo.RecommendationCategoryJpa;
import com.inventory.repo.SellerJpa;

/**
 * @author apasha
 *
 */
@Controller
public class SetUpController {
	@Autowired
	private SellerJpa sellerJpa;
	@Autowired
	private BusinessGroupJpa businessGroupJpa;
	@Autowired
	private CategoryJpa categoryJpa;
	@Autowired
	private RecommendationCategoryJpa recommendationCategoryJpa;

	@RequestMapping("/setUp")
	public @ResponseBody String setUp() {
		// Create Supplier
		// Create BusinessGroup
		// Create Category.
		// Create Buyer

		boolean success = doSetUp();
		if (success) {
			return "setup is completed";
		} else {
			return "Failed to do setup";
		}
	}

	private boolean doSetUp() {
		boolean sucesss = false;
		try {
			SellerImpl seller1 = new SellerImpl();
			seller1.setAddress("MG Road bangalore");
			seller1.setCity("Bangalore");
			seller1.setCompanyName("EZone");
			seller1.setContactLastFirstName("pasha");
			seller1.setContactPersonFirstName("Ansar");
			seller1.setCountry("India");
			seller1.setEmailAddress("ansar.place@gmail.com");
			seller1.setState("Karnataka");

			SellerImpl seller2 = new SellerImpl();
			seller2.setAddress("Indiranagr bangalore");
			seller2.setCity("Bangalore");
			seller2.setCompanyName("Gadget guru");
			seller2.setContactLastFirstName("pasha");
			seller2.setContactPersonFirstName("Ansar");
			seller2.setCountry("India");
			seller2.setEmailAddress("ansar.place@gmail.com");
			seller2.setState("Karnataka");

			sellerJpa.create(seller1);
			sellerJpa.create(seller2);

			BusinessGroup bg1 = new BusinessGroup();
			bg1.setBusinessGroupName("Electronics");

			BusinessGroup bg2 = new BusinessGroup();
			bg2.setBusinessGroupName("Fashion");

			businessGroupJpa.create(bg1);
			businessGroupJpa.create(bg2);

			Category category1 = new Category();
			category1.setCategoryName("Mobile Essentails");
			category1.setBusinessGroup(bg1);
			categoryJpa.create(category1);

			RecommendationCategory recommendationCategory = new RecommendationCategory();
			recommendationCategory.setCategory(category1);
			recommendationCategoryJpa.create(recommendationCategory);

			Category category2 = new Category();
			category2.setCategoryName("Mobile");
			category2.setBusinessGroup(bg1);
			category2.setRecommendationCategory(recommendationCategory);
			categoryJpa.create(category2);

			sucesss = true;
		} catch (Exception ex) {
			System.err.println(ex.getCause());
			ex.printStackTrace();
			sucesss =false;
		}

		return sucesss;
	}

	private void setUpCategory() {

	}

	private void setUpBgGroup() {
		BusinessGroup bg1 = new BusinessGroup();
		bg1.setBusinessGroupName("Electronics");

		BusinessGroup bg2 = new BusinessGroup();
		bg2.setBusinessGroupName("Fashion");

		businessGroupJpa.create(bg1);
		businessGroupJpa.create(bg2);

	}

}
