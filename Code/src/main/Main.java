package main;

import vehicle.Car;
import vehicle.Bicycle;
import vehicle.Lorry;
import garage.Garage;

/**
 * Главный класс приложения для демонстрации работы с гаражом и транспортными средствами.
 */
public class Main {

    /**
     * Точка входа в программу.
     */
    public static void main(String[] args) {
        Garage garage = new Garage();

        Car car1 = new Car("Toyota", 25000, 220, 2020, "sedan");
        Car car2 = new Car("BMW", 45000, 250, 2022, "coupe");
        Bicycle bike1 = new Bicycle("Stels", 500, 40, 2021, 21);
        Bicycle bike2 = new Bicycle("GT", 800, 45, 2023, 24);
        Lorry lorry1 = new Lorry("Kamaz", 50000, 120, 2019, 15.5);
        Lorry lorry2 = new Lorry("Volvo", 90000, 130, 2021, 20.0);

        System.out.println("=== Adding vehicles to garage ===");
        garage.add(car1);
        garage.add(car2);
        garage.addAll(bike1, bike2, lorry1, lorry2);

        demonstrateGarageOperations(garage);
    }

    /**
     * Демонстрирует все операции с гаражом.
     */
    private static void demonstrateGarageOperations(Garage garage) {
        garage.showAll();

        garage.printStatistics();

        garage.sortByPrice();
        garage.showAll();

        garage.sortByYear();
        garage.showAll();

        garage.showSortedByPrice();
        garage.showSortedByYear();

        demonstrateRemovalAndOtherOperations(garage);
    }

    /**
     * Демонстрирует удаление и другие операции с гаражом.
     */
    private static void demonstrateRemovalAndOtherOperations(Garage garage) {
        System.out.println("\n=== Demonstrating removal operations ===");

        if (garage.size() > 0) {
            vehicle.Vehicle removed = garage.remove(0);
            System.out.println("Removed: " + removed);
        }

        garage.showAll();

        System.out.println("Current garage size: " + garage.size());

        garage.clear();
        garage.showAll();
    }
}