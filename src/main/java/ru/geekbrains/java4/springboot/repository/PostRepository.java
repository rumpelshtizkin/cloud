package ru.geekbrains.java4.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.java4.springboot.domain.PostEntity;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
	List<PostEntity> findByTitle(String title);
}
