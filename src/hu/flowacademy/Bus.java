package hu.flowacademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bus {
  int numOfDoors;
  Map<Integer, Door> doors;
  List<String> passengerList;

  public Bus(int numOfDoors) {
    this.numOfDoors = numOfDoors;
    this.doors = new HashMap<>();
    for (int i = 0; i < numOfDoors; i++) {
      doors.put(i, new Door(i));
    }

    this.passengerList = new ArrayList<>();
  }

  Door getDoor(int doorNumber){
    return doors.get(doorNumber);
  }

  boolean takeTheBus(String passengerName, Door doorWhereStanding){
    if (passengerName.equals(doorWhereStanding.getThePassengerAtTheDoor())){
      passengerList.add(passengerName);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      doorWhereStanding.leaveTheDoor(passengerName);
      return true;
    }
    return false;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (String p: passengerList
         ) {
      sb.append(p).append("\n");
    }
    return sb.toString();
  }
}

