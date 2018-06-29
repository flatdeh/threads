package com.vlad.threads.messagessaver;

import java.util.ArrayList;
import java.util.Scanner;

public class StringsToFile {
    public static void main(String[] args) {
        ArrayList<String> messagesList = new ArrayList<String>();
        StringSaverThread stringSaverThread = new StringSaverThread(messagesList);

        stringSaverThread.start();

        try(Scanner in = new Scanner(System.in)) {
            while (true) {
                messagesList.add(in.next());
            }
        }
    }
}

