package com.picsart.Lesson7.bookStoreLibrary.utils;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileProvider {

    public static String[] getFileFromPath(String fileName) throws IOException {

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException("File Not found " + e.getMessage());
        }

        return lines.toArray(new String[0]);
    }

}
