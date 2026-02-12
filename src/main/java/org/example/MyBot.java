package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();

            if (text.equals("/start")) {
                Users users = new Users(chatId, firstName, lastName);




                Database database = new Database();
                database.create(users);
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("xush kelibsiz");

                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }

            if(text.equals("/read")){
                Database database = new Database();
                String read = database.read();

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(read);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "sdgagfa_bot";
    }

    @Override
    public String getBotToken() {
        return "8261393471:AAFUy85WCyml1US0P1n5ounnZ5YehoYrOK8";
    }
}