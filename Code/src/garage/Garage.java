package garage;

import vehicle.Vehicle;
import vehicle.Car;
import vehicle.Bicycle;
import vehicle.Lorry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс, представляющий гараж для хранения транспортных средств.
 */
public class Garage {
    private List<Vehicle> vehicles;
    private static final int MAX_CAPACITY = 100;

    /**
     * Конструктор по умолчанию.
     */
    public Garage() {
        this.vehicles = new ArrayList<>();
    }

    /**
     * Конструктор с начальной вместимостью.
     */
    public Garage(int initialCapacity) {
        this.vehicles = new ArrayList<>(initialCapacity);
    }

    /**
     * Добавляет транспортное средство в гараж.
     */
    public boolean add(Vehicle v) {
        if (v == null) {
            System.out.println("Cannot add null vehicle");
            return false;
        }
        if (vehicles.size() >= MAX_CAPACITY) {
            System.out.println("Garage is full! Cannot add more vehicles.");
            return false;
        }
        return vehicles.add(v);
    }

    /**
     * Добавляет несколько транспортных средств в гараж.
     */
    public void addAll(Vehicle... vehiclesArray) {
        for (Vehicle v : vehiclesArray) {
            add(v);
        }
    }

    /**
     * Удаляет транспортное средство из гаража.
     */
    public boolean remove(Vehicle v) {
        if (v == null) {
            return false;
        }
        return vehicles.remove(v);
    }

    /**
     * Удаляет транспортное средство по индексу.
     */
    public Vehicle remove(int index) {
        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Invalid index: " + index);
            return null;
        }
        return vehicles.remove(index);
    }

    /**
     * Возвращает количество транспортных средств в гараже.
     */
    public int size() {
        return vehicles.size();
    }

    /**
     * Проверяет, пуст ли гараж.
     */
    public boolean isEmpty() {
        return vehicles.isEmpty();
    }

    /**
     * Очищает гараж.
     */
    public void clear() {
        vehicles.clear();
        System.out.println("Garage has been cleared");
    }

    /**
     * Получает транспортное средство по индексу.
     */
    public Vehicle get(int index) {
        if (index < 0 || index >= vehicles.size()) {
            return null;
        }
        return vehicles.get(index);
    }

    /**
     * Получает список всех транспортных средств.
     */
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    /**
     * Отображает все транспортные средства в гараже.
     */
    public void showAll() {
        if (isEmpty()) {
            System.out.println("Garage is empty");
            return;
        }
        printHeader("Transport list");
        for (int i = 0; i < vehicles.size(); i++) {
            printVehicle(i + 1, vehicles.get(i));
        }
        printFooter();
    }

    /**
     * Отображает транспортные средства, отсортированные по цене.
     */
    public void showSortedByPrice() {
        if (isEmpty()) {
            System.out.println("Garage is empty");
            return;
        }
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
        sortedVehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        printHeader("Transport list sorted by price");
        for (int i = 0; i < sortedVehicles.size(); i++) {
            printVehicle(i + 1, sortedVehicles.get(i));
        }
        printFooter();
    }

    /**
     * Отображает транспортные средства, отсортированные по году выпуска.
     */
    public void showSortedByYear() {
        if (isEmpty()) {
            System.out.println("Garage is empty");
            return;
        }
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
        sortedVehicles.sort(Comparator.comparingInt(Vehicle::getYear));
        printHeader("Transport list sorted by year");
        for (int i = 0; i < sortedVehicles.size(); i++) {
            printVehicle(i + 1, sortedVehicles.get(i));
        }
        printFooter();
    }

    /**
     * Сортирует транспортные средства в гараже по цене.
     */
    public void sortByPrice() {
        if (vehicles.size() < 2) {
            System.out.println("Not enough vehicles to sort (need at least 2)");
            return;
        }
        vehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        System.out.println("Vehicles sorted by price in the garage");
    }

    /**
     * Сортирует транспортные средства в гараже по году выпуска.
     */
    public void sortByYear() {
        if (vehicles.size() < 2) {
            System.out.println("Not enough vehicles to sort (need at least 2)");
            return;
        }
        vehicles.sort(Comparator.comparingInt(Vehicle::getYear));
        System.out.println("Vehicles sorted by year in the garage");
    }

    /**
     * Выводит заголовок списка.
     */
    private void printHeader(String title) {
        System.out.println("\n=== " + title + " ===");
        System.out.println("Total vehicles: " + vehicles.size());
        System.out.println("----------------------------------------");
    }

    /**
     * Выводит информацию о транспортном средстве.
     */
    private void printVehicle(int index, Vehicle vehicle) {
        System.out.println(String.format("%2d. %s", index, vehicle));
    }

    /**
     * Выводит подвал списка.
     */
    private void printFooter() {
        System.out.println("----------------------------------------");
    }

    /**
     * Выводит статистику по гаражу.
     */
    public void printStatistics() {
        if (isEmpty()) {
            System.out.println("Garage is empty");
            return;
        }

        System.out.println("\n=== Garage Statistics ===");
        System.out.println("Total vehicles: " + vehicles.size());

        int cars = 0, bicycles = 0, lorries = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars++;
            else if (v instanceof Bicycle) bicycles++;
            else if (v instanceof Lorry) lorries++;
        }

        System.out.println("Cars: " + cars);
        System.out.println("Bicycles: " + bicycles);
        System.out.println("Lorries: " + lorries);

        double totalPrice = 0;
        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;

        for (Vehicle v : vehicles) {
            double price = v.getPrice();
            totalPrice += price;
            minPrice = Math.min(minPrice, price);
            maxPrice = Math.max(maxPrice, price);
        }

        System.out.println(String.format("Average price: %.2f", totalPrice / vehicles.size()));
        System.out.println(String.format("Min price: %.2f", minPrice));
        System.out.println(String.format("Max price: %.2f", maxPrice));
        System.out.println("=========================");
    }
}