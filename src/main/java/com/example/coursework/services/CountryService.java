package com.example.coursework.services;

import com.example.coursework.models.dto.requests.CreateCountryRequest;
import com.example.coursework.models.entity.Country;
import com.example.coursework.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void create(CreateCountryRequest request) {
        Country country = new Country();
        country.setName(request.getName());

        countryRepository.save(country);
    }
}
