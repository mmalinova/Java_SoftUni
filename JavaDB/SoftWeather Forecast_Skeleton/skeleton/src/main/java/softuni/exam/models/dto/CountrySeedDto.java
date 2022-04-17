package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CountrySeedDto {
    @Expose
    private String countryName;
    @Expose
    private String currency;

    public CountrySeedDto() {
    }

    @Size(min = 2, max = 60)
    @NotBlank
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Size(min = 2, max = 60)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
