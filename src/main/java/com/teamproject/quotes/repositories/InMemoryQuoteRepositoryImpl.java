package com.teamproject.quotes.repositories;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
public class InMemoryQuoteRepositoryImpl implements QuoteRepository {
    private List<Quote> quotes;



    public InMemoryQuoteRepositoryImpl() {

        /*List<Quote> temp = Arrays.asList(
                new Quote(0,
                        "Marcus Tullius Cicero",
                        "Books",
                        "A room without books is like a body without a soul.",
                        "https://em.wattpad.com/752e206966c0ea1988c3df35d4ba75a6824ae25a/687474703a2f2f686f6f636865722e636f6d2f4d61726375735f54756c6c6975735f43696365726f2f527562656e735f4a756c6975735f4361657361722e6a7067?s=fit&h=360&w=360&q=80"),
                new Quote(1,
                        "Marilyn Monroe",
                        "Life",
                        "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.",
                        "https://media.allure.com/photos/5771afbe2554df47220a768c/3:4/w_767/beauty-trends-blogs-daily-beauty-reporter-2016-06-01-marilyn-monroe-beauty.jpg"),
                new Quote(2,
                        "Oscar Wilde",
                        "Life",
                        "Be yourself; everyone else is already taken.",
                        "https://www.thefamouspeople.com/profiles/images/oscar-wilde-22.jpg"),
                new Quote(3,
                        "Albert Einstein",
                        "Stupidity",
                        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
                        "https://www.thoughtco.com/thmb/7yrvnKCesOgnQZsA67drJOpl7fs=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/portrait-of-albert-einstein-114339176-58b9ce465f9b58af5ca7ee83.jpg"),
                new Quote(4,
                        "Frank Zappa",
                        "Books",
                        "So many books, so little time.",
                        "https://2ab9pu2w8o9xpg6w26xnz04d-wpengine.netdna-ssl.com/wp-content/uploads/2015/12/Frank-Zappa-Press-Image-Crop-5-980x516.jpg"),
                new Quote(5,
                        "Bernard M. Baruch",
                        "Life",
                        "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
                        "https://steemitimages.com/0x0/https://steemitimages.com/DQmXWcj1Jna6EwqUwwkmNWk5hWHwdJ6mR9W5JeYSoZL2REh/bernard-m-baruch.jpg"),
                new Quote(6,
                        "Joro The Rabbit",
                        "Life",
                        "If it is Long, it is going to be Fun!",
                        "https://static.boredpanda.com/blog/wp-content/uploads/2016/10/rabbit-wears-sunglasses-photoshop-battle-original-edit.jpg")
        );
        quotes = new ArrayList<>();
        quotes.addAll(temp);*/
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
//        Quote quoteToEdit = getQuoteById(id);
//        int index = quotes.indexOf(quoteToEdit);
        quotes.set(id, quote); //repository automatically sets Id to be exactly the same as the index of the Quote in the List
        //as there is no deletion of quotes from the list it will work as it is
    }

    @Override
    public void deleteQuote(int id) {
        Quote quoteToDelete = getQuoteById(id);
        if (quoteToDelete == null) {
            return;
        }
        quoteToDelete.setDeleted(true);
        //quotes.remove(quoteToDelete);
    }

    @Override
    public void createQuote(Quote quote) {
        quote.setId(quotes.size());
        quotes.add(quote);
    }
}
