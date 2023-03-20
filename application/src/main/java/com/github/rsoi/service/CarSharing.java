package com.github.rsoi.service;

import com.github.rsoi.domain.Trip;
import com.github.rsoi.domain.User;
import com.github.rsoi.domain.Violation;

import java.time.LocalDate;
import java.util.*;

public class CarSharing {
    private ArrayList<User> users;

    public CarSharing() {
        this.users = new ArrayList<>();
    }

    public void addOldUsers() {
        User user1 = new User("Виктор", 22, 3, Arrays.asList(new Violation("превышение", LocalDate.parse("2023-01-15"))), Arrays.asList(new Trip(15000, LocalDate.parse("2023-01-15"))));
        this.users.add(user1);

        User user2 = new User("Алексей", 31, 12, Arrays.asList(new Violation("не пропустил пешехода", LocalDate.parse("2022-02-15"))), Arrays.asList(new Trip(2000, LocalDate.parse("2022-02-15"))));
        this.users.add(user2);

        User user3 = new User("Марина", 19, 1, Arrays.asList(new Violation("проезд на красный", LocalDate.parse("2023-02-15"))), Arrays.asList(new Trip(35000, LocalDate.parse("2023-02-15"))));
        this.users.add(user3);

    }

    public void addUser() {
        User user = new User();

        System.out.print("Введите фио: ");
        Scanner scanner = new Scanner(System.in);
        user.setName(scanner.nextLine());

        System.out.print("Введите возраст: ");
        user.setAge(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline character

        System.out.print("Введите опыт вождения (в цифрах): ");
        user.setExperience(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline character

        System.out.print("Введите штрафы (разделенные запятыми, в формате 'название штрафа;дата' формат даты yyyy-mm-dd): ");
        String check_violation = scanner.nextLine();
        if (check_violation.contains(";")){
            String[] violationsArray = check_violation.split(",");
            List<Violation> violations = new ArrayList<>();
            for (String violation : violationsArray) {
                String[] violationData = violation.trim().split(";");
                violations.add(new Violation(violationData[0].trim(), LocalDate.parse(violationData[1])));
            }
            user.setViolations(violations);
        } else {
            System.out.print("Введен неправильный штраф или не был введен вовсе.");
            List<Violation> violations = new ArrayList<>();
            user.setViolations(violations);
        }

        System.out.print("Введите поездки (разделенные запятыми, в формате 'стоимость;дата' например: 1500;2023-01-25) формат даты yyyy-mm-dd: ");
        String check_trips = scanner.nextLine();
        if (check_trips.contains(";")){
            String[] tripsArray = check_trips.split(",");
            List<Trip> trips = new ArrayList<>();
            for (String trip : tripsArray) {
                String[] tripData = trip.trim().split(";");
                trips.add(new Trip(Double.parseDouble(tripData[0]), LocalDate.parse(tripData[1])));
            }
            user.setTrips(trips);
        } else {
            System.out.print("Введена неправильная поездка или не была введена вовсе.");
            List<Trip> trips = new ArrayList<>();
            user.setTrips(trips);
        }

        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> Search() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите минимальный опыт или 0 если не учитывать при поиске этот фильтр");
        int experience = scanner.nextInt();

        System.out.println("Введите минимальное кол-во поездок или 0 если не учитывать при поиске этот фильтр");
        int trips = scanner.nextInt();
        int N = 0;
        if (trips != 0) {
            System.out.println("Введите за какое кол-во месяцев должны были совершиться эти поездки");
            N = scanner.nextInt();
        }

        System.out.println("Введите минимальное кол-во штрафов или 0 если не учитывать при поиске этот фильтр");
        int violations = scanner.nextInt();

        System.out.println("Введите минимальное кол-во потраченных средств или 0 если не учитывать при поиске этот фильтр");
        double spent = scanner.nextDouble();

        return Searching.searchUsers(users, experience, trips, N, violations, spent);
    }


}
