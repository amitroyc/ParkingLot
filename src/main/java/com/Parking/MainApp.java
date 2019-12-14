package com.Parking;

public class MainApp {

    public static void main(String[] args) {
        ParkingSpace[] parkingSpaces = null;

        switch (args[2]){
            
        }
        if(args[1].toUpperCase().equals(Command.CREATE_PARKING_LOT) && args[2] != null){
             parkingSpaces = new ParkingSpace[Integer.parseInt(args[2])];
             System.out.println("Created a parking lot with " + args[2] + " slots");
        }
        else if(args[1].toUpperCase().equals(Command.PARK) && args[2] != null && args[3] != null){
            Car newCar = new Car(args[2], args[3]);
            char flag = 'N';
            for(int i=0; i< parkingSpaces.length; i++){
                if(parkingSpaces[i] == null){
                    parkingSpaces[i] = new ParkingSpace(newCar ,i);
                    flag = 'Y';
                }
            }
            if(flag == 'N')
                System.out.println("Sorry, parking lot is full");
        }
        else if(args[1].toUpperCase().equals(Command.LEAVE) && args[2] != null){
            parkingSpaces[Integer.parseInt(args[2])] = null;
            System.out.println("Slot number " + args[2] + " is free");
        }
        else if(args[1].toUpperCase().equals(Command.STATUS) && args[2] != null){
            for (int i = 0; i < parkingSpaces.length; i++) {
                System.out.println("Slot No. \t\t Registration No \t\t Colour");
                if (parkingSpaces[i] != null){
                    System.out.println("" + i + parkingSpaces[i].getCar());
                }
            }
        }
        else if(args[1].toUpperCase().equals(Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR)
                && args[2] != null){
            for (int i = 0; i < parkingSpaces.length; i++) {
                if(parkingSpaces[i].getCar().colour.equalsIgnoreCase(args[2])){
                    System.out.print(parkingSpaces[i].getCar().strRegistrationNo + ", ");
                }
            }
        }
        else if(args[1].toUpperCase().equals(Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR)
                && args[2] != null){
            for (int i = 0; i < parkingSpaces.length; i++) {
                if(parkingSpaces[i].getCar().colour.equalsIgnoreCase(args[2])){
                    System.out.print(i + ", ");
                }
            }
        }
        else if(args[1].toUpperCase().equals(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER)
                && args[2] != null){
            char flag = 'N';
            for (int i = 0; i < parkingSpaces.length; i++) {
                if(parkingSpaces[i].getCar().strRegistrationNo.equalsIgnoreCase(args[2])){
                    System.out.println(i);
                    flag = 'Y';
                }
            }
            if(flag == 'N')
                System.out.println("Not found");
        }
        else
            System.exit(0);
    }

}
