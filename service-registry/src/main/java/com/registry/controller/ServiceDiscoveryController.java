package com.registry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.registry.service.ServiceDiscovery;

@Controller
public class ServiceDiscoveryController {
	@RequestMapping("/test")
	public @ResponseBody String test() {
		return "tested and its working ";
	}

	@RequestMapping(value = "/service/discovery")
	public @ResponseBody String getServiceProvider(@RequestParam(value = "serviceName") String serviceName) {
		return ServiceDiscovery.discoverService(serviceName);
	}
}
