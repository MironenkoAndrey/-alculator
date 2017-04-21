package com.soft.mironenko.calculator;

/**
 * Created by romanmarshchakin on 21.04.17.
 */

public class Calculator {
    private String expresion;
    private int token;
    private int position = -1;

    private void nextChar() {
        position++;
        if (expresion.length() > position) {
            token = expresion.charAt(position);
        } else {
            token = -1;
        }
        if (token == ' ') {
            nextChar();
        }
    }

    public double parse(String input) {
        expresion = input;
        nextChar();
        double result = executeLowLevel();
        return result;
    }

    private double executeLowLevel() {
        double result = executeMediumLevel();
        while(true) {
            if(check('+')) {
                result = result + executeMediumLevel();
            } else if(check('-')) {
                result = result - executeMediumLevel();
            } else {
                return result;
            }
        }
    }

    private boolean check(char symbol) {
        if(token == symbol) {
            nextChar();
            return true;
        } else {
            return false;
        }
    }

    private double executeMediumLevel() {
        double result = executeHighLevel();
        while(true) {
            if(check('*')) {
                result = result * executeHighLevel();
            } else if(check('/')) {
                result = result / executeHighLevel();
            } else {
                return result;
            }
        }
    }

    private double executeHighLevel() {
        if(check('(')) {
            double result = executeLowLevel();
            check(')');
            return result;
        } else if(token >= '0' && token <= '9') {
            String number = "";
            while (token >= '0' && token <= '9'){
                number += String.valueOf((char) token);
                nextChar();
            }
            return Double.parseDouble(number);
        }
        return 1;
    }
}
