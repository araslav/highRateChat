package high.rate.chat.controller;

import high.rate.chat.dto.RequestValidationDto;
import high.rate.chat.dto.ResponseValidationDto;
import high.rate.chat.model.ChatMessage;
import high.rate.chat.service.ChatServiceImp;
import high.rate.chat.service.ValidationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ValidationServiceImpl validationService;
    private final ChatServiceImp chatService;

    @MessageMapping("/sendMessage")
    public void sendMessage(ChatMessage message) {
        chatService.saveMessage(message);
        String chatDestination = "/topic/chat/" + message.getChatId();
        messagingTemplate.convertAndSend(chatDestination, message);
    }

    @GetMapping("/chat/history")
    public List<ChatMessage> getChatHistory(@RequestParam String chatId) {
        return chatService.getChatHistory(chatId);
    }

    @PostMapping("/chat/validate-chat-id")
    public ResponseValidationDto joinChat(@RequestBody RequestValidationDto requestDto) {
        return validationService.validateNameAndChartId(requestDto);
    }
}
