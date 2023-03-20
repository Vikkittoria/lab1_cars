package com.github.rsoi.service;

import com.github.rsoi.domain.Trip;
import com.github.rsoi.domain.User;
import com.github.rsoi.domain.Violation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Searching {
    public static List<User> searchUsers(List<User> userList, Integer experience, Integer trips, Integer N, Integer violations, Double totalSpent) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {
            boolean matches = true;

            // проверяем, что пользователь имеет заданный опыт (если задан)
            if (experience != null && user.getExperience() < experience) {
                matches = false;
            }

            // проверяем, что пользователь совершил заданное количество поездок за последние N месяцев (если задано)
            if (trips != null) {
                int numTrips = 0;
                for (Trip trip : user.getTrips()) {
                    if (trip.getDate().isAfter(LocalDate.now().minusMonths(N))) {
                        numTrips++;
                    }
                }
                if (numTrips < trips) {
                    matches = false;
                }
            }

            // проверяем, что пользователь имеет заданное количество нарушений с заданной даты (если задано)
            if (violations != null) {
                int numViolations = 0;
                for (Violation violation : user.getViolations()) {
                    if (violation.getDate().isAfter(LocalDate.now().minusMonths(violations))) {
                        numViolations++;
                    }
                }
                if (numViolations < violations) {
                    matches = false;
                }
            }

            // проверяем, что пользователь потратил заданную сумму денег (если задана)
            if (totalSpent != null && user.getTotalSpent() < totalSpent) {
                matches = false;
            }

            // если все параметры соответствуют, добавляем пользователя в результат
            if (matches) {
                result.add(user);
            }
        }

        return result;
    }


    public static String viewUsers(User user) {
        String name = user.getName();
        int age = user.getAge();
        int experience = user.getExperience();
        List<Violation> violations = user.getViolations();
        List<Trip> trips = user.getTrips();
        double getspent = user.getTotalSpent();
        return "Name: " + name +
                ", Age: " + age +
                ", Experience: " + experience +
                ", Violations: " + violations.size() +
                ", Trips: " + trips.size() +
                ", Total spent:" + getspent;
    }
}
