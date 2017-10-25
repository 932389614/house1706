package com.mlz.house1706.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.dto.UserLoginDto;
import com.mlz.house1706.service.HouseService;
import com.mlz.house1706.util.CommonUtil;
import com.mlz.house1706.util.PageBean;

@Controller
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping("/toPub")
	public ModelAndView toPub() {
		ModelAndView modelAndView=new ModelAndView();
		System.out.println("123");
		modelAndView.setViewName("pub");
		return modelAndView;
	}
	
	@PostMapping("/addHouse")
	public ModelAndView addHouse(House house,MultipartFile primaryPhoto,HttpServletRequest req) throws IllegalStateException, IOException {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("pub");
		String originalFilename=primaryPhoto.getName();
		if(!primaryPhoto.isEmpty()) {
			String newFilename=CommonUtil.getUniqueFilename()+CommonUtil.getFilenameSuffix(originalFilename);
			String path=req.getServletContext().getRealPath("/images/upload");
			primaryPhoto.transferTo(new File(path+"/"+newFilename));
	
			Integer userId=(Integer)req.getSession().getAttribute("userId");
			house.setUser(new User(userId));
			house.setMainPhoto(newFilename);
			house.setPubDate(new Date());
			if(houseService.publishNewHouse(house))
				modelAndView.setViewName("redirect:toIndex");
			else {
				modelAndView.addObject("hint", "发布失败");
				modelAndView.setViewName("redirect:toPub");
			}
		}
		return modelAndView;
	}
	
	
	public PageBean<House> showHouses(@RequestParam(defaultValue="1")int page,@RequestParam
			(defaultValue="10")int size){
		return null;
		
	}
}
