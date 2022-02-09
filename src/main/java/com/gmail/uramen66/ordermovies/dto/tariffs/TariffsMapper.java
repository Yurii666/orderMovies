package com.gmail.uramen66.ordermovies.dto.tariffs;

import com.gmail.uramen66.ordermovies.model.Tariffs;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface TariffsMapper {
    TariffsDTO tariffsToTariffsDto(Tariffs tariffs);

    Tariffs tariffsDtoToTariffs(TariffsDTO tariffsDTO);
}
