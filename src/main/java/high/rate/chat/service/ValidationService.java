package high.rate.chat.service;

import high.rate.chat.dto.RequestValidationDto;
import high.rate.chat.dto.ResponseValidationDto;

public interface ValidationService {
    ResponseValidationDto validateNameAndChartId(RequestValidationDto requestDto);
}
