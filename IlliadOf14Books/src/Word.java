/**
 * A class with a string associated to it ("word").
 * Mainly used for checking if a given string is a word.
 * The comparison method ignores special symbols and case of the given string as it checks purely for if the alphanumeric characters match in the correct pattern and if there are no other alphanumeric characters in the given string.
 */
public class Word {
    private final String word;

    /**
     * Creates a new word object given a string
     * @param word - the string associated with the Word. It will always be in lowercase.
     */
    public Word(String word){
        this.word = word.toLowerCase();
    }

    /**
     * @return the string associated with this word
     */
    public String getWord(){
        return this.word;
    }

    /**
     * Checks if a given string is equal to the string associated with this word
     * This ignores lowercase & special symbols
     * @param compareTo - the string to compare the word with
     * @return true if they are equal, or false if they are not
     */
    public boolean stringIsWord(String compareTo){
        boolean hasWord = false;
        compareTo = compareTo.toLowerCase();
        if(compareTo.contains(word)){
            compareTo = compareTo.replace(word, "");
            if(compareTo.matches("^[^a-zA-Z0-9]*$")){
                hasWord = true;
            }
        }
        return hasWord;
    }

    /**
     * Compares two Word objects by comparing the two string associated with the words to see if they are equal
     * @param compareTo - Word to compare to
     * @return whether or not they are equal
     */
    @Override
    public boolean equals(Object compareTo){
        if(compareTo instanceof Word){
            Word comparedWord = (Word) compareTo;
            return stringIsWord(comparedWord.getWord());
        }
        return false;
    }

    /**
     * @return a hashcode based on the string associated with this word
     */
    @Override
    public int hashCode(){
        return this.word.hashCode();
    }

    /**
     * @return the string associated with this word
     */
    @Override
    public String toString(){
        return getWord();
    }
}
