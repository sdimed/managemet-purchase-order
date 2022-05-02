package com.management.managment_purchase_order;

import com.management.managment_purchase_order.entity.User;
import com.management.managment_purchase_order.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ManagmentPurchaseOrderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ManagmentPurchaseOrderApplication.class, args);
        UserRepository repository = context.getBean(UserRepository.class);
        repository.save(User.builder().Firstname("ahmed").LastName("Sidi").barthDay(new Date()).build());
        repository.save(User.builder().Firstname("mohamed").LastName("vall").barthDay(new Date()).build());
        repository.save(User.builder().Firstname("macron").LastName("manuel").barthDay(new Date()).build());
        repository.save(User.builder().Firstname("bun").LastName("nasri").barthDay(new Date()).build());
        repository.save(User.builder().Firstname("kool").LastName("bruown").barthDay(new Date()).build());

        List<User> users = repository.findAll();
        users.forEach(System.out::println);
    }

}
