package com.educando.web.course.config;

import com.educando.web.course.entities.Category;
import com.educando.web.course.entities.Order;
import com.educando.web.course.entities.User;
import com.educando.web.course.entities.enums.OrderStatus;
import com.educando.web.course.repositories.CategoryRepository;
import com.educando.web.course.repositories.OrderRepository;
import com.educando.web.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");
//
//        Product p1 new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 90.5, "");
//        Product p2 new Product(null, "Smart TV", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium", 2190.0, "");
//        Product p3 new Product(null, "Macbook Pro", "Duis aute irure dolor in reprehenderit ",1250.0, "");
//        Product p4 new Product(null, "PC Gamer", "Excepteur sint occaecat cupidatat non proident", 1200.0, "");
//        Product p5 new Product(null, "Rails for Dummies", "Nemo enim ipsam voluptatem quia voluptas sit", 100.99, "");


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
