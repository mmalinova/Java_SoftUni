package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedRootDto {
    @XmlElement(name = "forecast")
    private List<ForecastSeedDto> forecast;

    public List<ForecastSeedDto> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastSeedDto> forecast) {
        this.forecast = forecast;
    }
}
