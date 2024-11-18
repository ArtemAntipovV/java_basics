package org.example;

import java.text.SimpleDateFormat;
import java.util.*;
import static java.lang.System.out;




public class App {

    private static int USERS = 20;

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");


    private static void log(int UsersOnline) {
        String log = String.format("[%s] Пользователей онлайн: %d", DF.format(new Date()), UsersOnline);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        RedisStorage redis = new RedisStorage();
        redis.init();

        List<Integer> userQueue = new ArrayList<>();
        for (int i = 1; i <= USERS; i++) {
            userQueue.add(i);
        }
        int currentIndex = 0;

        while (true) {

            int currentUser = userQueue.get(currentIndex);
            redis.logPageVisit(currentUser);

            int payingUser = random.nextInt(USERS) + 1;
            if (payingUser != currentUser && random.nextInt(10) == 0) {
                out.println("Пользователь " + payingUser + " оплатил платную услугу");
            }

            currentIndex++;
            if (currentIndex >= userQueue.size()) {
                currentIndex = 0;
            }

            int usersOnline = redis.calculateUsersNumber();
            log(usersOnline);

            redis.cleanOldRecords();

            Thread.sleep(1000);
        }

    }

}






