package com.mlz.house1706.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HttpSessionMutexListener;

import com.mlz.house1706.domain.House;
import com.mlz.house1706.domain.User;
import com.mlz.house1706.dto.CheckResultDto;
import com.mlz.house1706.dto.UserLoginDto;
import com.mlz.house1706.service.HouseService;
import com.mlz.house1706.service.UserService;
import com.mlz.house1706.util.CommonUtil;
import com.mlz.house1706.util.PageBean;

@Controller
public class UserController {
	private static final int CODE_LENGTH = 4;
	@Autowired
	private UserService userService;
	@Autowired
	private HouseService houseService;
	

	@GetMapping("/toLogin")
	public ModelAndView toLogin(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("hint", "欢迎登陆");
		return modelAndView;
	}

	@GetMapping("/toRegister")
	public ModelAndView toReg(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(@Validated UserLoginDto user,Errors errors, Model model,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if(user.getCode().equalsIgnoreCase((String) request.getSession().getAttribute("code"))) {
			user.setIpAddress(request.getRemoteAddr());
			if(!errors.hasErrors()) {
				if (userService.login(user)) {
					modelAndView.setViewName("redirect: toIndex");
					request.getSession().setAttribute("userId", user.getId());
					request.getSession().setAttribute("username", user.getUsername());
				} else {
					modelAndView.setViewName("login");
					modelAndView.addObject("hint", "用户名或密码错误");
				}
			}else {
				System.out.println(errors.getErrorCount());
				
				modelAndView.setViewName("login");
				modelAndView.addObject("hint", "请输入有效的登录信息");
			}
		}
		else {
			modelAndView.setViewName("login");
			modelAndView.addObject("hint", "验证码错误");
		}

		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logout(Model model, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		session.removeAttribute("username");
		modelAndView.setViewName("redirect: toIndex");
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView register(User user, Model model ,String code,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String sessionCode=(String) session.getAttribute("code");
		if(code.equalsIgnoreCase(sessionCode)) {
			if (userService.register(user))
				modelAndView.setViewName("redirect: toLogin");
			else {
				modelAndView.setViewName("register");
				modelAndView.addObject("hint", "用户名已存在");
			}
		}else {
			modelAndView.setViewName("register");
			modelAndView.addObject("hint", "验证码错误");
		}
		
		return modelAndView;
	}


	@GetMapping(value = "/code",produces="image/png")
	@ResponseBody
	public BufferedImage getCode(HttpServletResponse response,HttpSession session) throws IOException {
		String code=CommonUtil.generateCode(CODE_LENGTH);

		session.setAttribute("code", code);
		BufferedImage bufferedImage=CommonUtil.generateCodeImage(code, 80, 30);
		
		//第二种方法：使用流输出
		/*OutputStream outputStream=response.getOutputStream();*/
		
		return bufferedImage;
	}
	@GetMapping("/check")
	@ResponseBody
	public CheckResultDto checkUsername(String username) {
		boolean valid=userService.checkUnique(username);
		return new CheckResultDto(valid, valid?"用户名可用":"用户名已被使用", valid?"ok.png":"no.png",username);
	} 

}
