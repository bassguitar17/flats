package ua.roman.flats.collector.requests;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.roman.flats.collector.Website;

@Component
public class RequestManager {

    @Autowired
    private Website website;

    public Website sendGetRequest(Request request) {

        try {
            this.website.setContent(Jsoup.connect(request.getCompleteUrl()).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return website;
    }
}
