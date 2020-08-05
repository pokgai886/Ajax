package com.etc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UpLoadFileController {
	@RequestMapping("/uploadFile")
	public String upload(@RequestParam("fileRamark")String fileRamark,@RequestParam("myfile")MultipartFile myfile,HttpServletRequest request) throws IllegalStateException, IOException {
		//1.��ȡ����ͨԪ��
		System.out.println("��ͨ��Ԫ���ļ�˵��:"+fileRamark);
		
		//2.��ȡ�ϴ����ļ���
		String filename=myfile.getOriginalFilename();
		
		//3.�ϴ�Ŀ¼
		File file=new File("E:\\temp\\"+filename);
		myfile.transferTo(file);
		
		return "success";
		
	}
		
}
