package ru.geekbrains;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.geekbrains.config.DataBaseConfig;
import ru.geekbrains.service.ProductService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

//@SpringBootApplication
@Component
public class SpringBootAppApplication {

	private final EntityManager entityManager;
	private final ProductService productService;

	public SpringBootAppApplication(EntityManager entityManager, ProductService productService) {
		this.entityManager = entityManager;
		this.productService = productService;
	}

	@PostConstruct
	public void start(){
		try {
			String sql = Files.lines(Paths.get("webshop.sql")).collect(Collectors.joining());
			entityManager.getTransaction().begin();
			entityManager.createNativeQuery(sql).executeUpdate();
			entityManager.getTransaction().commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(productService.getById(4L).getUsers());
		System.out.println(productService.getProductsByUserId(2L));
		System.out.println(productService.getUsersByProdId(1L));
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootAppApplication.class, args);
		new AnnotationConfigApplicationContext(DataBaseConfig.class);

	}

}
