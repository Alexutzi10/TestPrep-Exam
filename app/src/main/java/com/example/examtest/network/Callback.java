package com.example.examtest.network;

public interface Callback<R> {
    void runResultOnUIThread(R result);
}