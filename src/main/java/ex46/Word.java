package ex46;


/*Word Class which holds a word and its frequency*/
public class Word implements Comparable<Word>{
    private final String word;
    private int frequency;

    public Word(String word) {
        this.word = word;
        this.frequency = 0;
    }

    /*Getter and Setters*/
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    //Method override in order to sort each word based on the frequency in descending order
    @Override
    public int compareTo(Word u) {
        if (getFrequency() == 0 || u.getFrequency() == 0) {
            return 0;
        }
        return u.getFrequency().compareTo(getFrequency());
    }
}
