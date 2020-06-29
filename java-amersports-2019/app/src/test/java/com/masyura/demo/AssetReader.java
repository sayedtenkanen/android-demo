package com.masyura.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class AssetReader {

    public String getText(String fileName) {

        StringBuilder result = new StringBuilder();
        ClassLoader classLoader = getClass().getClassLoader();

        if (classLoader != null) {
            File file = new File(classLoader.getResource(fileName).getFile());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }
}