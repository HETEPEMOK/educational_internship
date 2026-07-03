package vehicle;

/**
 * Класс, представляющий велосипед.
 * Наследует класс Vehicle.
 */
public class Bicycle extends Vehicle {
    private int gearsCount;

    /**
     * Конструктор для создания объекта велосипеда.
     */
    public Bicycle(String brand, double price, int maxSpeed, int year, int gearsCount) {
        super(brand, price, maxSpeed, year);
        validateGearsCount(gearsCount);
        this.gearsCount = gearsCount;
    }

    /**
     * Проверяет корректность количества скоростей.
     */
    private void validateGearsCount(int gearsCount) {
        if (gearsCount < 1 || gearsCount > 30) {
            throw new IllegalArgumentException("Gears count must be between 1 and 30");
        }
    }

    public int getGearsCount() { return gearsCount; }

    public void setGearsCount(int gearsCount) {
        validateGearsCount(gearsCount);
        this.gearsCount = gearsCount;
    }

    @Override
    public String toString() {
        return String.format("Bicycle: brand='%s', price=%.2f, maxSpeed=%d, year=%d, gears=%d",
                getBrand(), getPrice(), getMaxSpeed(), getYear(), gearsCount);
    }
}