package com.Parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws FileNotFoundException {
        ParkingSpace[] parkingSpaces = null;
        String input = null;
        Scanner fileScanner = null;

        if(args.length != 0) {
            File file = new File(args[0]);
            fileScanner = new Scanner(file);
        }

        while (true) {
            try {
                if(fileScanner != null) {
                    input = fileScanner.nextLine();
                }
                else{
                    Scanner scanner = new Scanner(new InputStreamReader(System.in));
                    input = scanner.nextLine();
                }
                String[] strArrayInput = input.split(" ");
                    if (strArrayInput[0].toLowerCase().equalsIgnoreCase(CommandConstants.CREATE_PARKING_LOT) && strArrayInput[1] != null) {
                        parkingSpaces = new ParkingSpace[Integer.parseInt(strArrayInput[1])];
                        System.out.println("Created a parking lot with " + strArrayInput[1] + " slots");
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.PARK) && strArrayInput[1] != null && strArrayInput[2] != null) {
                        Car newCar = new Car(strArrayInput[1], strArrayInput[2]);
                        char flag = 'N';
                        for (int i = 0; i < parkingSpaces.length; i++) {
                            if (parkingSpaces[i] == null) {
                                parkingSpaces[i] = new ParkingSpace(newCar, i+1);
                                flag = 'Y';
                                break;
                            }
                        }
                        if (flag == 'N')
                            System.out.println("Sorry, parking lot is full");
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.LEAVE) && strArrayInput[1] != null) {
                        parkingSpaces[Integer.parseInt(strArrayInput[1]) -1 ] = null;
                        System.out.println("Slot number " + strArrayInput[1] + " is free");
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.STATUS)) {
                        for (int i = 0; i < parkingSpaces.length; i++) {
                            System.out.println("Slot No. \t\t Registration No \t\t Colour");
                            if (parkingSpaces[i] != null) {
                                System.out.println("" + (i+1) + "\t\t" + parkingSpaces[i].getCar());
                            }
                        }
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR)
                            && strArrayInput[1] != null) {
                        for (int i = 0; i < parkingSpaces.length; i++) {
                            if (parkingSpaces[i].getCar().colour.equalsIgnoreCase(strArrayInput[1])) {
                                System.out.print(parkingSpaces[i].getCar().strRegistrationNo + ", ");
                            }
                        }
                        System.out.println();
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR)
                            && strArrayInput[1] != null) {
                        for (int i = 0; i < parkingSpaces.length; i++) {
                            if (parkingSpaces[i].getCar().colour.equalsIgnoreCase(strArrayInput[1])) {
                                System.out.print((i+1) + ", ");
                            }
                        }
                        System.out.println();
                    } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER)
                            && strArrayInput[1] != null) {
                        char flag = 'N';
                        for (int i = 0; i < parkingSpaces.length; i++) {
                            if (parkingSpaces[i].getCar().strRegistrationNo.equalsIgnoreCase(strArrayInput[1])) {
                                System.out.println(i+1);
                                flag = 'Y';
                                break;
                            }
                        }
                        if (flag == 'N')
                            System.out.println("Not found");
                    } else
                        System.exit(0);
            }catch (IndexOutOfBoundsException e){
                System.out.println("Invalid input");
            }
        }
    }

}
