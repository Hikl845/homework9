package org.example;

public class MyArrayList {
    private String[] massiveOfWords = new String[0];

    public String[] add(Object value) {
        String[] newValues = new String[massiveOfWords.length + 1];

        for (int i = 0; i < massiveOfWords.length; i++) {
            newValues[i] = massiveOfWords[i];
        }

        newValues[massiveOfWords.length] = String.valueOf(value);
        massiveOfWords = newValues;
        return massiveOfWords;
    }

    public String[] remove(int index) {
        if (index < 0 || index >= massiveOfWords.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        String[] newValues = new String[massiveOfWords.length - 1];
        int newIndex = 0;

        for (int i = 0; i < massiveOfWords.length; i++) {
            if (i != index) {
                newValues[newIndex++] = massiveOfWords[i];
            }
        }

        massiveOfWords = newValues;
        return massiveOfWords;
    }

    public String[] clear() {
        massiveOfWords = new String[0];
        return massiveOfWords;
    }

    public int size() {
        return massiveOfWords.length;
    }

    public String get(int index) {
        if (index < 0 || index >= massiveOfWords.length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return massiveOfWords[index];
    }

}
