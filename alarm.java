import java.time.LocalTime;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;

public class AlarmClock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter alarm time (HH:MM): ");
        String alarmTime = sc.nextLine();

        while (true) {
            LocalTime currentTime = LocalTime.now();
            String now = String.format("%02d:%02d",
                    currentTime.getHour(),
                    currentTime.getMinute());

            System.out.println("Current Time: " + now);

            if (now.equals(alarmTime)) {
                System.out.println("⏰ Alarm Ringing!");

                try {
                    File soundFile = new File("alarm.wav"); // Place alarm.wav in project folder
                    AudioInputStream audioStream =
                            AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                } catch (Exception e) {
                    System.out.println("Unable to play sound.");
                }

                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
