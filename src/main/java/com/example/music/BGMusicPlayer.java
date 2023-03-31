package com.example.music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * 背景音乐播放线程
 */
public class BGMusicPlayer extends Thread {

    private static final String MUSIC_RES_DIR = "./src/main/resources/music/";
    private static final String BG_MUSIC_FILE_NAME = "bg_music.wav";

    public void run() {
        File soundFile = new File(MUSIC_RES_DIR + BG_MUSIC_FILE_NAME);

        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        SourceDataLine sourceDataLine;
        try {
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        sourceDataLine.start();
        int nBytesRead = 0;
        byte[] abData = new byte[512];
        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    sourceDataLine.write(abData, 0, nBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sourceDataLine.drain();
            sourceDataLine.close();
        }
    }

}
