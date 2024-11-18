package org.example;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import java.util.Date;
import static java.lang.System.out;

public class RedisStorage {


    private RedissonClient redisson;

    private RKeys rKeys;

    private final int MAX_USERS = 20;


    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "ONLINE_USERS";


    private static final double RECORD_TTL_SECONDS = 60;

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    // Фиксирует посещение пользователем страницы
    void logPageVisit(int user_id) {
        onlineUsers.add(getTs(), String.valueOf(user_id));
    }


    public int calculateUsersNumber() {
        double currentTime = new Date().getTime() / 1000.0;
        return onlineUsers.count(currentTime - RECORD_TTL_SECONDS, true, currentTime, true);
    }

    void cleanOldRecords() {
        long currentTimeSeconds = new Date().getTime() / 1000;

        long count = onlineUsers.stream().count();

        if (count >= MAX_USERS) {
            onlineUsers.clear();
        } else {
            onlineUsers.removeRangeByScore(0, true, currentTimeSeconds - RECORD_TTL_SECONDS, true);
        }
    }
}




