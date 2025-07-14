package me.dio.desafio_dev_API.domain.service.impl;

import me.dio.desafio_dev_API.domain.model.Manga;
import me.dio.desafio_dev_API.domain.repository.MangaRepository;
import me.dio.desafio_dev_API.domain.service.MangaService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaRepository mangaRepository;

    public MangaServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    public Manga findById(Long id) {
        return mangaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Manga create(Manga mangaCreator) {
        if (mangaCreator.getId() != null && mangaRepository.existsById(mangaCreator.getId())) {
            throw new IllegalArgumentException("Manga with this ID already exists.");
        }
        return mangaRepository.save(mangaCreator);
    }

    @Override
    public Manga update(Long id, Manga manga) {
    if (!mangaRepository.existsById(id)) {
        throw new NoSuchElementException("Manga with ID " + id + " does not exist.");
    }
        return mangaRepository.save(manga);
    }

    @Override
    public void delete(Long id) {
        if (!mangaRepository.existsById(id)) {
            throw new NoSuchElementException("Manga with ID " + id + " does not exist.");
        }
        mangaRepository.deleteById(id);

    }

    @Override
    public Iterable<Manga> findAll() {
    if (mangaRepository.count() > 0) {
            return mangaRepository.findAll();
        }
        return null;
    }
}
