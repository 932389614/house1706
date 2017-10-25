package com.mlz.house.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mlz.house1706.domain.User;
import com.mlz.house1706.persistence.HouseDao;
import com.mlz.house1706.persistence.House_TypeDao;
import com.mlz.house1706.persistence.UserDao;
import com.mlz.house1706.persistence.impl.House_TypeDaoImpl;
import com.mlz.house1706.persistence.impl.UserDaoImpl;
import com.mlz.house1706.service.HouseService;
import com.mlz.house1706.service.LocationService;
import com.mlz.house1706.service.UserService;
import com.mlz.house1706.service.impl.LocationServiceImpl;
import com.mlz.house1706.service.impl.UserServiceImpl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class AppTest1 {
	@Autowired
	UserService userService;
	@Autowired
	HouseService houseService;
	@Autowired
	LocationService locationService;
	@Test
	public void testLogin() throws IOException {
		/*Version version=new Version("2.3.23");
		Configuration configuration=new Configuration(version);
		configuration.setDirectoryForTemplateLoading(new File("C://java/eclipse/workpace/freemarker"));
		Template template=configuration.getTemplate("template.ftl");
		template.setClassicCompatible(true);
		Writer out=new FileWriter("D://java/index.html");
		Map<String, Object> datamodel=new HashMap();*/
		
		
	}

}
