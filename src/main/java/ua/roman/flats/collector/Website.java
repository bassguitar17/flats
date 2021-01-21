package ua.roman.flats.collector;

import org.jsoup.nodes.Document;

public interface Website {
    Document getContent();

    void setContent(Document document);
}
