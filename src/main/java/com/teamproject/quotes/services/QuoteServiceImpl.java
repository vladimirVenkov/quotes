package com.teamproject.quotes.services;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import com.teamproject.quotes.services.base.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository repository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Quote> getAllQuotes() {
        return repository.getAllQuotes();
    }

    @Override
    public void deleteQuote(int id) {
        Quote toDelete = repository.getAllQuotes().stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        if (toDelete.equals(null)) {
            return;
        }
        toDelete.setDeleted(true);

    }

    @Override
    public void editQuote(int id, Quote quote) {
    repository.editQuote(id, quote);
    }

    @Override
    public void createQuote(Quote quote) {
    repository.createQuote(quote);
    }

    //TODO future implementation
    @Override
    public List<Quote> getAllQuotesSameTopic(String topic) {
        return null;
    }

    //TODO future implementation
    @Override
    public List<Quote> getAllQuotesSameAuthor(String author) {
        return null;
    }
}
