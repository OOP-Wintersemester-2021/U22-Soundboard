import de.ur.mi.oop.audio.AudioClip;

public class SoundsPlayer {

    private static AudioClip dog = new AudioClip("src/audio/dog_bark.wav");
    private static AudioClip cat = new AudioClip("src/audio/cat_meow.wav");
    private static AudioClip bear = new AudioClip("src/audio/bear_growl.wav");
    private static AudioClip lion = new AudioClip("src/audio/lion_breathing.wav");
    private static AudioClip cricket = new AudioClip("src/audio/cricket_chirping.wav");
    private static AudioClip bird = new AudioClip("src/audio/bird_whisteling.wav");
    private static AudioClip horse = new AudioClip("src/audio/horse_whinny.wav");
    private static AudioClip pig = new AudioClip("src/audio/pig_snorring.wav");
    private static AudioClip elephant = new AudioClip("src/audio/elephant_voice.wav");

    // Geräusch von Juan Merie Venter, freesound.org, CC-3.0-Lizenz
    public static void playDog() {
        dog.play();
    }

    // Geräusch von tuberantanka, freesound.org, CC-0-Lizenz
    public static void playCat() {
        cat.play();
    }

    // Geräusch von Nivatius, freesound.org, CC-0-Lizenz
    public static void playBear() {
        bear.play();
    }

    // Geräusch von GJ55GB, freesound.org, CC-0-Lizenz
    public static void playLion() {
        lion.play();
    }

    // Geräusch von trouby, freesound.org, CC-3.0-Lizenz
    public static void playCricket() {
        cricket.play();
    }

    // Geräusch von InspectorJ, freesound.org, CC-3.0-Lizenz
    public static void playBird() {
        bird.play();
    }

    // Geräusch von InspectorJ, freesound.org, CC-3.0-Lizenz
    public static void playHorse() {
        horse.play();
    }

    // Geräusch von yottasounds, freesound.org, CC-3.0-Lizenz
    public static void playPig() {
        pig.play();
    }


    public static void playElephant() {
        elephant.play();
    }

}
