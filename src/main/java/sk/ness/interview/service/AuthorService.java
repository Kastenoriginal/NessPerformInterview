package sk.ness.interview.service;

import java.util.List;

import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;

/**
 * Service should handle all author related manipulation.
 *
 * @author michal.kmetka
 *
 */
public interface AuthorService {

  /** Returns all available {@link Author Authors} */
  List<Author> findAll();

  /** Return all available {@link AuthorStats} */
  List<AuthorStats> fetchAllAuthorStats();
}
