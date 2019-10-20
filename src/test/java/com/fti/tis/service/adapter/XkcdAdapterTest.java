package com.fti.tis.service.adapter;

import com.fti.tis.service.adapter.model.Summary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class XkcdAdapterTest {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private XkcdAdapter testee;

    @Test
    public void getSummary_ServiceReturnsTitle_Title() {
        //arrange
        final Summary expectedSummary = new Summary("hello");
        when(restTemplate.getForObject("/info.0.json", Summary.class)).thenReturn(expectedSummary);
        //act
        final Summary result = testee.getSummary();
        //assert
        assertEquals(expectedSummary.getTitle(), result.getTitle());
    }
}
