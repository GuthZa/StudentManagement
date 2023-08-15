package com.guthza.studentmanagement.repositories;


public interface ObjectRepository<T> {

    public void store(T t);

    public T retrieve(Long id);

    public T search(String name);

    public T delete(Long id);

}
