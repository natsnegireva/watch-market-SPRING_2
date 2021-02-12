package ru.geekbrains.watch.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:secured.properties")
public class WatchMarketApplication {
	// Домашнее задание 1:
	// 1. Если пользователь авторизован показываем в шапке какую-нибудь информацию о нем (имя),
	// если нет, там же в шапке должны быть поля логин/пароль и кнопка войти
	// 2. Попробуйте сделать оформление заказа с привязкой к текущему пользователю

	// Домашнее задание 1:
	// 1. Добавить к заказу возможность указания адреса доставки в виде строки
	// 2. Сделать регистрацию пользователей через REST API

	public static void main(String[] args) {
		SpringApplication.run(WatchMarketApplication.class, args);
	}
}