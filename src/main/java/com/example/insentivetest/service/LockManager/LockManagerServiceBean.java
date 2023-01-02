package com.example.insentivetest.service.LockManager;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class LockManagerServiceBean implements LockManagerLocal {


        private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

        @Override
        public void lock(String key) {
            ReentrantLock lock = new ReentrantLock();
            locks.putIfAbsent(key, lock);
            lock.lock();
        }

        @Override
        public Boolean tryLock(String key) {
            ReentrantLock lock = new ReentrantLock();
            locks.putIfAbsent(key, lock);
            try {
                return lock.tryLock(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return false;
            }
        }

        @Override
        public void unlock(String key) {
            ReentrantLock lock = locks.get(key);
            if (lock != null && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


