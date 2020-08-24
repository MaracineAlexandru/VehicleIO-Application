package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void countVehicles(Map<String, List<Vehicle>> vehicleMap, String vehicleType) {
        System.out.println("Sunt " + vehicleMap.get(vehicleType).size() + " vehicule de tip " + vehicleType + " in map");
    }

    public static void countVehiclesByBrand(Map<String, List<Vehicle>> vehicleMap, String brand) {
        int count = 0;
        for (Map.Entry<String, List<Vehicle>> elementCurent : vehicleMap.entrySet()) {
            List<Vehicle> objectList = elementCurent.getValue();
            for (Vehicle elementActual : objectList) {
                if (elementActual.getBrand().equals(brand)) {
                    count++;
                }
            }
        }
        System.out.println("Sunt " + count + " vehicule de tip " + brand + " in map");
    }

    public static void sortChoppersByTopSpeed(Map<String, List<Vehicle>> vehicleMap, String shape) {
        List<Vehicle> listaVehiculeCuChopper = new ArrayList<>();
        for(Map.Entry<String,List<Vehicle>> elementulCheie:vehicleMap.entrySet()){
            List<Vehicle> vehicleList=elementulCheie.getValue();
            for(Vehicle elementulProprietate: vehicleList){
                if(elementulProprietate.getShape().equals(shape)){
                    listaVehiculeCuChopper.add(elementulProprietate);
                }
            }
        }
        listaVehiculeCuChopper.sort(Comparator.comparing(Vehicle::getTopSpeed));
        System.out.println("Lista vehiculelor cu forma de Chopper sortate in functie de viteza");
        for(Vehicle vehicle:listaVehiculeCuChopper){
            System.out.println(vehicle.getBrand()+vehicle.getTopSpeed());
        }

    }

    public static void sortCarsByPrice(Map<String, List<Vehicle>> vehicleMap) {
        List<Vehicle> carList = vehicleMap.get("Car");
        carList.sort(Comparator.comparing(Vehicle::getPrice));
        System.out.println("Lista de car sortate in functie de pret:");
        for (Vehicle vehicle : carList) {
            System.out.println(vehicle.getBrand() + " " + vehicle.getPrice());
        }
    }

    public static void writeVehiclesIntoFiles(Map<String,List<Vehicle>> vehicleMap) {
        for (Map.Entry<String, List<Vehicle>> elementulCheie : vehicleMap.entrySet()) {
            switch (elementulCheie.getKey()) {
                case "Car": {
                    List<Vehicle> carList = elementulCheie.getValue();
                    try {
                        File file = new File("C:\\Users\\Ramona\\Desktop\\carList.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        for (int index = 0; index < carList.size(); index++) {
                            StringBuffer line = new StringBuffer();
                            line.append(carList.get(index).getBrand());
                            line.append(", ");
                            line.append(carList.get(index).getModel());
                            line.append(", ");
                            line.append(carList.get(index).getPrice());
                            line.append(", ");
                            line.append(carList.get(index).getTopSpeed());
                            line.append(", ");
                            line.append(carList.get(index).getTransmission());
                            line.append(", ");
                            line.append(carList.get(index).getShape());

                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                    }
                    break;
                }
                case "Motorcycle": {
                    List<Vehicle> motorcycleList = elementulCheie.getValue();
                    try {
                        File file = new File("C:\\Users\\Ramona\\Desktop\\motorcycleList.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        for (int index = 0; index < motorcycleList.size(); index++) {
                            StringBuffer line = new StringBuffer();
                            line.append(motorcycleList.get(index).getBrand());
                            line.append(", ");
                            line.append(motorcycleList.get(index).getModel());
                            line.append(", ");
                            line.append(motorcycleList.get(index).getPrice());
                            line.append(", ");
                            line.append(motorcycleList.get(index).getTopSpeed());
                            line.append(", ");
                            line.append(motorcycleList.get(index).getShape());

                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                    }
                    break;
                }
                case "Tractor": {
                    List<Vehicle> tractorList = elementulCheie.getValue();
                    try {
                        File file = new File("C:\\Users\\Ramona\\Desktop\\tractorList.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        for (int index = 0; index < tractorList.size(); index++) {
                            StringBuffer line = new StringBuffer();
                            line.append(tractorList.get(index).getBrand());
                            line.append(", ");
                            line.append(tractorList.get(index).getModel());
                            line.append(", ");
                            line.append(tractorList.get(index).getPrice());
                            line.append(", ");
                            line.append(tractorList.get(index).getMaxPulledWeight());

                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        String vehicleType;
        Map<String, List<Vehicle>> vehicleMap = new HashMap<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader("C:\\Users\\Ramona\\Desktop\\vehicle.txt"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] wordsOfLine = line.split(", ");
                vehicleType = wordsOfLine[0];
                switch (vehicleType) {
                    case "Car": {
                        Car car = new Car(wordsOfLine[1], wordsOfLine[2], wordsOfLine[3], wordsOfLine[4], wordsOfLine[5], wordsOfLine[6]);

                        List<Vehicle> myList = vehicleMap.get("Car");
                        if (myList == null) {
                            List<Vehicle> props = new ArrayList<>();
                            props.add(car);
                            vehicleMap.put("Car", props);
                        } else {
                            myList.add(car);
                        }
                        break;
                    }
                    case "Motorcycle": {
                        Motorcycle motorcycle = new Motorcycle(wordsOfLine[1], wordsOfLine[2], wordsOfLine[3], wordsOfLine[4], wordsOfLine[5]);
                        List<Vehicle> myList = vehicleMap.get("Motorcycle");
                        if (myList == null) {
                            List<Vehicle> props = new ArrayList<>();
                            props.add(motorcycle);
                            vehicleMap.put("Motorcycle", props);
                        } else {
                            myList.add(motorcycle);
                        }
                        break;
                    }
                    case "Tractor": {
                        Tractor tractor = new Tractor(wordsOfLine[1], wordsOfLine[2], wordsOfLine[3], wordsOfLine[4]);
                        List<Vehicle> myList = vehicleMap.get("Tractor");
                        if (myList == null) {
                            List<Vehicle> props = new ArrayList<>();
                            props.add(tractor);
                            vehicleMap.put("Tractor", props);
                        } else {
                            myList.add(tractor);
                        }
                        break;
                    }
                    default: {
                    }
                }


                line = bufferedReader.readLine();


            }
        } catch (IOException e) {
            System.out.println("Exceptie");
        }

            countVehicles(vehicleMap, "Tractor");
            countVehiclesByBrand(vehicleMap, "Yamaha");
            sortCarsByPrice(vehicleMap);
            sortChoppersByTopSpeed(vehicleMap,"CHOPPER");
            writeVehiclesIntoFiles(vehicleMap);
    }
}

