package ua.roman.flats.collector.requests;

import java.math.BigDecimal;

public interface Request {

    void setCity(String city);

    void setMinPrice(BigDecimal minPrice);

    void setMaxPrice(BigDecimal maxPrice);

    void setPageNumber(int pageNumber);

    void setCompleteUrl(String completeUrl);

    String getCompleteUrl() throws Exception;

    Request reset();

}
