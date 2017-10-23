package com.mlz.house1706.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mlz.house1706.service.HouseService;
import com.mlz.house1706.service.LocationService;

public class PreLoadDataListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		sce.getServletContext().removeAttribute("houseTypeList");
		sce.getServletContext().removeAttribute("ponvinceList");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		WebApplicationContext wac = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		HouseService houseService = wac.getBean(HouseService.class);
		LocationService locationService = wac.getBean(LocationService.class);
		sc.setAttribute("houseTypeList", houseService.listAllHouse_Types());
		sc.setAttribute("provinceList", locationService.listAllProvinces());
		
		
	}

}
