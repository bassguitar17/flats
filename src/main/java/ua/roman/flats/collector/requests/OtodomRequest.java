package ua.roman.flats.collector.requests;

import org.springframework.stereotype.Component;
import ua.roman.flats.collector.ConstantsCollector;

import java.math.BigDecimal;

@Component
public class OtodomRequest implements Request {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void setCity(String city) {
        setUrlMainPartIfNotSet();
        stringBuilder.append(city).append(ConstantsCollector.SLASH);
    }

    @Override
    public void setMinPrice(BigDecimal minPrice) {
        setUrlMainPartIfNotSet();
    }

    @Override
    public void setMaxPrice(BigDecimal maxPrice) {
        setUrlMainPartIfNotSet();
    }

    @Override
    public void setPageNumber(int pageNumber) {
        setUrlMainPartIfNotSet();
        stringBuilder.append(ConstantsCollector.QUESTION_MARK).append(ConstantsCollector.PAGE).append(ConstantsCollector.EQUAL_SIGN).append(pageNumber);
    }

    @Override
    public void setCompleteUrl(String completeUrl) {
        stringBuilder.append(completeUrl);
    }

    @Override
    public String getCompleteUrl() throws Exception {
        if (stringBuilder.isEmpty()) {
            throw new Exception("The url is empty");
        }
        return stringBuilder.toString();
    }

    @Override
    public Request reset() {
        return new OtodomRequest();
    }

    private void setUrlMainPartIfNotSet() {
        if (stringBuilder.isEmpty()) {
            stringBuilder.insert(ConstantsCollector.ZERO, ConstantsCollector.OTODOM_GET_URL_MAIN_PART);
        }
    }

}
