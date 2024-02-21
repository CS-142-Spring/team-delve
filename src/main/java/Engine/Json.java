package main.java.Engine;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

class Data {
    public int strength;
}

public class Json {


    public static void loadJson(String path) {

        ObjectMapper mapper = new ObjectMapper();
        // String jsonData = "";

        try {

            Data strength = mapper.readValue(new File(path), Data.class);
        //     File file = new File(path);
        //     Scanner reader = new Scanner(file);
        //
        //     while (reader.hasNextLine()) {
        //
        //         String line = reader.nextLine();
        //         jsonData += line;
        //     }
        //
        //     reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
