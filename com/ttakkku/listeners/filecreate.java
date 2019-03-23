package com.ttakkku.listeners;

import java.io.*;


public class filecreate  {
    public void CreateNewfile() {
        File filename = new File("plugins/Bot/token.yml");
        File foler_Location = new File("plugins/Bot");
        try {
            if (!filename.exists()) {
                foler_Location.mkdir();
                filename.createNewFile();
                BufferedWriter w = new BufferedWriter(new FileWriter(filename));
                w.append("");
                w.flush();
                w.close();
            }
        } catch (IOException localToException) {
        }
    }
}
