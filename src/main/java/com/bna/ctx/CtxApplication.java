package com.bna.ctx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bna.ctx.controller.A;

@SpringBootApplication
public class CtxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtxApplication.class, args);
		/*A ax = new A();
		double a = 50000.01111;
        double b = 45000.0111;
        double c = a + b;
        c = ax.formatDouble(c);
		System.out.print(c);*/
	}

}
