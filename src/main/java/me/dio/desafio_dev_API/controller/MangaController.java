package me.dio.desafio_dev_API.controller;

import me.dio.desafio_dev_API.domain.model.Manga;
import me.dio.desafio_dev_API.domain.service.MangaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    private final MangaService mangaService;

    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @PostMapping
    public ResponseEntity<Manga> create(@RequestBody Manga manga) {
        var createdManga = mangaService.create(manga);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdManga.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdManga);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> findById(@PathVariable Long id) {
        var manga = mangaService.findById(id);
        return ResponseEntity.ok(manga);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Manga> update(@PathVariable Long id, @RequestBody Manga manga) {
        var updatedManga = mangaService.update(id, manga);
        return ResponseEntity.ok(updatedManga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mangaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Manga>> findAll() {
        var allMangas = mangaService.findAll();
        return ResponseEntity.ok(allMangas);
    }

}
