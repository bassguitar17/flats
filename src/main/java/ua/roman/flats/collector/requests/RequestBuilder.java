package ua.roman.flats.collector.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RequestBuilder implements IRequestBuilder {

    @Autowired
    private Request request;

    public RequestBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        if(this.request != null) {
            this.request = this.request.reset();
        }
    }

    @Override
    public void setCity(String city) {
        this.request.setCity(city);
    }

    @Override
    public void setMinPrice(BigDecimal minPrice) {

    }

    @Override
    public void setMaxPrice(BigDecimal maxPrice) {

    }

    @Override
    public void setPageNumber(int pageNumber) {

    }

    @Override
    public void setCompleteUrl(String completeUrl) {
        this.request.setCompleteUrl(completeUrl);
    }

    public Request getRequest() {
        final var readyRequest = this.request;
        this.reset();
        return readyRequest;
    }
}
