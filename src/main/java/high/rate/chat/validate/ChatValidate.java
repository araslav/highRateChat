package high.rate.chat.validate;

import java.util.regex.Pattern;

public class ChatValidate {
    private static final Pattern ASCII_PATTERN = Pattern.compile("^[\\x00-\\x7F]+$");
    private static final int MAX_USERNAME_LENGTH = 32;
    private static final int MAX_CHATID_LENGTH = 64;
    private static final int MIN_LENGTH = 3;

    public static boolean isValidChatId(String chatId) {
        return (chatId.length() <= MAX_CHATID_LENGTH) &&
                (chatId.length() >= MIN_LENGTH) && ASCII_PATTERN.matcher(chatId).matches();
    }

    public static boolean isValidUsername(String userName) {
        return (userName.length() <= MAX_USERNAME_LENGTH) &&
                (userName.length() >= MIN_LENGTH) && ASCII_PATTERN.matcher(userName).matches();
    }
}
