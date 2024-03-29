package br.ufrn.soapproject;

import jakarta.annotation.PostConstruct;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.springframework.stereotype.Component;

@Component
public class ChatRepository {
    private static Bot bot;
    private static Chat chat;
    private static final boolean TRACE_MODE = false;

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        return path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    }
    private static Bot configureBot() {
        String resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        return new Bot("super", resourcesPath);
    }

    @PostConstruct
    public void initData() {
        bot = configureBot();
        chat = new Chat(bot);
        bot.brain.nodeStats();
    }

    public String answer(String message) {
        String response = chat.multisentenceRespond(message);
        return response;
    }
}