package high.rate.chat.service;

import high.rate.chat.model.ChatMessage;
import high.rate.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatServiceImp implements ChatService {

    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(ChatMessage message) {
        chatMessageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(String chatId) {
        return chatMessageRepository.findByChatId(chatId);
    }
}
