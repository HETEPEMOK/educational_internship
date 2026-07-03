package vehicle;

/**
 * Класс, представляющий легковой автомобиль.
 * Наследует класс Vehicle.
 */
public class Car extends Vehicle {
    private String bodyType;

    /**
     * Конструктор для создания объекта легкового автомобиля.
     */
    public Car(String brand, double price, int maxSpeed, int year, String bodyType) {
        super(brand, price, maxSpeed, year);
        validateBodyType(bodyType);
        this.bodyType = bodyType;
    }

    /**
     * Проверяет корректность типа кузова.
     */
    private void validateBodyType(String bodyType) {
        if (bodyType == null || bodyType.trim().isEmpty()) {
            throw new IllegalArgumentException("Body type cannot be null or empty");
        }
        String[] validTypes = {"sedan", "coupe", "hatchback", "suv", "convertible", "wagon", "pickup"};
        boolean isValid = false;
        for (String type : validTypes) {
            if (type.equalsIgnoreCase(bodyType.trim())) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Invalid body type: " + bodyType +
                    ". Valid types: sedan, coupe, hatchback, suv, convertible, wagon, pickup");
        }
    }

    public String getBodyType() { return bodyType; }

    public void setBodyType(String bodyType) {
        validateBodyType(bodyType);
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return String.format("Car: brand='%s', price=%.2f, maxSpeed=%d, year=%d, bodyType='%s'",
                getBrand(), getPrice(), getMaxSpeed(), getYear(), bodyType);
    }
}