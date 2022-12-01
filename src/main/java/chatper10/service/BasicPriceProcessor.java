package chatper10.service;


import chatper10.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return price;
    }
}

