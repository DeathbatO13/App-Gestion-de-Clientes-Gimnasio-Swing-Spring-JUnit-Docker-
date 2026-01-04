package gm.PowersTrainsGym.gui;

import gm.PowersTrainsGym.servicio.ClienteServicio;
import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@Component
public class PowerTrainsForm extends JFrame{

    private JPanel panelPrincipal;
    private JTable clientesTabla;

    IClienteServicio clienteServicio;

    private DefaultTableModel tablaModeloClientes;

    @Autowired
    public PowerTrainsForm(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
    }

    private void iniciarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.tablaModeloClientes = new DefaultTableModel(0, 4);
        String[] cabeceros = {"Id", "Nombre", "Apellido", "Columna"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);
    }
}
