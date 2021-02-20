package ru.geekbrains.watch.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:secured.properties")
public class WatchMarketApplication {
	// Домашнее задание:
	// 1. Сделайте профилировщик, который подсчитывает какой метод в проекте
	// используется чаще всего
	// 2. * Попробуйте подсчитать методы какого контроллера уходит больше всего времени

	public static void main(String[] args) {
		SpringApplication.run(WatchMarketApplication.class, args);
	}
}