package com.vlad.threads.messagessaver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StringSaverThread extends Thread {
    ArrayList<String> messagesList;

    public StringSaverThread(ArrayList<String> messagesList) {
        this.messagesList = messagesList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                saveToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() throws IOException {
        File file = new File("src/main/resources/messages.log");
        if (!file.exists()) {
            file.createNewFile();
        }

        if (!messagesList.isEmpty()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                for (String message : messagesList) {
                    bufferedWriter.write(message);
                    bufferedWriter.newLine();
                }
                messagesList.clear();
            }
        }
    }
}
