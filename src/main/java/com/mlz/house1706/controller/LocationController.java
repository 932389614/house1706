package com.mlz.house1706.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlz.house1706.domain.City;
import com.mlz.house1706.domain.District;
import com.mlz.house1706.domain.Province;
import com.mlz.house1706.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationService;
	
	@GetMapping("/cities")
	@ResponseBody
	public List<City> showCities(Province province) {		
		return locationService.listAllCitiesByProvince(province);
	}
	
	@GetMapping("/districts")
	@ResponseBody
	public List<District> showDistricts(City city) {		
		return locationService.listAllDistrictByCity(city);
	}
}
