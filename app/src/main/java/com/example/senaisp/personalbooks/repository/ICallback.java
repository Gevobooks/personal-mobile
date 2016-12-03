package com.example.senaisp.personalbooks.repository;

/**
 * Created by tancredofernando on 03/12/16.
 */

public interface ICallback<T>
{
    void Callback(T back, Exception error);
}
