package com.cyh.ums;

import org.apache.shiro.spring.boot.autoconfigure.ShiroAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.management.ValueExp;

@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.cyh.ums")
@EnableAutoConfiguration(/*exclude = {QuartzAutoConfiguration.class,ShiroAutoConfiguration.class}*/)
public class UmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmsWebApplication.class, args);
	}
}
