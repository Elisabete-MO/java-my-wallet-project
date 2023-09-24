package edu.my.tunes.services.interfaces;

import edu.my.tunes.models.entities.Music;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "itunes", url = "https://itunes.apple.com")
public interface MusicApiService {

  @GetMapping("/search?term={artistNameURL}&entity=album&limit=25")
  public String getAlbums(@PathVariable("artistNameURL") String artistNameURL);

  @GetMapping("/lookup?id={id}&entity=song")
  public Music getAlbumSongs(@PathVariable("id") String id);
}