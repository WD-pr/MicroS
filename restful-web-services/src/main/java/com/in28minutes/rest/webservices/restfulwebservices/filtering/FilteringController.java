package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	private <T> MappingJacksonValue getMappingWithFilters(T objectToFilter, String... filtersFields) {

		MappingJacksonValue mapping = new MappingJacksonValue(objectToFilter);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filtersFields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);

		return mapping;
	}

	// Dynamic filtering
	// field1, field2
	@GetMapping("/filtering")
	public MappingJacksonValue retireveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		MappingJacksonValue mapping = getMappingWithFilters(someBean, "field1", "field2");
		return mapping;
	}

	// Dynamic filtering
	// field2, field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retireveListOfSomeBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value12", "value22", "value32"));

		MappingJacksonValue mapping = getMappingWithFilters(list, "field2", "field3");
		return mapping;
	}

}
