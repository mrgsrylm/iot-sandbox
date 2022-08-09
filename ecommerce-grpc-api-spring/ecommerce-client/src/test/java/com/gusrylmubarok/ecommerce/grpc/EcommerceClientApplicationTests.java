package com.gusrylmubarok.ecommerce.grpc;

import com.gusrylmubarok.ecommerce.grpc.client.GrpcClient;
import com.gusrylmubarok.ecommerce.grpc.client.GrpcClientRunner;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class EcommerceClientApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	@Order(1)
	void beanGrpcServerRunnerTest() {
		assertNotNull(context.getBean(GrpcClient.class));
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> context.getBean(GrpcClientRunner.class),
				"GrpcClientRunner should not be loaded during test");
	}

}
