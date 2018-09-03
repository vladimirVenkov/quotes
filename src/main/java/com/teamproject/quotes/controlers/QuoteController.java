package com.teamproject.quotes.controlers;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.services.base.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {
    private QuoteService service;

    @Autowired
    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return service.getAllQuotes();
    }

    //TODO other methods
}
