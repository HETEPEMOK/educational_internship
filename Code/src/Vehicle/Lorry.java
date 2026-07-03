package vehicle;

/**
 * Класс, представляющий грузовой автомобиль.
 * Наследует класс Vehicle.
 */
public class Lorry extends Vehicle {
    private double loadCapacity;

    /**
     * Конструктор для создания объекта грузового автомобиля.
     */
    public Lorry(String brand, double price, int maxSpeed, int year, double loadCapacity) {
        super(brand, price, maxSpeed, year);
        validateLoadCapacity(loadCapacity);
        this.loadCapacity = loadCapacity;
    }

    /**
     * Проверяет корректность грузоподъемности.
     */
    private void validateLoadCapacity(double loadCapacity) {
        if (loadCapacity < 0 || loadCapacity > 100) {
            throw new IllegalArgumentException("Load capacity must be between 0 and 100 tons");
        }
    }

    public double getLoadCapacity() { return loadCapacity; }

    public void setLoadCapacity(double loadCapacity) {
        validateLoadCapacity(loadCapacity);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return String.format("Lorry: brand='%s', price=%.2f, maxSpeed=%d, year=%d, loadCapacity=%.1ft",
                getBrand(), getPrice(), getMaxSpeed(), getYear(), loadCapacity);
    }
}