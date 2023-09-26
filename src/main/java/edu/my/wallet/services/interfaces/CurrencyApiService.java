package edu.my.wallet.services.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * CurrencyApiService interface for FeignClient to consume the AwesomeAPI.
 */
@FeignClient(name = "awesomeapi", url = "https://economia.awesomeapi.com.br/json")
public interface CurrencyApiService {

  @GetMapping("/all")
  public ResponseEntity<String> getCurrencies();

  @GetMapping("/{currency}-BRL")
  public ResponseEntity<String> getOneCurrency(@PathVariable("currency") String currency);
}