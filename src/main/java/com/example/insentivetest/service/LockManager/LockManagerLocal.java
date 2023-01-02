package com.example.insentivetest.service.LockManager;

public interface LockManagerLocal {
    void lock(String lockName);
    void unlock(String lockName);
    Boolean tryLock(String lockName);
}
