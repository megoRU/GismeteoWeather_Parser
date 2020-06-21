import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Weather {

  private static String URL;

  public Weather(String URL) {
    this.URL = URL;
  }

  public void weatherFromSite() throws IOException {
    Document doc = Jsoup.connect(getWeather()).get();
    Elements termValueElement = doc.select("div.info_item._main.clearfix"); //тут почти все данные температуры
    Elements AtmosphereElement = doc.select("span.unit.unit_pressure_mm_hg_atm");
    String[] currentTemparute = termValueElement.text().split(" ");
    Elements termValueElement2 = doc.select("div.information._attention"); //тут почти все данные температуры
    Elements windElemets = doc.select("span.unit.unit_wind_m_s"); //тут почти все данные температуры
    Elements sityElemets = doc.select("div.float_left"); //тут город
    Elements humidityElemets = doc.select("div.ii.info_value"); //влажность
    String[] humidity = humidityElemets.text().split(" ");
    String[] feels = termValueElement2.text().split(" "); //2 index по ощущениям (температура)
    String[] Atmosphere = AtmosphereElement.text().split(" "); //Получаем атмосферное давление
    String[] wind = windElemets.text().split(" ");

    System.out.println("        " +  "Прогноз погоды в городе: " + sityElemets.text());
    //Вывод данных в консоль
    System.out.println("Текущая температура: "
        + currentTemparute[0] + "° " + currentTemparute[2]
        + " | Ощущается как: " + feels[2] + "° "
        + "\n" + "Ветер: " + wind[0] + " " + wind[1]
        + " Направление: " + wind[2]
        + " | Влажность: " + humidity[21] + humidity[22]
        + "\n" + "Давление: " + Atmosphere[0] + " Миллиметров ртутного столба");
  }

  public String getWeather() {
    return URL;
  }
}