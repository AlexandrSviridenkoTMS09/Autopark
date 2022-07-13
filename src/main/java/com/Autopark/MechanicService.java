package com.Autopark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class MechanicService implements Fixer {
    private static final String[] details = {"Фильтр", "Втулка", "Вал", "Ось",
            "Свеча", "Масло", "ГРМ", "ШРУС"};

    public MechanicService() {
    }

    @Override
    public Map<String, Integer> detectBreaking(Vehicle vehicle) {
        Map<String, Integer> result = new HashMap<>();
        int sum = createRandomBrokenDetailsAndReturnSum(vehicle, result);
        vehicle.setSumOfBrokenParts(sum);
        writeInFileBrokenDetails(vehicle, result);
        return result;
    }

    @Override
    public void repair(Vehicle vehicle) {
        List<String> result = new ArrayList<>();
        int counter = 0;
        counter = counter(vehicle);
        counterMoreNull(vehicle, counter);
        writeInFileRemainingBreaking(vehicle, result);
        counterEqualNull(vehicle, counter);
    }

    @Override
    public boolean isBroken(Vehicle vehicle) {
        if (vehicle.getBroken()) {
            return true;
        } else {
            return false;
        }
    }

    public static int createRandomBrokenDetailsAndReturnSum(Vehicle vehicle, Map<String, Integer> result) {
        int sum = 0;
        for (String s : details) {
            int randomNumber = (int) (Math.random() * 2);
            result.put(s, randomNumber);
            calculateSumBrokenDetails(randomNumber, sum);
            if (randomNumber > 0) vehicle.setBroken(true);
        }
        return sum;
    }

    public static int calculateSumBrokenDetails(int randomNumber, int sum) {
        sum += randomNumber;
        return sum;
    }

    public static Map writeInFileBrokenDetails(Vehicle vehicle, Map<String, Integer> result) {
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/Александр/IdeaProjects/Autopark/src/main/java/com/Autopark/File.csv/orders.csv", true);
            StringBuilder details = new StringBuilder();
            details.append(vehicle.getId());
            for (String key : result.keySet()) {
                details.append(",").append(key).append(",").append(result.get(key));
            }
            details.append("\n");
            fileWriter.write(details.toString());
            fileWriter.flush();
            vehicle.setBrokenParts(details.substring(2, details.length()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int counter(Vehicle vehicle) {
        String[] details = vehicle.getBrokenParts().split(",");
        details[details.length - 1] = details[details.length - 1].replace("\n", "");
        int counter = 0;
        for (int i = 1; i < details.length; i += 2) {
            if (Integer.parseInt(details[i]) != 0) {
                details[i] = "0";
                counter++;
            }
        }
        return counter;
    }

    public static void counterMoreNull(Vehicle vehicle, int counter) {
        if (counter > 0) {
            System.out.println("Vehicle '" + vehicle.getModelName() + "' was fixed");
            vehicle.setBroken(false);
        }
    }

    public static void counterEqualNull(Vehicle vehicle, int counter) {
        if (counter == 0) {
            System.out.println("Vehicle is healthy");
        }
    }

    public static void writeInFileRemainingBreaking(Vehicle vehicle, List<String> result) {
        try {
            File writer = new File("C:/Users/Александр/IdeaProjects/Autopark/src/main/java/com/Autopark/File.csv/orders.csv");
            FileWriter file = new FileWriter(writer, false);
            Scanner scanner = new Scanner(writer);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (vehicle.getId() != Integer.parseInt(str.substring(0))) {
                    result.add(str + "\n");
                }
            }
            for (String s : result) {
                file.write(s);
            }
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
