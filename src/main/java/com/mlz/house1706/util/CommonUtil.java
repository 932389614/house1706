package com.mlz.house1706.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.UUID;

import com.mysql.jdbc.AssertionFailedException;

public class CommonUtil {
	private CommonUtil() {
		
	}
	private static final String codes="1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	public static void main(String[] args) {
		System.out.println(generateCode(4));
		
	}
	public static String generateCode(int len) {

		StringBuilder cString=new StringBuilder();
		for(int i=0;i<len;i++) {
			cString.append(codes.toCharArray()[(int)(Math.random()*codes.length())]);
		}
		
		return cString.toString();
		
	}
	
	public static BufferedImage generateCodeImage(String code ,int width,int height) {
		
		BufferedImage codeImage=new BufferedImage(width, height, 1);
		Graphics2D graphics2d=(Graphics2D)codeImage.getGraphics();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, width, height);
		graphics2d.setColor(Color.BLUE);
		for(int i=0;i<code.length();i++) {
			graphics2d.drawString(code.substring(i, i+1), i*20, height/2);
		}
		graphics2d.dispose();
		return codeImage;		
	}
	
	
	
	public static String getFilenameSuffix(String fileName) {
		int index=fileName.lastIndexOf(".");
		return index>0 && index<fileName.length()-1? fileName.substring(index):"";
		
	}


	public static String getUniqueFilename() {
		return UUID.randomUUID().toString();
		
	}
}
