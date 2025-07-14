package me.dio.desafio_dev_API.domain.repository;

import me.dio.desafio_dev_API.domain.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Long> {


}
