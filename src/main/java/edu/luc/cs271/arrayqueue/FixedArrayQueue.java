package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  private List<E> dataList;

  // TODO why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // DONE TODO
    if (size < capacity) {
      size++;
      rear = (rear + 1) % capacity;
      data[rear] = obj;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public E peek() {
    // DONE TODO
    if (isEmpty()) {
      return null;
    } else {
      return data[front];
    }
  }

  @Override
  public E poll() {
    // DONE TODO
    if (isEmpty()) {
      return null;
    } else {
      E result = data[front];
      front = (front + 1) % capacity;
      size--;
      return result;
    }
  }

  @Override
  public boolean isEmpty() {
    // DONE TODO
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    /* return Arrays.asList();
      }
    }*/
    List<E> dataList = new ArrayList<>();
    while (!isEmpty()) {
      dataList.add(data[front]);
      front = (front + 1) % capacity;
      size--;
    }
    return dataList;
  }
}
