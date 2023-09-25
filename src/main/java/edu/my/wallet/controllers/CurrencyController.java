package edu.my.wallet.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import edu.my.wallet.models.entities.Currency;
import edu.my.wallet.models.entities.CurrencyResponse;
import edu.my.wallet.services.interfaces.CurrencyApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Currency entity.
 */
@RestController
@RequestMapping(value = "/wallet")
public class CurrencyController {
  @Autowired
  private CurrencyApiService currencyApiService;

@GetMapping("/")
  public ResponseEntity<List<Currency>> getCurrencies() {
    ResponseEntity<String> response = currencyApiService.getCurrencies();

  if (response.getStatusCode() == HttpStatus.OK) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      JsonNode root = objectMapper.readTree(response.getBody());
      List<Currency> currencyList = new ArrayList<>();

      Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
      while (fields.hasNext()) {
        Map.Entry<String, JsonNode> entry = fields.next();
        String currencyCode = entry.getKey();
        JsonNode currencyNode = entry.getValue();

        Currency currency = objectMapper.treeToValue(currencyNode, Currency.class);
        currency.setCode(currencyCode);
        currencyList.add(currency);
      }
      return ResponseEntity.ok(currencyList);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  } else {
    return ResponseEntity.status(response.getStatusCode()).build();
  }
}

  @GetMapping("/{currency}-BRL")
  public ResponseEntity<Currency> getCurrency(@PathVariable("currency") String currency) {
    ResponseEntity<String> response = currencyApiService.getOneCurrency(currency);

    if (response.getStatusCode() == HttpStatus.OK) {
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        List<Currency> currencyList = objectMapper.readValue(response.getBody(),
            new TypeReference<List<Currency>>() {});
        return ResponseEntity.ok(currencyList.get(0));
      } catch (JsonProcessingException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    } else {
      return ResponseEntity.status(response.getStatusCode()).build();
    }
  }
}
