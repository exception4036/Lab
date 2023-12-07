package org.example.Lab6;

import org.example.Lab6.data.ChildrenBook;
import org.example.Lab6.inter.IBook;
import org.example.Lab6.inter.IHall;
import org.example.Lab6.lib.ChildrenLibraryHall;
import org.example.Lab6.lib.LibraryChildren;

public class Main {
    public static void main(String[] args) {
        // Создание массива с количеством книг в каждом зале
        int[] countBooks = { 5, 3, 4 }; // Например, 3 зала с 5, 3 и 4 книгами соответственно

        // Создание объекта LibraryChildren с использованием конструктора, принимающего количество залов и массив количества книг
        LibraryChildren library = new LibraryChildren(countBooks.length, countBooks);

        // Демонстрация методов класса LibraryChildren
        System.out.println("Количество залов: " + library.getNumberOfHalls());
        System.out.println("Общее количество книг: " + library.numberOfBook());
        System.out.println("Общая стоимость всех книг: " + library.getAllPriceFromBook());

        // Вывод информации о книгах в каждом зале
        library.showAllNameOfHallByCount();

        // Изменение зала по индексу
        IHall newHall = new ChildrenLibraryHall(10, "New Hall");
        library.changeHallOnDifferentByNumber(1, newHall); // Изменение второго зала

        // Добавление книги во все залы
        IBook newBook = (IBook) new ChildrenBook("Steve", "Fack", 123.1, 1999,14);
        library.addBookByNumber(1, newBook); // Добавление новой книги во все залы

        // Удаление книги по номеру
        library.deleteBookByNumber(2); // Удаление второй книги из всех залов

        // Вывод наилучшей книги
        System.out.println("Наилучшая книга: " + library.getBestBook());

        // Клонирование библиотеки
        try {
            LibraryChildren clonedLibrary = (LibraryChildren) library.clone();
            System.out.println("Клонированная библиотека: \n" + clonedLibrary);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Работа с hashCode
        int hashCode = library.hashCode();
        System.out.println("Хэш-код библиотеки: " + hashCode);

        // Работа с equals
        LibraryChildren otherLibrary = new LibraryChildren(countBooks.length, countBooks);
        System.out.println("Сравнение библиотек: " + library.equals(otherLibrary));
    }
    }

