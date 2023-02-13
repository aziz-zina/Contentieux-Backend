package com.bna.ctx.controller;

import java.text.DecimalFormat;

import org.springframework.context.annotation.Bean;

public class A {
	@Bean
	public double formatDouble(double x) {
		DecimalFormat df = new DecimalFormat("#.###");
		return Double.parseDouble(df.format(x)) ;
	}
}
