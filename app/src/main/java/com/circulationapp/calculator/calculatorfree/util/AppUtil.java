package com.circulationapp.calculator.calculatorfree.util;

public class AppUtil {
    public static final int EXCEPTION = -1;
    public static final int IS_CLOSE_PARENTHESIS = 3;
    public static final int IS_DOT = 4;
    public static final int IS_NUMBER = 0;
    public static final int IS_OPEN_PARENTHESIS = 2;
    public static final int IS_OPERATOR = 1;

    public static int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return 0;
        } catch (NumberFormatException e) {
            if (lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("x") || lastCharacter.equals("÷") || lastCharacter.equals("%")) {
                return 1;
            }
            if (lastCharacter.equals("(")) {
                return 2;
            }
            if (lastCharacter.equals(")")) {
                return 3;
            }
            if (lastCharacter.equals(".")) {
                return 4;
            }
            return -1;
        }
    }

    public static void saveLastExpression(String lastExpression, String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(input.length() - 1));
        String str = "";
        sb.append(str);
        String lastOfExpression = sb.toString();
        if (input.length() > 1) {
            String str2 = ")";
            if (lastOfExpression.equals(str2)) {
                String lastExpression2 = ")";
                int numberOfCloseParenthesis = 1;
                for (int i = input.length() - 2; i >= 0; i--) {
                    if (numberOfCloseParenthesis > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(input.charAt(i));
                        sb2.append(str);
                        String last = sb2.toString();
                        if (last.equals(str2)) {
                            numberOfCloseParenthesis++;
                        } else if (last.equals("(")) {
                            numberOfCloseParenthesis--;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(last);
                        sb3.append(lastExpression2);
                        lastExpression2 = sb3.toString();
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(input.charAt(i));
                        sb4.append(str);
                        if (defineLastCharacter(sb4.toString()) == 1) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(input.charAt(i));
                            sb5.append(lastExpression2);
                            String lastExpression3 = sb5.toString();
                            return;
                        }
                        lastExpression2 = "";
                    }
                }
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append(lastOfExpression);
            sb6.append(str);
            if (defineLastCharacter(sb6.toString()) == 0) {
                String lastExpression4 = lastOfExpression;
                for (int i2 = input.length() - 2; i2 >= 0; i2--) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(input.charAt(i2));
                    sb7.append(str);
                    String last2 = sb7.toString();
                    if (defineLastCharacter(last2) == 0 || defineLastCharacter(last2) == 4) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(last2);
                        sb8.append(lastExpression4);
                        lastExpression4 = sb8.toString();
                    } else if (defineLastCharacter(last2) == 1) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(last2);
                        sb9.append(lastExpression4);
                        String lastExpression5 = sb9.toString();
                        return;
                    }
                    if (i2 == 0) {
                        lastExpression4 = "";
                    }
                }
            }
        }
    }
}
