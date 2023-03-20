package com.github.rsoi;

import com.github.rsoi.domain.Trip;
import com.github.rsoi.domain.Violation;
import com.github.rsoi.domain.User;
import com.github.rsoi.service.CarSharing;
import com.github.rsoi.service.Searching;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//ArrayList<User> users = new ArrayList<User>();
		CarSharing CarSharing = new CarSharing();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			CarSharing carSharing = new CarSharing();
			System.out.println("0. Добавить готовых пользователей");
			System.out.println("1. Добавить пользователя");
			System.out.println("2. Поиск пользователей");
			System.out.println("3. Вывести всех пользователей");
			System.out.println("4. Выйти");
			System.out.print("Введите номер команды: ");

			int command = scanner.nextInt();
			scanner.nextLine();

			switch (command) {
				case 0:
					CarSharing.addOldUsers();
					System.out.println("Пользователи успешно добавлены.");
					break;

				case 1:
					CarSharing.addUser();
					System.out.println("Пользователь успешно добавлен.");
					break;

				case 2:
					// код поиска пользователей

					List<User> result = CarSharing.Search();
					for (User user_info : result) {
						System.out.println(Searching.viewUsers(user_info));
					}
					break;

				case 3:
					for (User user_info : CarSharing.getUsers()) {
						System.out.println(Searching.viewUsers(user_info));
					}
					break;

				case 4:
					System.out.println("Выход из программы.");
					System.exit(0);

				default:
					System.out.println("Некорректный ввод.");
					break;
			}
		}
	}

}
