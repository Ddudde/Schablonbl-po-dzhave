package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo")
public class DemoApplication {

	private final Hashd hashd;

	@Autowired
	public DemoApplication(Hashd hashd) {
		this.hashd = hashd;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, "ish", "vyh");
	}

}
