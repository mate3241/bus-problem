package hu.flowacademy;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main4 {
  public static void main(String[] args) {
    int numberOfPassengers = 10;
    Bus bus = new Bus(3);
    Passenger[] passengers = new Passenger[numberOfPassengers];
    ExecutorService exec = Executors.newFixedThreadPool(numberOfPassengers);
    Future[] futures = new Future[numberOfPassengers];
    for (int i = 0; i < numberOfPassengers; i++) {
      passengers[i] = new Passenger("Passenger " + i, bus);
      futures[i] = exec.submit(passengers[i]);
    }
    System.out.println("The passengers have started!");
    for (int i = 0; i < numberOfPassengers; i++) {
      try {
        futures[i].get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    exec.shutdown();
    System.out.println("It's done!");
    System.out.println(bus.toString());
  }
}

  /**
   * Exercise 3:
   * Implement solution for Bus - Passengers problem where:
   *
   * There is a Bus, having N Doors and X Passengers who want to
   * take the bus.
   *
   * Details are the following:
   *
   * Bus
   *  - Class
   *  - has number of Doors param in constructor
   *  - Creates map of doors (door num and door instance)
   *  - supports "Door getDoor(int doorNumber)" operation
   *  - supports "boolean takeTheBus(String passengerName, Door doorWhereStanding)" operation
   *      taking 1 sec for the operation
   *      successful if the passenger is standing at the door (use getThePassengerAtTheDoor())
   *      adding the passenger name to the collection of passengers (keep ordering)
   *      successfully make leaving the door (leaveTheDoor method on Door object)
   *      resulting true if successful
   *      resulting false elsewhere
   *  - supports "toString()" operation listing the passengers
   *
   * Door
   *  - Class
   *  - gets the door id in the constructor
   *  - has a local variable (for multi-threading environment) storing the name
   *      of the Passenger standing at the door, the empty state is null
   *  - supports "int getDoorNumber()" operation returning the door id
   *  - supports "String getThePassengerAtTheDoor()" operation returning the name of the passenger at the door
   *  - supports "boolean takeTheDoor(String passengerName)" operation what
   *      * returns true is the old value is null, and successfully set to the new name
   *  - supports "boolean leaveTheDoor(String passengerName)"
   *      * returns true if the old value is the given and successfully set to null
   *
   * Passenger
   *  - runnable,
   *  - has a name and bus reference set by the constructor
   *  - in run the bus-taking-logic is implemented:
   *      * get a Door
   *      * try to take it
   *      * if successful, take the bus, elsewhere go to another door (takes 10sec)
   *      * if the passenger is on the bus, log a message
   *
   *  - log following information in the logic:
   *      - the passenger starts the process (name, time)
   *      - the passenger tries to take a door (name, door id, time)
   *      - the passenger goes another door
   *      - the passenger successfully takes the bus, door number
   *
   *
   */
/*  Bus bus10 = new Bus(3);
  int numberOfPassangers = 10;
  Runnable[] passengers = new Runnable[numberOfPassangers];
for (int i = 0; i < passengers.length; i++) {
        passengers[i] = new Passenger("Passenger" + i, bus10);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfPassangers);
        Future[] futures = new Future[numberOfPassangers];
        for (int i = 0; i < passengers.length; i++) {
        futures[i] = executorService.submit(passengers[i]);
        }
        Logging.logInfo("Passengers started");
        for (int i = 0; i < passengers.length; i++) {
        try {
        futures[i].get();
        } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
        }
        }
        executorService.shutdown();
        Logging.logInfo("They are all on the bus!");
        Logging.logInfo(bus10.toString());

        */
