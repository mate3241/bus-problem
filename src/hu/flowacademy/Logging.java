package hu.flowacademy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Logging {
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
  public static void logLine(String content) {
    System.out.println(String.format("%s - %s - %s", DATE_FORMAT.format(new Date()), Thread.currentThread().getName(), content));
  }
  public static void logLineWithLevel(String level, String content) {
    logLine(String.format("%s - %s", level, content));
  }
  public static void logError(String content) {
    logLineWithLevel("ERROR", content);
  }
  public static void logInfo(String content) {
    logLineWithLevel("INFO", content);
  }
}
