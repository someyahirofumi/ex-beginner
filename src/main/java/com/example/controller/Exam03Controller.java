package com.example.controller;

import java.text.DecimalFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("buy")
	public String buy(Integer product1Value,Integer product2Value,Integer product3Value) {
		DecimalFormat formater= new DecimalFormat("000,000,");
		Integer total=product1Value+product2Value+product3Value;
		Integer fullTotal=(total/10)+total;
		application.setAttribute("total",formater.format(total));
		application.setAttribute("fullTotal", formater.format(fullTotal));
		
		return "exam03-result";
	}
}
