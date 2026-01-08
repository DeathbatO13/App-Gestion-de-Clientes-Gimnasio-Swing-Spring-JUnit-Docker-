package gm.PowersTrainsGym.gui;

import gm.PowersTrainsGym.modelo.Cliente;
import gm.PowersTrainsGym.servicio.ClienteServicio;
import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class PowerTrainsForm extends JFrame{

    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField membresiaTextField;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private Integer idCliente;

    IClienteServicio clienteServicio;

    private DefaultTableModel tablaModeloClientes;

    @Autowired
    public PowerTrainsForm(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
        guardarButton.addActionListener(e -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSelect();
            }
        });
    }

    private void iniciarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {

        this.tablaModeloClientes = new DefaultTableModel(0, 4);
        String[] cabeceros = {"Id", "Nombre", "Apellido", "Columna"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);
        //Cargar listado clientes
        listarClientes();
    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarClientes();
        clientes.forEach(cliente ->{
            Object[] renglonCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };
            this.tablaModeloClientes.addRow(renglonCliente);
        });
    }

    private void guardarCliente(){
        if(nombreTextField.getText().isEmpty()){
            mostrarMensaje("Proporciona un nombre");
            nombreTextField.requestFocusInWindow();
            return;
        }
        if(membresiaTextField.getText().isEmpty()){
            mostrarMensaje("Proporciona una membresia");
            membresiaTextField.requestFocusInWindow();
            return;
        }

        var cliente = new Cliente();

        cliente.setId(this.idCliente);
        cliente.setNombre(nombreTextField.getText());
        cliente.setApellido(apellidoTextField.getText());
        cliente.setMembresia(Integer.parseInt(membresiaTextField.getText()));

        this.clienteServicio.guardarCliente(cliente);

        if(this.idCliente != null)
            mostrarMensaje("Cliente Actualizado");
        else
            mostrarMensaje("Cliente Agregado");

        limpiarFormulario();

        listarClientes();

    }

    private void cargarClienteSelect(){
        var row = clientesTabla.getSelectedRow();
        //-1 cuando no selecciona nada
        if(row != -1){
            var id = clientesTabla.getModel().getValueAt(row, 0).toString();
            this.idCliente = Integer.parseInt(id);
            var cliente = this.clienteServicio.buscarClientePorId(idCliente);
            this.nombreTextField.setText(cliente.getNombre());
            this.apellidoTextField.setText(cliente.getApellido());
            this.membresiaTextField.setText(cliente.getMembresia().toString());
        }
    }

    private void limpiarFormulario(){
        this.idCliente = null;
        nombreTextField.setText("");
        apellidoTextField.setText("");
        membresiaTextField.setText("");
        this.clientesTabla.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
