package Calculator.InputHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used for handling all of the key inputs in the keyboard. Since the text fields are non editable, They key bindings
 * created here are only limited to the numbers and operators available inside the calculator.
 */

public class KeyHandling extends ButtonHandling implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_9 && e.getKeyCode() == KeyEvent.VK_SHIFT)
            inputString(" ( ");
        if (e.getKeyCode() == KeyEvent.VK_0 && e.getKeyCode() == KeyEvent.VK_SHIFT)
            inputString(" ) ");
        if (e.getKeyCode() == KeyEvent.VK_DIVIDE || e.getKeyCode() == KeyEvent.VK_SLASH)
            inputOperator('/');
        if (e.getKeyCode() == KeyEvent.VK_ASTERISK || e.getKeyCode() == KeyEvent.VK_MULTIPLY)
            inputOperator('*');
        if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT)
            inputOperator('-');
        if (e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_PLUS)
            inputOperator('+');
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_EQUALS)
            showResult();
        if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
            inputString("1");
        if (e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
            inputString("2");
        if (e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
            inputString("3");
        if (e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
            inputString("4");
        if (e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
            inputString("5");
        if (e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
            inputString("6");
        if (e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
            inputString("7");
        if (e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
            inputString("8");
        if (e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
            inputString("9");
        if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
            inputString("0");
        if (e.getKeyCode() == KeyEvent.VK_PERIOD || e.getKeyCode() == KeyEvent.VK_DECIMAL)
            inputString(".");
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            try {
                inputField.setText(input.deleteCharAt(input.toString().length() - 1).toString());
            } catch (Exception ex) {
                System.out.println("no number left");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            input.delete(0, input.toString().length());
            output.delete(0, output.toString().length());

            inputField.setText("0");
            runningResultField.setText("");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
