import forms.PedidoForm;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PedidoForm::new);
    }
}
