import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        HashMap<String, Integer> speciesCount = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Read from file
        readAnimalsFromFile(animals, speciesCount);

        // Add initial animals
        addInitialAnimals(animals, speciesCount);

        // Option to add new animals
        System.out.println("Would you like to add a new animal? (yes/no)");
        String response = scanner.nextLine();
        while (response.equalsIgnoreCase("yes")) {
            addAnimal(animals, speciesCount, scanner);
            System.out.println("Would you like to add another animal? (yes/no)");
            response = scanner.nextLine();
        }

        // Display all animals
        System.out.println("\nAnimal List:");
        for (Animal animal : animals) {
            animal.display();
        }

        // Display counts
        System.out.println("\nTotal Animal Count: " + animals.size());
        System.out.println("Species Count:");
        for (String species : speciesCount.keySet()) {
            System.out.println(species + ": " + speciesCount.get(species));
        }
    }

    private static void readAnimalsFromFile(List<Animal> animals, HashMap<String, Integer> speciesCount) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tony Jr\\OneDrive\\cit-63\\arrivingAnimals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(","); // Assumes details are comma-separated
                if (details.length == 7) { // Ensure there are 7 details
                    String species = details[0].trim();
                    int age = Integer.parseInt(details[1].trim());
                    String sex = details[2].trim();
                    String season = details[3].trim();
                    String color = details[4].trim();
                    double weight = Double.parseDouble(details[5].trim());
                    String habitat = details[6].trim();

                    Animal animal = createAnimal(species, age, sex, season, color, weight, habitat);
                    if (animal != null) {
                        animals.add(animal);
                        speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void addInitialAnimals(List<Animal> animals, HashMap<String, Integer> speciesCount) {
        // Adding Hyenas
        animals.add(new Hyena(4, "Female", "Spring", "Tan", 70.0, "Friguia Park, Tunisia"));
        speciesCount.put("Hyena", speciesCount.getOrDefault("Hyena", 0) + 1);

        animals.add(new Hyena(12, "Male", "Fall", "Brown", 150.0, "Friguia Park, Tunisia"));
        speciesCount.put("Hyena", speciesCount.getOrDefault("Hyena", 0) + 1);

        animals.add(new Hyena(4, "Male", "Spring", "Black", 120.0, "Friguia Park, Tunisia"));
        speciesCount.put("Hyena", speciesCount.getOrDefault("Hyena", 0) + 1);

        animals.add(new Hyena(8, "Female", "Unknown", "Black and Tan Striped", 105.0, "Friguia Park, Tunisia"));
        speciesCount.put("Hyena", speciesCount.getOrDefault("Hyena", 0) + 1);

        // Adding Lions
        animals.add(new Lion(6, "Female", "Spring", "Tan", 300.0, "Zanzibar, Tanzania"));
        speciesCount.put("Lion", speciesCount.getOrDefault("Lion", 0) + 1);

        animals.add(new Lion(12, "Female", "Winter", "Dark Tan", 375.0, "KopeLion, Tanzania"));
        speciesCount.put("Lion", speciesCount.getOrDefault("Lion", 0) + 1);

        animals.add(new Lion(22, "Male", "Fall", "Golden", 450.0, "Zanzibar, Tanzania"));
        speciesCount.put("Lion", speciesCount.getOrDefault("Lion", 0) + 1);

        animals.add(new Lion(4, "Female", "Spring", "Tan and Brown", 275.0, "KopeLion, Tanzania"));
        speciesCount.put("Lion", speciesCount.getOrDefault("Lion", 0) + 1);

        // Adding Tigers
        animals.add(new Tiger(2, "Male", "Spring", "Gold and Tan Stripes", 270.0, "Dhaka, Bangladesh"));
        speciesCount.put("Tiger", speciesCount.getOrDefault("Tiger", 0) + 1);

        animals.add(new Tiger(4, "Female", "Spring", "Black Stripes", 400.0, "Dhaka, Bangladesh"));
        speciesCount.put("Tiger", speciesCount.getOrDefault("Tiger", 0) + 1);

        animals.add(new Tiger(18, "Male", "Fall", "Gold and Tan", 300.0, "Bardia, Nepal"));
        speciesCount.put("Tiger", speciesCount.getOrDefault("Tiger", 0) + 1);

        animals.add(new Tiger(3, "Female", "Spring", "Black Stripes", 285.0, "Bardia, Nepal"));
        speciesCount.put("Tiger", speciesCount.getOrDefault("Tiger", 0) + 1);

        // Adding Bears
        animals.add(new Bear(7, "Male", "Spring", "Brown", 320.0, "Alaska Zoo, Alaska"));
        speciesCount.put("Bear", speciesCount.getOrDefault("Bear", 0) + 1);

        animals.add(new Bear(25, "Female", "Spring", "Black", 425.0, "Woodland Park Zoo, Washington"));
        speciesCount.put("Bear", speciesCount.getOrDefault("Bear", 0) + 1);

        animals.add(new Bear(4, "Female", "Fall", "Black", 355.0, "Woodland Park Zoo, Washington"));
        speciesCount.put("Bear", speciesCount.getOrDefault("Bear", 0) + 1);

        animals.add(new Bear(4, "Male", "Spring", "Brown", 405.0, "Alaska Zoo, Alaska"));
        speciesCount.put("Bear", speciesCount.getOrDefault("Bear", 0) + 1);
    }

    private static void addAnimal(List<Animal> animals, HashMap<String, Integer> speciesCount, Scanner scanner) {
        System.out.print("Enter species: ");
        String species = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter sex: ");
        String sex = scanner.nextLine();

        System.out.print("Enter season: ");
        String season = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter weight (in kg): ");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter habitat: ");
        String habitat = scanner.nextLine();

        Animal animal = createAnimal(species, age, sex, season, color, weight, habitat);
        if (animal != null) {
            animals.add(animal);
            speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
            System.out.println("Animal added successfully!");
        } else {
            System.out.println("Failed to add the animal due to unknown species.");
        }
    }

    private static Animal createAnimal(String species, int age, String sex, String season, String color, double weight, String habitat) {
        switch (species.toLowerCase()) {
            case "lion":
                return new Lion(age, sex, season, color, weight, habitat);
            case "hyena":
                return new Hyena(age, sex, season, color, weight, habitat);
            case "bear":
                return new Bear(age, sex, season, color, weight, habitat);
            case "tiger":
                return new Tiger(age, sex, season, color, weight, habitat);
            default:
                System.out.println("Unknown species: " + species);
                return null;
        }
    }
