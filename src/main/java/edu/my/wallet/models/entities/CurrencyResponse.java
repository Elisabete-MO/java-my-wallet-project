package edu.my.wallet.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * CurrencyResponse entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {

  private List<Currency> currencies;

  public List<Currency> getCurrencies() {
    return currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }
}

