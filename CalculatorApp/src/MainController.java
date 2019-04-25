import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class MainController {

    @FXML
    public Button zero;
    public Button one;
    public Button two;
    public Button three;
    public Button four;
    public Button five;
    public Button six;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button point;
    public Button clear;
    public Button plus;
    public Button minus;
    public Button divide;
    public Button multiply;
    public Button equal;
    public TextField textField;
    public Label label;

    private String expression = "";
    private String result = "";

    public boolean isEndsWithOperator(String line) {
        return (line.endsWith("+") || line.endsWith("-") || line.endsWith("/") || line.endsWith("x"));
    }

    public void pointClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        if (oldValue.contains(".")) {
            textField.setText(oldValue);
        } else {
            String set = ".";
            textField.setText(oldValue + set);
            expression += set;
        }
    }

    public void zeroClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "0";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void oneClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "1";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void twoClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "2";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void threeClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "3";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void fourClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "4";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void fiveClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "5";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void sixClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "6";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void sevenClick() {
        if (textField.getText().equals("Error") || (!isEndsWithOperator(label.getText()) && !label.getText().equals(""))) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "7";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void eightClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "8";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void nineClick() {
        if (textField.getText().equals("Error") || !isEndsWithOperator(label.getText()) && !label.getText().equals("")) {
            clearClick();
        }
        String oldValue = textField.getText();
        String set = "9";
        textField.setText(oldValue + set);
        expression += set;
    }

    public void plusClick() {
        if (textField.getText().equals("Error")) {
            clearClick();
        } else if (isEndsWithOperator(expression)) {
            expression = expression.substring(0, expression.length() - 1);
            String newLabel = label.getText().substring(0, label.getText().length() - 1);
            label.setText(newLabel + "+");
        } else if (result.equals("")) {
            String value = textField.getText();
            textField.setText("");
            String oldLabel = label.getText();
            label.setText(oldLabel + Double.parseDouble(value) + "+");
        } else {
            label.setText(expression + "+");
            textField.setText("");
        }
        expression += "+";
    }

    public void minusClick() {
        if (textField.getText().equals("Error")) {
            clearClick();
        } else if (isEndsWithOperator(expression)) {
            expression = expression.substring(0, expression.length() - 1);
            String newLabel = label.getText().substring(0, label.getText().length() - 1);
            label.setText(newLabel + "-");
        } else if (result.equals("")) {
            String value = textField.getText();
            textField.setText("");
            String oldLabel = label.getText();
            label.setText(oldLabel + Double.parseDouble(value) + "-");
        } else {
            label.setText(result + "-");
            textField.setText("");
        }
        expression += "-";
    }

    public void divideClick() {
        if (textField.getText().equals("Error")) {
            clearClick();
        } else if (isEndsWithOperator(expression)) {
            expression = expression.substring(0, expression.length() - 1);
            String newLabel = label.getText().substring(0, label.getText().length() - 1);
            label.setText(newLabel + "/");
        } else if (result.equals("")) {
            String value = textField.getText();
            textField.setText("");
            String oldLabel = label.getText();
            label.setText(oldLabel + Double.parseDouble(value) + "/");
        } else {
            label.setText(result + "/");
            textField.setText("");
        }
        expression += "/";
    }

    public void multiplyClick() {
        if (textField.getText().equals("Error")) {
            clearClick();
        } else if (isEndsWithOperator(expression)) {
            expression = expression.substring(0, expression.length() - 1);
            String newLabel = label.getText().substring(0, label.getText().length() - 1);
            label.setText(newLabel + "x");
        } else if (result.equals("")) {
            String value = textField.getText();
            textField.setText("");
            String oldLabel = label.getText();
            label.setText(oldLabel + Double.parseDouble(value) + "x");
        } else {
            label.setText(result + "x");
            textField.setText("");
        }
        expression += "x";
    }

    public void clearClick() {
        textField.setText("");
        label.setText("");
        expression = "";
        result = "";
    }

    private int getPriority(char symbol) {
        if (symbol == 'x' || symbol == '/') {
            return 3;
        } else if (symbol == '+' || symbol == '-') {
            return 2;
        } else if (isDigit(symbol)) {
            return 1;
        } else {
            return 0;
        }
    }

    public String expToRPN(String expr) {
        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;
        for (int i = 0; i < expr.length(); i++) {
            priority = getPriority(expr.charAt(i));
            if (priority <= 1 || (priority > 1 && i == 0)) {
                current += expr.charAt(i);
            } else {
                current += " ";
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current += stack.pop();
                    } else break;
                }
                stack.push(expr.charAt(i));
            }
        }
        while (!stack.empty()) current += stack.pop();
        return current;
    }

    private BigDecimal rpntoAnswer(String rpn) {
        String operand = "";
        Stack<BigDecimal> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if (getPriority(rpn.charAt(i)) <= 1 || (getPriority(rpn.charAt(i)) > 1 && i == 0)) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) <= 1 || (getPriority(rpn.charAt(i)) > 1 && i == 0)) {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(new BigDecimal(operand));
                operand = "";
            }
            if (getPriority(rpn.charAt(i)) > 1 && i != 0) {
                BigDecimal a = stack.pop();
                BigDecimal b = stack.pop();
                MathContext mc = new MathContext(10);
                if (rpn.charAt(i) == '+') {
                    stack.push(b.add(a, mc));
                } else if (rpn.charAt(i) == '-') {
                    stack.push(b.add(a.negate(mc)));
                } else if (rpn.charAt(i) == 'x') {
                    stack.push(b.multiply(a, mc));
                } else if (rpn.charAt(i) == '/') {
                    if (a.compareTo(BigDecimal.ZERO) == 0) {
                        textField.setText("Error");
                        throw new IllegalArgumentException("Zero division exception");
                    } else {
                        stack.push(b.divide(a, mc));
                    }
                }
            }
        }
        return stack.pop();
    }

    public void equalClick() {
        String oldLabel = label.getText();
        if (!oldLabel.equals("") && !expression.equals(result)) {
            label.setText(oldLabel + Double.parseDouble(textField.getText()));
            result = rpntoAnswer(expToRPN(expression)).toString();
            textField.setText(result);
        }
        expression = result;
    }
}
