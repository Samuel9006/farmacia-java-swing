package forms;

import dtos.ResumenDTO;

import javax.swing.*;

public class PedidoForm extends JFrame {
    private JPanel panelMain;
    private JTextField txtNombreMedicamento;
    private JComboBox<String> cbTipoMedicamento;
    private JTextField txtCantidad;
    private JRadioButton rbCofarma;
    private JRadioButton rbEmpsephar;
    private JRadioButton rbCemefar;
    private JCheckBox cbPrincipal;
    private JCheckBox cbSecundaria;
    private JButton btnBorrar;
    private JButton btnConfirmar;
    private ButtonGroup grupoDistribuidores;

    public PedidoForm() {
        setTitle("Sistema de Pedidos de Medicamentos");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        pack();
        setVisible(true);

        this.createUIComponents();

    }

    private void setButtonActions() {
        btnBorrar.addActionListener(e -> borrarFormulario());
        btnConfirmar.addActionListener(e -> confirmarPedido());
    }

    private void addGrupoDistribuidores() {
        grupoDistribuidores = new ButtonGroup();
        grupoDistribuidores.add(rbCofarma);
        grupoDistribuidores.add(rbEmpsephar);
        grupoDistribuidores.add(rbCemefar);
    }

    private void borrarFormulario() {
        txtNombreMedicamento.setText("");
        cbTipoMedicamento.setSelectedIndex(0);
        txtCantidad.setText("");
        grupoDistribuidores.clearSelection();
        cbPrincipal.setSelected(false);
        cbSecundaria.setSelected(false);
    }

    private void confirmarPedido() {
        String nombre = txtNombreMedicamento.getText().trim();
        String tipo = (String) cbTipoMedicamento.getSelectedItem();
        String cantidadStr = txtCantidad.getText().trim();
        int cantidad;
        String distribuidor = null;
        if (rbCofarma.isSelected()) distribuidor = "Cofarma";
        else if (rbEmpsephar.isSelected()) distribuidor = "Empsephar";
        else if (rbCemefar.isSelected()) distribuidor = "Cemefar";

        boolean sucursalPrincipal = cbPrincipal.isSelected();
        boolean sucursalSecundaria = cbSecundaria.isSelected();

        // Validaciones
        if (nombre.isEmpty() || !nombre.matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(panelMain, "El nombre del medicamento debe contener caracteres alfanuméricos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tipo == null) {
            JOptionPane.showMessageDialog(panelMain, "Debe seleccionar un tipo de medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelMain, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (distribuidor == null) {
            JOptionPane.showMessageDialog(panelMain, "Debe seleccionar un distribuidor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!sucursalPrincipal && !sucursalSecundaria) {
            JOptionPane.showMessageDialog(panelMain, "Debe seleccionar al menos una sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mostrar resumen del pedido
        ResumenDTO resumenDTO = new ResumenDTO();
        resumenDTO.setNombre(nombre);
        resumenDTO.setTipo(tipo);
        resumenDTO.setCantidad(cantidad);
        resumenDTO.setDistribuidor(distribuidor);
        resumenDTO.setSucursalPrincipal(sucursalPrincipal);
        resumenDTO.setSucursalSecundaria(sucursalSecundaria);

        ResumenPedido resumenPedido = new ResumenPedido(resumenDTO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PedidoForm::new);
    }

    private void createUIComponents() {
        this.addGrupoDistribuidores();
        this.setButtonActions();
    }
}
