package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.BookEntity;

@Repository
public interface Repo extends JpaRepository<BookEntity, Integer> {

}
