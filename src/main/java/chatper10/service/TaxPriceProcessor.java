package chatper10.service;

import chatper10.model.Price;

public class TaxPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied tax");
    }
}
