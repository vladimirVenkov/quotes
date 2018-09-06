package com.teamproject.quotes.repositories;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryQuoteRepositoryImpl implements QuoteRepository {
    private List<Quote> quotes;

    public InMemoryQuoteRepositoryImpl() {
//        quotes = new ArrayList<>();
//        Quote first = new Quote("Dr. Seuss", "Life",
//                "Don't cry because it's over, smile because it happened.");
//        first.setId(0);
//        quotes.add(first);
//        Quote second = new Quote( "Oscar Wilde", "Life",
//                "Be yourself; everyone else is already taken.");
//        second.setId(1);
//        quotes.add(second);
//        Quote third = new Quote( "Albert Einstein", "Stupidity",
//                "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.");
//        third.setId(2);
//        quotes.add(third);
        quotes = Arrays.asList(
                new Quote(0,
                        "Marcus Tullius Cicero",
                        "Books",
                        "A room without books is like a body without a soul.",
                        "https://upload.wikimedia.org/wikipedia/en/thumb/2/29/Barry_Allen_Flash_Vol_4_30.png/250px-Barry_Allen_Flash_Vol_4_30.png"),
                new Quote(1,
                        "Marilyn Monroe",
                        "Life",
                        "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote(2,
                        "Oscar Wilde",
                        "Life",
                        "Be yourself; everyone else is already taken.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote(3,
                        "Albert Einstein",
                        "Stupidity",
                        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8"),
                new Quote(4,
                        "Frank Zappa",
                        "Books",
                        "So many books, so little time.",
                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8")
//                new Quote(5,
//                        "Bernard M. Baruch",
//                        "Life",
//                        "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
//                        "https://firebasestorage.googleapis.com/v0/b/test-project-5944f.appspot.com/o/avengers_infinity_war.jpg?alt=media&token=a32d7f68-eeba-40d0-bcf3-8f0dbfe8d3b8")
        );
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quotes.stream()
                .filter(x -> !x.getIsDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public Quote getQuoteById(int id) {
        return quotes.stream().filter(quote -> quote.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void editQuote(int id, Quote quote) {
        Quote quoteToEdit = getQuote(id);
        int index = quotes.indexOf(quoteToEdit);
        quotes.set(index, quote);
    }

    @Override
    public void deleteQuote(int id) {
        Quote quoteToDelete = getQuote(id);
        quotes.remove(quoteToDelete);
    }

    @Override
    public void createQuote(Quote quote) {
        quote.setId(quotes.size());
        quotes.add(quote);
    }

    private Quote getQuote(int id){
        return quotes.stream().filter(quote -> quote.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
