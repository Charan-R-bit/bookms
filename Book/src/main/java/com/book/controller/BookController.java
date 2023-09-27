package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookEntity;
import com.book.exception.BookException;
import com.book.repo.Repo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController 
{
	
	@Autowired
	private Repo repo;
	
	@GetMapping("/get")
	public List<BookEntity> get()
	{
		return repo.findAll();
	}

	@GetMapping("/get/{id}")
	public Optional<BookEntity> getbyId(@PathVariable int id) throws BookException
	{
		Optional<BookEntity> view = repo.findById(id);
		if (view.isEmpty()) 
		{
			throw new BookException(id + ":  ID not found!!! ");
		}
		else 
		{
			return repo.findById(id);
	}
	}

	@PostMapping("/post")
	public BookEntity post(@RequestBody  BookEntity bookEntity)
	{
		
		log.info(repo.save(bookEntity)+"  response body");
			return repo.save(bookEntity);
		
	}	
	@PutMapping("/put/{id}")
	public void put(@PathVariable int id, @Valid @RequestBody BookEntity entity) {
		entity.setBookId(entity.getBookId());
		entity.setBookName(entity.getBookName());
		entity.setPrice(entity.getPrice());
		entity.setBookAuthor(entity.getBookAuthor());
		entity.setImgUrl(entity.getImgUrl());
		entity.setFeature(entity.getFeature());
		log.info("Update Complete ");
		repo.save(entity);

	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) throws BookException
	{
		Optional<BookEntity> view = repo.findById(id);
		if (view.isEmpty()) 
		{
			throw new BookException(id + ":  ID not found!!! ");
		}
		else 
		{
			repo.deleteById(id);
			throw new BookException(id + ": is Deleted!!!");
			
	}
	}

}