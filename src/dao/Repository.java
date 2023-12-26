package dao;

import java.util.List;

public interface Repository <T>{
    public int add(T t);
    public int update(T t);
    public int delete(T t);
    public List<T> list();

    public T get(int id);
}
