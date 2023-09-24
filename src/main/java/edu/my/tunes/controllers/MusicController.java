package edu.my.tunes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import edu.my.tunes.models.entities.Music;
import edu.my.tunes.models.entities.MusicResponse;
import edu.my.tunes.services.interfaces.MusicApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for the Music entity.
 * This {@link RestController} represents our <b>Facade</b>, because it
 * abstracts all complexity of integrations (H2 Database and ITunes API)
 * in a simple and cohesive interface (REST API).
 */
@RestController
@RequestMapping(value = "/search")
public class MusicController {
  @Autowired
  private MusicApiService musicApiService;

@GetMapping("/{artistNameURL}")
  public ResponseEntity<List<Music>> getAlbums(@PathVariable("artistNameURL") String artistNameURL) {
    String response = musicApiService.getAlbums(artistNameURL);
    ObjectMapper objectMapper = new ObjectMapper();

  try {
    MusicResponse musicResponse = objectMapper.readValue(response, MusicResponse.class);
    List<Music> musicList = musicResponse.getResults();
    return ResponseEntity.ok(musicList);
  } catch (JsonProcessingException e) {
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}

  @GetMapping("/song/{id}")
  public ResponseEntity<Music> getAlbumSongs(@PathVariable("id") String id) {
    return ResponseEntity.ok(musicApiService.getAlbumSongs(id));
  }
}
