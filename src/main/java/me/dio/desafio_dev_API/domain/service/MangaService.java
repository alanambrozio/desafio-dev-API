package me.dio.desafio_dev_API.domain.service;

import me.dio.desafio_dev_API.domain.model.Manga;
import org.springframework.stereotype.Service;

public interface MangaService {
    Manga findById(Long id);

    Manga create(Manga manga);

    Manga update(Long id, Manga manga);

    void delete(Long id);

    Iterable<Manga> findAll();

}
