package forms;

import dtos.ResumenDTO;

import javax.swing.*;
import java.awt.*;

public class ResumenPedido extends JFrame {
    public ResumenPedido(ResumenDTO resumenDTO) {

        setTitle("Pedido al distribuidor "+resumenDTO.getDistribuidor());
        setSize(400, 300);
        setLayout(new GridLayout(3, 1, 10, 10));

        StringBuilder pedido = new StringBuilder();
        pedido.append(resumenDTO.getCantidad()).append(" unidades del ")
                .append(resumenDTO.getTipo()).append(" ").append(resumenDTO.getNombre());

        String direccion = "Para la farmacia situada en";
        if (resumenDTO.isSucursalPrincipal()) {
            direccion += " Calle 19 # 3 52";
        }
        if (resumenDTO.isSucursalPrincipal() && resumenDTO.isSucursalSecundaria()) {
            direccion += " y";
        }
        if (resumenDTO.isSucursalSecundaria()) {
            direccion += " Cra 54 No. 32";
        }

        add(new JLabel(pedido.toString(), SwingConstants.CENTER));
        add(new JLabel(direccion, SwingConstants.CENTER));

        JPanel panelBotones = new JPanel();
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnEnviar = new JButton("Enviar");
        panelBotones.add(btnCancelar);
        panelBotones.add(btnEnviar);
        add(panelBotones);

        btnCancelar.addActionListener(e -> dispose());
        btnEnviar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pedido enviado con exito!");
            dispose();
        });

        setVisible(true);
    }
}
