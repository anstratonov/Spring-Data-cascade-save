package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TesthiberApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TesthiberApplication.class, args);
		ParentRepository parentRepository = context.getBean(ParentRepository.class);

		Parent p = new Parent();
		p.setName("test1");

		Child c1 = new Child();
		c1.setName("test2");
		c1.setParent(p);

		Set<Child> childSet = new HashSet<>();
		childSet.add(c1);

		p.setChildSet(childSet);

		parentRepository.save(p);
	}
}
