package chatper10;

import chatper10.model.Price;
import chatper10.service.BasicPriceProcessor;
import chatper10.service.DiscountPriceProcessor;
import chatper10.service.PriceProcessor;
import chatper10.service.TaxPriceProcessor;

public class DecoratorPatternPractice {

    public static void main(String[] args) {
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPricePricessor = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor);

        Price processedPrice = decoratedPricePricessor.process(unprocessedPrice);

        System.out.println("processedPrice.getPrice() = " + processedPrice.getPrice());

        PriceProcessor decoratedPricePricessor2 = basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply anoter procedure"));

        Price processedPrice2 = decoratedPricePricessor2.process(unprocessedPrice);
        System.out.println("processedPrice.getPrice() = " + processedPrice2.getPrice());
    }
}
