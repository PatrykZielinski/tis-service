package com.fti.tis.service.endpoint;

import com.fti.tis.service.adapter.XkcdAdapter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tis")
public class TisEndpoint {

    private final XkcdAdapter xkcdAdapter;

    @Autowired
    public TisEndpoint(final XkcdAdapter xkcdAdapter) {
        Assert.notNull(xkcdAdapter, "XkcdAdapter can't be null");
        this.xkcdAdapter = xkcdAdapter;
    }

    @RequestMapping(path = "/comic/title", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getComicTitle() {
        final String summaryTitle = StringUtils.defaultString(xkcdAdapter.getSummary().getTitle());
        return new ResponseEntity<>(String.format("the title of today’s XKCD comic was: %s",
                summaryTitle), //
                HttpStatus.OK);
    }
}
