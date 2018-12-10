package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsumerRunApp {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerRunApp.class, args);
	}
}
