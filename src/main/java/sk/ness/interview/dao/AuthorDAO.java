package sk.ness.interview.dao;

import java.util.List;

import sk.ness.interview.dto.Author;

public interface AuthorDAO {

  /** Returns all available {@link Author}s */
  List<Author> findAll();

}
