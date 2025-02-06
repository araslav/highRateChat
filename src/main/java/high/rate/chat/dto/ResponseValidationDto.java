package high.rate.chat.dto;

public record ResponseValidationDto(Boolean status,
                                    String message,
                                    String chatId) {
}
