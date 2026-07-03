package vehicle;

/**
 * Абстрактный класс, представляющий транспортное средство.
 * Содержит общие характеристики и методы для всех видов транспорта.
 */
public abstract class Vehicle {
    private String brand;
    private double price;
    private int maxSpeed;
    private int year;

    /**
     * Конструктор для создания объекта транспортного средства.
     */
    public Vehicle(String brand, double price, int maxSpeed, int year) {
        validateVehicleData(brand, price, maxSpeed, year);
        this.brand = brand;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.year = year;
    }

    /**
     * Проверяет корректность данных транспортного средства.
     */
    private void validateVehicleData(String brand, double price, int maxSpeed, int year) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("Max speed cannot be negative");
        }
        if (year < 1886 || year > 2026) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        this.brand = brand;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public int getMaxSpeed() { return maxSpeed; }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("Max speed cannot be negative");
        }
        this.maxSpeed = maxSpeed;
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        if (year < 1886 || year > 2026) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
        this.year = year;
    }

    @Override
    public abstract String toString();
}