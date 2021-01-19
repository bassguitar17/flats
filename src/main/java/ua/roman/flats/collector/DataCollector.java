package ua.roman.flats.collector;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ua.roman.flats.domain.Advertisement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class DataCollector {
    public List<Advertisement> collectData() {
        var advertisements = new ArrayList<Advertisement>();
        try {
            var doc = Jsoup.connect(ConstantsCollector.GET_URL).get();
            var flatAdvertisementsURLs = retrieveAdvertisementsUrls(doc);

            for(String url : flatAdvertisementsURLs){
                var htmlDocument = Jsoup.connect(url).get();
                var htmlString = htmlDocument.getElementById(ConstantsCollector.__NEXT_DATA__).html();
                var redundantJSON = new JSONObject(htmlString);
                var json = redundantJSON.getJSONObject(ConstantsCollector.PROPS).getJSONObject(ConstantsCollector.PAGE_PROPS).getJSONObject(ConstantsCollector.AD);

                var advertisement = new Advertisement();
                var advNumber = json.getLong(ConstantsCollector.ID);
                var timeStamp = System.currentTimeMillis();
                advertisement.setNumber(Long.toString(advNumber));
                advertisement.setTimestampAddingToDatabase(new Date(timeStamp));
                advertisements.add(advertisement);
            }

            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return advertisements;
    }

    private List<String> retrieveAdvertisementsUrls(Document doc) {
        var advertisementsHtml = retrieveAdvertisementsHtmlFromDocument(doc);
        var flatAdvertisementsURLsWithDuplicates = retrieveAdvertisementsUrlsFromHtmls(advertisementsHtml);
        return removeDuplicates(flatAdvertisementsURLsWithDuplicates);
    }

    private Elements retrieveAdvertisementsHtmlFromDocument(Document doc) {
        return doc.getElementsByAttributeValueContaining(ConstantsCollector.HREF, ConstantsCollector.EVERY_ADVERTISEMENT_URL_START);
    }

    private List<String> retrieveAdvertisementsUrlsFromHtmls(Elements advertisementsHtml) {
        return advertisementsHtml.eachAttr(ConstantsCollector.HREF);
    }

    private List<String> removeDuplicates(List<String> elementsContainingFlatAdvertisements) {
        return elementsContainingFlatAdvertisements.stream().distinct().collect(Collectors.toList());
    }
}
