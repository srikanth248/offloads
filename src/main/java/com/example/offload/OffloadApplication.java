package com.example.offload;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class OffloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffloadApplication.class, args);
	}

	@Bean
	public ConnectionFactory getConnectionFactory() {
		return new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
	}

	@Bean
	public JmsTemplate getJmsTemplate(ConnectionFactory connectionFactory) {
		return new JmsTemplate(connectionFactory);
	}

	@Bean
	public TaskExecutor getTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(1);
		taskExecutor.setCorePoolSize(1);
		taskExecutor.setQueueCapacity(10);
		taskExecutor.setThreadNamePrefix("Thread-");
		taskExecutor.initialize();
		return taskExecutor;
	}

}
