package org.example.Lab6.inter;

import org.example.Lab6.list.MyLinkedList;

public interface IHall extends Cloneable{
    void showAllBookInHall();
    double getAllPriceFromBook();
    IBook getBookByNumber(int index);
    void changeNumberOfBookByNumber(int index, IBook book);
    void addNumberOfBookByNumber(int index, IBook book);
    double getBookWithBigPrice();
    void deleteBookByNumber(int index);
    int getSize();
    int getCountBook();
    String getName();
    MyLinkedList<IBook> getHall();
    IHall clone() throws CloneNotSupportedException;
}
