package com.teamproject.quotes.repositories;

import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlQuoteRepository implements QuoteRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createQuote(Quote quote) {

    }

    @Override
    public List<Quote> getAllQuotes() {
        List<Quote> allQuotes = new ArrayList<>();

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            allQuotes = session.createQuery("from Quote").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Invalid Operation");
        }

        return allQuotes;
    }

    @Override
    public Quote getQuoteById(int id) {
        Quote result = null;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Quote.class, id);
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void editQuote(int id, Quote quote) {

    }

    @Override
    public void deleteQuote(int id) {

    }
}
