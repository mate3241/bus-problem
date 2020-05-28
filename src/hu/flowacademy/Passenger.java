package hu.flowacademy;

public class Passenger implements Runnable {
  String name;
  Bus bus;

  public Passenger(String name, Bus bus) {
    this.name = name;
    this.bus = bus;
  }

  @Override
  public void run() {
    Logging.logLine(name + " has started");
    for (int i = 0; i < bus.numOfDoors; i++) {
      Logging.logLine(name + " is trying door " + i);
      if (bus.getDoor(i).takeTheDoor(name)) {
        bus.takeTheBus(name, bus.getDoor(i));
        Logging.logLine(name + " has taken the bus");
        return;
      } else {
        Logging.logLine(name + " goes to another door");
        if (i == bus.numOfDoors - 1) {
          i = -1;
        }
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
