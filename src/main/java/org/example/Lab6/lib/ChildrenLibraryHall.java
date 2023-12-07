package org.example.Lab6.lib;


import org.example.Lab6.data.ChildrenBook;
import org.example.Lab6.exception.BookIndexOutOfBoundsException;
import org.example.Lab6.exception.InvalidBookPriceException;
import org.example.Lab6.inter.IBook;
import org.example.Lab6.inter.IHall;
import org.example.Lab6.list.MyLinkedList;

import java.util.Objects;

public class ChildrenLibraryHall implements IHall {
    private String nameHall;
    private MyLinkedList<IBook> bookList;
    private int countHall;
    private int countBook;

    public ChildrenLibraryHall(MyLinkedList<IBook> bookList, String nameHall) {
        this.bookList = bookList;
        this.nameHall = nameHall;
        countBook = bookList.size();
    }
    public ChildrenLibraryHall(int numberHall, String nameHall) {
        this.countHall = numberHall;
        this.nameHall = nameHall;
        bookList = new MyLinkedList<>();
        for (int i = 0; i < numberHall; i++) {
            bookList.addByIndex(i, (IBook) new ChildrenBook("?",0));

        }
        countBook = bookList.size();
    }


    @Override
    public void showAllBookInHall() {
        if (bookList.isEmpty()) {
            throw new org.example.Lab5.exception.InvalidBookPriceException("Пусто");
        }
        for(int i = 0;i<bookList.size();i++){
            System.out.println("Название книги: "+" "+ bookList.getByIndex(i));
        }
    }

    @Override
    public double getAllPriceFromBook() {
        if (bookList.isEmpty()) {
            throw new InvalidBookPriceException("Пусто");
        }
        double total = 0;
        for(int i = 0; i < countBook-1; i++){
            IBook currentBook = (IBook) bookList.getByIndex(i).data;
            total += currentBook.getPrice(); // Assuming there's a getPrice() method in ScientificBook
        }
        return total;
    }

    @Override
    public IBook getBookByNumber(int index) {
        if (index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        IBook currentBook = (IBook) bookList.getByIndex(index).data;
        return currentBook;
    }

    @Override
    public void changeNumberOfBookByNumber(int index, IBook book) {

        if ((index < 0 || index > countBook) || book==null) {
            throw new org.example.Lab5.exception.BookIndexOutOfBoundsException("Неверный индекс или объект равен null");
        }
        bookList.deleteByIndex(index);
        bookList.addByIndex(index,book);
    }

    @Override
    public void addNumberOfBookByNumber(int index, IBook book) {
        if ((index < 0 || index > countBook)||book==null) {
            throw new org.example.Lab5.exception.BookIndexOutOfBoundsException("Неверный индекс или объект равен null");
        }
        bookList.addByIndex(index,book);
    }

    @Override
    public void deleteBookByNumber(int index) {
        if (index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException("Неверный индекс");
        }
        bookList.deleteByIndex(index);

    }

    public double getBookWithBigPrice(){

        MyLinkedList<IBook> data = new MyLinkedList<>();
        if (bookList.isEmpty()) {
            throw new InvalidBookPriceException("Массив книг пуст");
        }
        double maxPrice = Double.MIN_VALUE;
        for (int i = 0; i < countBook; i++) {
            data.addByIndex(i, (IBook) bookList.getByIndex(i).data);
        }
        for (int i = 0; i < countBook-1; i++) {
            IBook book = (IBook) bookList.getByIndex(i).data;
            if(book.getPrice()<maxPrice){
                maxPrice = book.getPrice();
            }
        }
        return maxPrice;
    }

    @Override
    public int getSize() {
        return countHall;
    }

    @Override
    public int getCountBook() {
        return countBook;
    }

    @Override
    public String getName() {
        return nameHall;
    }

    @Override
    public MyLinkedList<IBook> getHall() {
        return bookList;
    }

    @Override
    public IHall clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildrenLibraryHall that)) return false;
        return countBook == that.countBook && Objects.equals(nameHall, that.nameHall) && Objects.equals(bookList, that.bookList);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + countBook;

        for (int i = 0; i < bookList.size(); i++) {
            IBook book = (IBook) bookList.getByIndex(i).data;
            result = prime * result + (book == null ? 0 : book.hashCode());
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Детский зал библиотеки: \n");
        sb.append("Название зала: '").append(nameHall).append("'\n");
        sb.append("Количество книг: ").append(countBook).append("\n");
        sb.append("Информация о книгах в зале:\n");

        for (int i = 0; i < countBook; i++) {
            sb.append("Книга ").append(i + 1).append(": ").append(bookList.getByIndex(i).data.toString()).append("\n");
        }
        return sb.toString();
    }

}



