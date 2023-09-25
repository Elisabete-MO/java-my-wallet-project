package edu.my.wallet.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response from the API is a JSON object that contains a list of
 * {@link Currency} objects. This class is a POJO that represents the JSON
 * object returned by the currencies API.
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://docs.awesomeapi.com.br/api-de-moedas">API de Cotações</a>
 *
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

  @JsonProperty("code")
  public String code;
  @JsonProperty("name")
  public String name;
  @JsonProperty("ask")
  public String ask;
  @JsonProperty("timestamp")
  public String timestamp;
  @JsonProperty("create_date")
  public String createDate;

  public void setCode(String code) {
    this.code = code;
  }
}
