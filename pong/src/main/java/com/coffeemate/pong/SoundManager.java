import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.*;
public class SoundManager {

    ArrayList<String> hits;
    String scoreSound;

    public SoundManager() {
        //Sets up array to randomly play a hit sound
        hits = new ArrayList<String>();
        hits.add("Hit_1");
        hits.add("Hit_2");
        scoreSound = "Score";
    }

    public void play(boolean score, boolean hit) {
        try {
            int randomFile = (int) (Math.random() * 2);
            AudioInputStream clipHits = AudioSystem.getAudioInputStream(new File(hits.get(randomFile) + ".wav"));
            AudioInputStream clipScore = AudioSystem.getAudioInputStream(new File(scoreSound + ".wav"));

            Clip clip = AudioSystem.getClip();

            //Selects audioclip based on what happens
            if(score) {
                clip.open(clipScore);
            } else if(hit) {
               clip.open(clipHits);
            }
            //System.out.println("*PING!*");

            //Plays audio, by stopping program for a few millisecs
            clip.start();
            long dura = 10;
            Thread.sleep(dura);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}