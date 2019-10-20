package com.fti.tis.service.adapter;

import com.fti.tis.service.Application;
import com.fti.tis.service.adapter.model.Summary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class XkcdAdapterIntegrationTest {

    @Autowired
    private XkcdAdapter testee;

    @Test
    public void getSummary_ServiceReturnsCorrectAnswer_TitleNotNull() {
        //act
        final Summary result = testee.getSummary();
        //assert
        assertNotNull(result);
        assertNotNull(result.getTitle(), "Title can't be null");
    }
}
