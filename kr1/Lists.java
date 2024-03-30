package kr1;

public interface Lists<T> {
    void add(T value);
    void remove(int index);
    void print();
    void sort();
    T get(int index);
    void clear();
    void addind(int index, T value);
    int search(T value);
    void removevalue(T value);
}
