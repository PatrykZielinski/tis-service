package com.fti.tis.service.endpoint;

import com.fti.tis.service.adapter.XkcdAdapter;
import com.fti.tis.service.adapter.model.Summary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TisEndpointTest {

    @InjectMocks
    private TisEndpoint testee;
    @Mock
    private XkcdAdapter xkcdAdapter;

    @Test
    public void getComicTitle_ComicTitleNull_Empty() {
        //arrange
        when(xkcdAdapter.getSummary()).thenReturn(new Summary(null));
        //act
        final ResponseEntity<String> result = testee.getComicTitle();
        //assert
        assertEquals("the title of today’s XKCD comic was: ", result.getBody());
    }

    @Test
    public void getComicTitle_ComicTitleNotNull_NotEmpty() {
        //arrange
        when(xkcdAdapter.getSummary()).thenReturn(new Summary("hello"));
        //act
        final ResponseEntity<String> result = testee.getComicTitle();
        //assert
        assertEquals("the title of today’s XKCD comic was: hello", result.getBody());
    }
}
