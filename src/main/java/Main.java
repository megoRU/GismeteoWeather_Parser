import java.io.IOException;

public class Main {

  private static final String WEATHER = "https://www.gismeteo.ru/";

  public static void main(String[] args) throws IOException {
      Weather weather = new Weather(WEATHER);
      weather.weatherFromSite();
  }
}
