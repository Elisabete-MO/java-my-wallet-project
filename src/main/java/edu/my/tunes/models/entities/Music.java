package edu.my.tunes.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response from the ITunes API is a JSON object that contains a list of
 * {@link Music} objects. This class is a POJO that represents the JSON object
 * returned by the ITunes API.
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://developer.apple.com/">ITunes</a>
 *
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Music {

  @JsonProperty("artistId")
  public Integer artistId;
  @JsonProperty("collectionId")
  public Integer collectionId;
  @JsonProperty("trackId")
  public Integer trackId;
  @JsonProperty("artistName")
  public String artistName;
  @JsonProperty("collectionName")
  public String collectionName;
  @JsonProperty("trackName")
  public String trackName;
  @JsonProperty("artworkUrl100")
  public String artworkUrl100;
  @JsonProperty("trackCount")
  public Integer trackCount;

  public Music() {
  }

  public Integer getArtistId() {
    return artistId;
  }

  public Integer getCollectionId() {
    return collectionId;
  }

  public Integer getTrackId() {
    return trackId;
  }

  public String getArtistName() {
    return artistName;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public String getTrackName() {
    return trackName;
  }

  public Integer getTrackCount() {
    return trackCount;
  }

}
