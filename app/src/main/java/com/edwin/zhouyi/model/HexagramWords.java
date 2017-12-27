package com.edwin.zhouyi.model;

import com.edwin.zhouyi.enums.Diagram;

/**
 * simple describe
 *
 * @author edwin
 * @since 27/12/2017
 */
public class HexagramWords {

    private int number;
    private Diagram upDiagram;
    private Diagram downDiagram;
    private String title;
    private String describe;
    private Words total;
    private Words first;
    private Words second;
    private Words third;
    private Words fourth;
    private Words fifth;
    private Words sixth;
    private Words use;

    public HexagramWords(int number) {
        if (number < 1 || number > 64) {
            throw new IndexOutOfBoundsException("number should between 1 to 64");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Diagram getUpDiagram() {
        return upDiagram;
    }

    public void setUpDiagram(Diagram upDiagram) {
        this.upDiagram = upDiagram;
    }

    public Diagram getDownDiagram() {
        return downDiagram;
    }

    public void setDownDiagram(Diagram downDiagram) {
        this.downDiagram = downDiagram;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Words getTotal() {
        return total;
    }

    public void setTotal(Words total) {
        this.total = total;
    }

    public Words getFirst() {
        return first;
    }

    public void setFirst(Words first) {
        this.first = first;
    }

    public Words getSecond() {
        return second;
    }

    public void setSecond(Words second) {
        this.second = second;
    }

    public Words getThird() {
        return third;
    }

    public void setThird(Words third) {
        this.third = third;
    }

    public Words getFourth() {
        return fourth;
    }

    public void setFourth(Words fourth) {
        this.fourth = fourth;
    }

    public Words getFifth() {
        return fifth;
    }

    public void setFifth(Words fifth) {
        this.fifth = fifth;
    }

    public Words getSixth() {
        return sixth;
    }

    public void setSixth(Words sixth) {
        this.sixth = sixth;
    }

    public Words getUse() {
        return use;
    }

    public void setUse(Words use) {
        this.use = use;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HexagramWords)) {
            return false;
        }
        HexagramWords another = (HexagramWords) obj;
        return number == another.number;
    }
}
