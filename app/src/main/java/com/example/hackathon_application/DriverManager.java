package com.example.hackathon_application;

public class DriverManager {

    public static DriverClass[] drivers = new DriverClass[10];

    public static void add(DriverClass d){
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i] == null){
                drivers[i] = d;
                break;
            }
        }
    }

    public static void selectDriver(DriverClass d){

        for(int i = 0; i < drivers.length; i++){
            if(drivers[i] != null){
                if(drivers[i] == d){
                    drivers[i].select();
                }
            }
        }

    }

    public static DriverClass[] listAvailableDrivers(int t){
        DriverClass[] available = new DriverClass[10];
        for(int i = 0,c = 0; i < drivers.length;i++){
            if(drivers[i] != null ){

                if(drivers[i].getStart() <= t && drivers[i].getEnd() >= t && !drivers[i].isSelected){

                    available[c] = drivers[i];
                    c++;
                }


            }
        }
        for(DriverClass i:available){
            if( i != null){
                System.out.println(i.getName());
            }
        }
        return available;
    }

    public static void selectDriver(int i ){
        drivers[i].select();
    }

    public static int findDrivers(DriverClass d){
        for(int i = 0; i < drivers.length; i++){
            if(drivers[i] != null && drivers[i] == d){
                return i;
            }
        }

        return 0;
    }


}
