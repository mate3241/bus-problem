package hu.flowacademy;

import java.util.concurrent.atomic.AtomicReference;

public class Door {
  int id;
  AtomicReference<String> passengerAtTheDoor;

  public Door(int id) {
    this.id = id;
    this.passengerAtTheDoor = new AtomicReference<>(null);
  }

  int getDoorNumber() {
    return id;
  }

  String getThePassengerAtTheDoor() {
    return passengerAtTheDoor.get();
  }

  boolean takeTheDoor(String passengerName) {
    return passengerAtTheDoor.compareAndSet(null, passengerName);
  }

  boolean leaveTheDoor(String passengerName) {
    return passengerAtTheDoor.compareAndSet(passengerName, null);
  }

}
