package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class BooksFilter
{
  private final List<Book> books;

  public BooksFilter(List<Book> books) {
    this.books = books;

  }

  public List<Book> onlyBooksOlderThan(int years) {
    return books.stream()
      .filter(b -> b.getYear() < LocalDate.now().getYear() - years)
      .collect(Collectors.toList());
  }
}
