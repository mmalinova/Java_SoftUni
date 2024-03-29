package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    private ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CityService cityService;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.cityService = cityService;
    }


    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(FORECAST_FILE_PATH, ForecastSeedRootDto.class)
                .getForecast()
                .stream()
                .filter(forecastSeedDto -> {
                    List<Forecast> all = forecastRepository.findAllByDaysOfWeekAndCity_Id(forecastSeedDto.getDayOfWeek(), forecastSeedDto.getCity());
                    boolean isValid = validationUtil.isValid(forecastSeedDto) && all.size() == 0;
                    sb.append(isValid ? String.format("Successfully import forecast %s - %.2f",
                                    forecastSeedDto.getDayOfWeek(), forecastSeedDto.getMaxTemperature()) : "Invalid forecast")
                            .append(System.lineSeparator());
                    return isValid;
                }).map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto
                            , Forecast.class);
                    forecast.setCity(cityService.getCityById(forecastSeedDto.getCity()));
                    return forecast;
                })
                .forEach(forecastRepository::save);
        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        forecastRepository.findAllWantedForecasts()
                .forEach(forecast -> {
                    sb.append(String.format("City: %s:\n" +
                                            "   \t\t-min temperature: %.2f\n" +
                                            "   \t\t--max temperature: %.2f\n" +
                                            "   \t\t---sunrise: %s\n" +
                                            "   \t\t----sunset: %s\n", forecast.getCity().getCityName(),
                                    forecast.getMinTemperature(), forecast.getMaxTemperature(),
                                    forecast.getSunrise(), forecast.getSunset()));
                });
        return sb.toString().trim();
    }
}
