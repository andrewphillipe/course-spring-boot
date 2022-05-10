package br.com.company.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.company.entities.Category;
import br.com.company.entities.Order;
import br.com.company.entities.Payment;
import br.com.company.entities.Product;
import br.com.company.entities.User;
import br.com.company.entities.enums.OrderStatus;
import br.com.company.repositories.OrderRepository;
import br.com.company.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		List<Order> orders = new ArrayList<>();

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);
		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), null, null, u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), null, null, u2, OrderStatus.PAID);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), null, null, u2, OrderStatus.PAID);
		orders.addAll(Arrays.asList(o1, o2, o3));

	

		orderRepository.saveAll(orders);
	}

}
