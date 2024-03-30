package kr1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkListTest {
    private LinkList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkList<>();
    }

    @Test
    void testAdd() {
        list.add(10);
        list.add(20);
        assertEquals(2, list.get(1));
    }

    @Test
    void testRemove() {
        list.add(10);
        list.add(20);
        list.remove(0);
        assertEquals(20, list.get(0));
    }

    @Test
    void testSort() {
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort();
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testGet() {
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.get(0));
        assertEquals(0, list.get(1));
    }

    @Test
    void testAddind() {
        list.add(10);
        list.add(30);
        list.addind(1, 20);
        assertEquals(20, list.get(1));
    }

    @Test
    void testSearch() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(1, list.search(20));
        assertEquals(-1, list.search(40));
    }

    @Test
    void testRemoveValue() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.removevalue(20);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }
}
