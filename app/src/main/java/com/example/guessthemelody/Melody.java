package com.example.guessthemelody;

public class Melody {
    private String name;
    private int answe; // Правильный ответ
    private int level;

    public Melody(String name, int answe, int level) {
        this.name = name;
        this.answe = answe;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnswe() {
        return answe;
    }

    public void setAnswe(int answe) {
        this.answe = answe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
