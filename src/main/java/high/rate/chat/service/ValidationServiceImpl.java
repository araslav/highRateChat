package high.rate.chat.service;

import high.rate.chat.dto.RequestValidationDto;
import high.rate.chat.dto.ResponseValidationDto;
import high.rate.chat.validate.ChatValidate;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    public ResponseValidationDto validateNameAndChartId(RequestValidationDto requestDto) {
        if (!ChatValidate.isValidChatId(requestDto.chatId())) {
            return new ResponseValidationDto(false,
                    "Invalid chat ID: must be ASCII, up to 64 characters and not less then 3 characters.",
                    requestDto.chatId());
        }

        if (!ChatValidate.isValidUsername(requestDto.userName())) {
            return new ResponseValidationDto(false,
                    "Invalid username: must be ASCII and up to 32 characters and not less then 3 characters.",
                    requestDto.chatId());
        }

        return new ResponseValidationDto(true,
                "", requestDto.chatId());
    }
}
