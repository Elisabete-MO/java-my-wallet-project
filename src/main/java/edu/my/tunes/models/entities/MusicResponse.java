package edu.my.tunes.models.entities;

import java.util.List;

/**
 * MusicResponse entity.
 */
public class MusicResponse {
  private int resultCount;
  private List<Music> results;

  public MusicResponse() {
  }

  public int getResultCount() {
    return resultCount;
  }

  public List<Music> getResults() {
    return results;
  }
}