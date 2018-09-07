package com.teamproject.quotes.controlers;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.services.base.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    private QuoteService service;

    @Autowired
    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Quote> getAllQuotes() {
        return service.getAllQuotes();
    }

    @GetMapping("/{id}")
    public Quote qetQuoteById(@PathVariable int id){
        return service.getQuoteById(id);
    }

    @PostMapping("/new")
    public void createQuote(@Valid @RequestBody Quote quote){
        service.createQuote(quote);
    }

    @PutMapping("/edit/{id}")
    public void editQuote(@Valid @RequestBody Quote quote, @PathVariable int id){
        if (id != quote.getId()) {
            quote.setId(id);
        }
        service.editQuote(id, quote);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuote(@PathVariable int id) {
        service.deleteQuote(id);
    }

    //TODO other methods
}
