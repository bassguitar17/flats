package ua.roman.flats.collector.helpers;

import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import ua.roman.flats.collector.ConstantsCollector;
import ua.roman.flats.collector.Website;
import ua.roman.flats.collector.exceptions.WebsiteException;

import java.util.List;
import java.util.stream.Collectors;

public class WebsiteHelper {

    static public int getPagesCount(Website website) throws WebsiteException {
        Document document = website.getContent();
        List<TextNode> pagesNumbers;

        try {
            pagesNumbers = getPagesNumbers(document);
        } catch (Exception e) {
            throw new WebsiteException("Page number is not accessible on this website or have not been found. " + e);
        }
        return getLastPageNumber(pagesNumbers);
    }

    private static List<TextNode> getPagesNumbers(Document document) {
        return document.getElementsByAttributeValue("class", "pager").select("a").textNodes();
    }

    private static int getLastPageNumber(List<TextNode> pagesNumbers) {
        return Integer.parseInt(pagesNumbers.get(pagesNumbers.size() - 1).getWholeText());
    }

    static public List<String> getAdvertisementsUrls(Website website) throws WebsiteException {
        Elements advertisementsHtml;
        List<String> flatAdvertisementsURLsWithDuplicates = null;
        try {
            advertisementsHtml = retrieveAdvertisementsHtmlFromDocument(website.getContent());
            flatAdvertisementsURLsWithDuplicates = retrieveAdvertisementsUrlsFromHtmls(advertisementsHtml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return removeDuplicates(flatAdvertisementsURLsWithDuplicates);
    }


    private static Elements retrieveAdvertisementsHtmlFromDocument(Document doc) {
        return doc.getElementsByAttributeValueContaining(ConstantsCollector.HREF, ConstantsCollector.EVERY_ADVERTISEMENT_URL_START);
    }

    private static List<String> retrieveAdvertisementsUrlsFromHtmls(Elements advertisementsHtml) {
        return advertisementsHtml.eachAttr(ConstantsCollector.HREF);
    }

    private static List<String> removeDuplicates(List<String> elementsContainingFlatAdvertisements) {
        if (elementsContainingFlatAdvertisements != null) {
            return elementsContainingFlatAdvertisements.stream().distinct().collect(Collectors.toList());
        } else {
            return null;
        }
    }

    static public JSONObject getJsonAdvertisementData(Website website) {
        var htmlString = website.getContent().getElementById(ConstantsCollector.__NEXT_DATA__).html();//string z html
        var redundantJSON = new JSONObject(htmlString);//json ze stringa
        return redundantJSON.getJSONObject(ConstantsCollector.PROPS).getJSONObject(ConstantsCollector.PAGE_PROPS).getJSONObject(ConstantsCollector.AD);
    }
}
