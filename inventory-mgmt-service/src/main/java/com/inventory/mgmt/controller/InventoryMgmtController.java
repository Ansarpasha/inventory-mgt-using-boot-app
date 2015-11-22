package com.inventory.mgmt.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InventoryMgmtController {

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
			@RequestParam(value = "sellerId", required = true) Integer sellerId) {

		boolean isFileSaved = saveFileAtServer(names, files);
		if (isFileSaved) {
			//TODO : call to perform validation and handle negative flows.
			return "File uploaded";
		} else {
			return "File upload failed";
		}
		// return null;
	}

	@RequestMapping("/test")
	public @ResponseBody String test(@RequestParam("asd") String[] strArray) {
		return strArray.toString();
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam(value = "file", required = false) MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + "name");
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return "You successfully uploaded file=" + "name";
			} catch (Exception e) {
				return "You failed to upload " + "name" + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + "name" + " because the file was empty.";
		}
	}

	private boolean saveFileAtServer(String[] names, MultipartFile[] files) {
		if (files.length != names.length)
			return false;

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(
						"/Users/apasha/Documents/workspace-sts-3.7.1.RELEASE/images" + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				message = message + "You successfully uploaded file=" + name + "<br />";
			} catch (Exception e) {
				System.err.println("You failed to upload " + name + " => " + e.getMessage());
				return false;
			}
		}
		return true;
	}
}
