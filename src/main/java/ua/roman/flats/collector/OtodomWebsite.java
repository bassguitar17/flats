package ua.roman.flats.collector;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class OtodomWebsite implements Website {

    private Document content;

    @Override
    public Document getContent() {
        return this.content;
    }

    @Override
    public void setContent(Document document) {
        this.content = document;
    }
}
