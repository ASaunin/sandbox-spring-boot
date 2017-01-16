package annotations.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    private String speech = "hello";

    public void speak() {
        System.out.println(speech);
    }

    @Autowired
    public void setSpeech(@Value("#{randomText.getText()}") String speech) {
        this.speech = speech;
    }

}
