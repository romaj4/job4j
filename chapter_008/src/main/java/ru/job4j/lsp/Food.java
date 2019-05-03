package ru.job4j.lsp;


/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Food {

    private final String name;

    private final long createDate;

    private final long expiryDate;

    private final long currentDate;

    private final int price;

    private int discount;

    public Food(String name, long createDate, long expiryDate, int price) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.currentDate = System.currentTimeMillis();
    }

    /**
     * Set discount to food.
     *
     * @param discount discount.
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Discount price of food.
     *
     * @return price.
     */
    public int getPrice() {
        return (int) (price * (1 - (double) discount / 100));
    }

    /**
     * Food shelf life.
     *
     * @return resource.
     */
    public double getResource() {
        return (double) (this.currentDate - this.createDate) / (this.expiryDate - this.createDate) * 100;
    }
}
