package high.rate.chat.service;

import high.rate.chat.model.ChatMessage;

import java.util.List;

public interface ChatService {
    void saveMessage(ChatMessage message);
    List<ChatMessage> getChatHistory(String chatId);
}
