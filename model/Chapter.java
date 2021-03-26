/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Uchitachi
 */
public class Chapter {
    private int id;
    private String name;
    private int numberofchapter;
    private String content;
    private Noval idn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberofchapter() {
        return numberofchapter;
    }

    public void setNumberofchapter(int numberofchapter) {
        this.numberofchapter = numberofchapter;
    }

    public Noval getIdn() {
        return idn;
    }

    public void setIdn(Noval idn) {
        this.idn = idn;
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
