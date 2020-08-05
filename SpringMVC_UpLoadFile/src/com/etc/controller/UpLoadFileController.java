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
		//1.获取表单普通元素
		System.out.println("普通表单元素文件说明:"+fileRamark);
		
		//2.获取上传的文件名
		String filename=myfile.getOriginalFilename();
		
		//3.上传目录
		File file=new File("E:\\temp\\"+filename);
		myfile.transferTo(file);
		
		return "success";
		
	}
		
}
