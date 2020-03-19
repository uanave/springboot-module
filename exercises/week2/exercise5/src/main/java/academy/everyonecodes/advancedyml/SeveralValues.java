package academy.everyonecodes.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@ConfigurationProperties("advanced.several")
@Service
public class SeveralValues {
    private List<Integer> naturalNumbers;
    private List<Double> decimalNumbers;
    private List<String> words;
    private List<Boolean> choices;

    public List<Integer> getNaturalNumbers() {
        return naturalNumbers;
    }

    void setNaturalNumbers(List<Integer> naturalNumbers) {
        this.naturalNumbers = naturalNumbers;
    }

    public List<Double> getDecimalNumbers() {
        return decimalNumbers;
    }

    void setDecimalNumbers(List<Double> decimalNumbers) {
        this.decimalNumbers = decimalNumbers;
    }

    public List<String> getWords() {
        return words;
    }

    void setWords(List<String> words) {
        this.words = words;
    }

    public List<Boolean> getChoices() {
        return choices;
    }

    void setChoices(List<Boolean> choices) {
        this.choices = choices;
    }
}
