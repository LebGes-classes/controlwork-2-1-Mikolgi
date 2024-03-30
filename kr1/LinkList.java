package kr1;

    public class LinkList<T> implements Lists<T> {
        private class Node {
            T value;
            Node next;
            Node prev;

            Node(T value) {
                this.value = value;
            }
        }

        private Node head;
        private Node tail;
        protected int size;

        public void add(T value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of range");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == head) {
                head = current.next;
            }
            if (current == tail) {
                tail = current.prev;
            }
            size--;
        }

        public void sort() {
            if (size <= 1) {
                return; // для пустого списка или списка из одного элемента сортировка не требуется
            }

            Node current = head.next;

            while (current != null) {
                T value = current.value;
                Node previous = current.prev;

                // Переместить узел current в его правильное место в отсортированной части списка
                while (previous != null && ((Comparable<T>) previous.value).compareTo(value) > 0) {
                    previous.next.value = previous.value; // сдвигаем значение вперед
                    previous = previous.prev;
                }

                if (previous == null) {
                    head.value = value;
                } else {
                    previous.next.value = value;
                }

                current = current.next;
            }
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of range");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        public void print() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public void addind(int index, T value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index is out of range");
            }
            if (index == size) {
                add(value);
            } else {
                Node newNode = new Node(value);
                if (index == 0) {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                } else {
                    Node current = head;
                    for (int i = 0; i < index - 1; i++) {
                        current = current.next;
                    }
                    newNode.next = current.next;
                    newNode.prev = current;
                    current.next.prev = newNode;
                    current.next = newNode;
                }
                size++;
            }
        }

        public int search(T value) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (current.value.equals(value)) {
                    return i;
                }
                current = current.next;
            }
            return -1; // Значение не найдено
        }

        public void removevalue(T value) {
            Node current = head;
            while (current != null) {
                if (current.value.equals(value)) {
                    if (current == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (current == tail) {
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    size--;
                    return;
                }
                current = current.next;
            }
        }
    }

