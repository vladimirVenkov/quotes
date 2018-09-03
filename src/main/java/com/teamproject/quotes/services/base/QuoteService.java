package com.teamproject.quotes.services.base;

import com.teamproject.quotes.Models.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> getAllQuotes();

    void deleteQuote(int id);

    void editQuote(int id, Quote quote);

    void createQuote(Quote quote);

    List<Quote> getAllQuotesSameTopic(String topic);

    List<Quote> getAllQuotesSameAuthor(String author);

}
