package com.teamproject.quotes;

import com.teamproject.quotes.Models.Author;
import com.teamproject.quotes.Models.Quote;
import com.teamproject.quotes.Models.Topic;
import com.teamproject.quotes.repositories.base.QuoteRepository;
import com.teamproject.quotes.services.QuoteServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuoteServiceImplTests {

    @Mock
    QuoteRepository mockRepository;

    @InjectMocks
    QuoteServiceImpl service;

    Author defaultAuthor = new Author(1, "Joro The Rabbit");

    Topic defaultTopic = new Topic(1, "Life");

    Quote firstTestInput = new Quote(
            1, defaultAuthor, defaultTopic, "If it is fast it is good", "url//"
    );
    Quote secondTestInput = new Quote(
            1, defaultAuthor, defaultTopic, "If it is fast it is good", "url//"
    );
    Quote tirdTestInput = new Quote(
            1, defaultAuthor, defaultTopic, "If it is fast it is good", "url//"
    );

    List<Quote> defaultListOfQuotesInput = Arrays.asList(firstTestInput, secondTestInput, tirdTestInput);

    @Test
    public void getAllQuotes_Should_ReturnAllQuotes_WhenCalled() {
        //Arrange
        when(mockRepository.getAllQuotes())
                .thenReturn(defaultListOfQuotesInput);

        //Act
        List<Quote> result = service.getAllQuotes();

        //Assert
        Assert.assertEquals(result.size(), defaultListOfQuotesInput.size());
    }

    @Test
    public void getQuoteById_Should_ReturnFirstElement_WhenCalledWithId_1() {
        //Arrange
        when(mockRepository.getQuoteById(1))
                .thenReturn(defaultListOfQuotesInput.get(0));

        //Act
        Quote result = service.getQuoteById(1);

        //Assert
       // Assert.assertEquals();
    }
    @Test
    public void createQuote_Should_ReturnListWithAddedElement() {

        service.createQuote(firstTestInput);

        verify(mockRepository).createQuote(firstTestInput);

        verify(mockRepository, times(1)).createQuote(firstTestInput);
    }

}
