//package com.example.demo.configuration;
//
//import com.example.demo.model.Airplane;
//import com.example.demo.model.dto.FlightDto;
//import org.hibernate.collection.internal.PersistentBag;
//import org.modelmapper.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class AirplaneMapper extends PropertyMap<Airplane, AirplaneGetAllDto> {
//    @Autowired
//    private ModelMapper modelMapper;
//    Converter<PersistentBag, List<FlightDto>> flightArrayDto = new AbstractConverter<PersistentBag, List<FlightDto>>() {
//
//        protected List<FlightDto> convert(PersistentBag source) {
//            ModelMapper modelMapper = new ModelMapper();
//            return modelMapper.map(source, new TypeToken<List<AirplaneGetAllDto>>() {}.getType());
//        }
//    };
//    protected void configure() {
//        using(flightArrayDto).map().setFlights(destination.getFlights());
//    }
//}
