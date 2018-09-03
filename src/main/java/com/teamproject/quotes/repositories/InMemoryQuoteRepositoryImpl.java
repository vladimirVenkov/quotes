package com.teamproject.quotes.repositories;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryQuoteRepositoryImpl implements QuoteRepository {
    private List<Quote> quotes;

    public InMemoryQuoteRepositoryImpl() {
        quotes = new ArrayList<>();
        Quote first = new Quote("Dr. Seuss", "Life",
                "Don't cry because it's over, smile because it happened.");
        first.setId(0);
        quotes.add(first);
        Quote second = new Quote( "Oscar Wilde", "Life",
                "Be yourself; everyone else is already taken.");
        second.setId(1);
        quotes.add(second);
        Quote third = new Quote( "Albert Einstein", "Stupidity",
                "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.");
        third.setId(2);
        quotes.add(third);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quotes.stream()
                .filter(x -> !x.getIsDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public void editQuote(int id, Quote quote) {
        quotes.set(id, quote);
    }

    @Override
    public void createQuote(Quote quote) {
        quote.setId(quotes.size());
        quotes.add(quote);
    }
}
