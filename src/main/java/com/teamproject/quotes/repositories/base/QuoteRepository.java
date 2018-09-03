package com.teamproject.quotes.repositories.base;

import com.teamproject.quotes.Models.Quote;

import java.util.List;

public interface QuoteRepository {

    List<Quote> getAllQuotes();

   // void deleteQuote(int id);

    void editQuote(int id, Quote quote);

    void createQuote(Quote quote);


}
