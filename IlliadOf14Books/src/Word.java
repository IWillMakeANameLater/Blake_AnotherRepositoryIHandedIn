public class Word {
    private final String word;

    public Word(String word){
        this.word = word;
    }

    public String getWord(){
        return this.word;
    }

    public boolean stringIsWord(String compareTo){
        boolean hasWord = false;
        compareTo = compareTo.toLowerCase();
        String selfWord = this.word.toLowerCase();
        if(compareTo.contains(selfWord)){
            compareTo = compareTo.replace(selfWord, "");
            if(compareTo.matches("^[^a-zA-Z0-9]*$")){
                hasWord = true;
            }
        }
        return hasWord;
    }

    @Override
    public boolean equals(Object compareTo){
        if(compareTo instanceof Word){
            Word comparedWord = (Word) compareTo;
            return stringIsWord(comparedWord.getWord());
        }
        return false;
    }

    @Override
    public String toString(){
        return getWord();
    }
}
