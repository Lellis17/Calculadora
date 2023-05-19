import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculadora extends JFrame implements ActionListener {

        private JTextField display;

        public Calculadora() {
            setTitle("Calculadora");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            display = new JTextField();
            display.setEditable(false);
            add(display, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 4));

            String[] buttons = {
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"
            };

            for (String button : buttons) {
                JButton btn = new JButton(button);
                btn.addActionListener(this);
                panel.add(btn);
            }

            add(panel, BorderLayout.CENTER);

            pack();
            setLocationRelativeTo(null);
        }

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            if (action.equals("=")) {
                String expression = display.getText();

                try {
                    double result = eval(expression);
                    display.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    display.setText("Erro");
                }
            } else {
                display.setText(display.getText() + action);
            }
        }

        private double eval(String expression) {
            // Implemente aqui a lógica para avaliar a expressão matemática
            // Você pode usar bibliotecas como o ScriptEngine ou implementar seu próprio avaliador de expressões
            // Este é apenas um exemplo básico
            return 0;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Calculadora().setVisible(true);
                }
            });
        }
    }
}