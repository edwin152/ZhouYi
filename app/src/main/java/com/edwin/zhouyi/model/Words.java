package com.edwin.zhouyi.model;

/**
 * simple describe
 *
 * @author edwin
 * @since 27/12/2017
 */
public class Words {

    // 初九 初六
    public static final int NUMBER_FIRST = 1;
    // 九二 六二
    public static final int NUMBER_SECOND = 2;
    // 九三 六三
    public static final int NUMBER_THIRD = 3;
    // 九四 六四
    public static final int NUMBER_FOURTH = 4;
    // 九五 六五
    public static final int NUMBER_FIFTH = 5;
    // 上九 上六
    public static final int NUMBER_SIXTH = 6;
    // 用九 用六
    public static final int NUMBER_USE = -1;
    // 空
    public static final int NUMBER_NULL = -2;

    private int number;
    private boolean yang;
    private String words;
    private String explainWords;

    public Words(int number, boolean yang, String words, String explainWords) {
        if (number != NUMBER_FIRST
                && number != NUMBER_SECOND
                && number != NUMBER_THIRD
                && number != NUMBER_FOURTH
                && number != NUMBER_FIFTH
                && number != NUMBER_SIXTH
                && number != NUMBER_USE
                && number != NUMBER_NULL) {
            throw new IndexOutOfBoundsException("num should use \"Words.NUMBER_*\"");
        }
        this.number = number;
        this.yang = yang;
        this.words = words;
        this.explainWords = explainWords;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        switch (number) {
            case NUMBER_FIRST:
                builder.append("初").append(yang ? "九" : "六");
                break;
            case NUMBER_SECOND:
                builder.append(yang ? "九" : "六").append("二");
                break;
            case NUMBER_THIRD:
                builder.append(yang ? "九" : "六").append("三");
                break;
            case NUMBER_FOURTH:
                builder.append(yang ? "九" : "六").append("四");
                break;
            case NUMBER_FIFTH:
                builder.append(yang ? "九" : "六").append("五");
                break;
            case NUMBER_SIXTH:
                builder.append("上").append(yang ? "九" : "六");
                break;
            case NUMBER_USE:
                builder.append("用").append(yang ? "九" : "六");
                break;
            case NUMBER_NULL:
            default:
                break;
        }
        builder.append(": ").append(words).append("\n")
                .append("象曰: ").append(explainWords);
        return builder.toString();
    }
}
