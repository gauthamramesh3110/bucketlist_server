package com.bucketlist.app.bucketlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class BucketlistApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(BucketlistApplication.class, args);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(requests -> requests
			.requestMatchers(HttpMethod.POST, "/user").permitAll()
			.requestMatchers(HttpMethod.GET, "/hello").permitAll()
		)
		.csrf(c -> c.disable())
		.build();
	}
}

