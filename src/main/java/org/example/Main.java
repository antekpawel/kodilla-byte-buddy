package org.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class Main
{
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
  {
    List<Book> books = BooksGenerator.generate(100);
    BooksFilter booksFilter = new BooksFilter(books);
    List<Book> filteredBooks = booksFilter.onlyBooksOlderThan(20);
    System.out.println(filteredBooks.size());
  }
}