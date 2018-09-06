package com.teamproject.quotes.repositories.base;

import com.teamproject.quotes.Models.Quote;

import java.util.List;

public interface QuoteRepository {

    void createQuote(Quote quote);

    List<Quote> getAllQuotes();

    Quote getQuoteById(int id);

    void editQuote(int id, Quote quote);

    void deleteQuote(int id);

}
