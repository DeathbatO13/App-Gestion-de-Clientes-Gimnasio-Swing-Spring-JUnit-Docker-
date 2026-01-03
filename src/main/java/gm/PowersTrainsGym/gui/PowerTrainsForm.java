package gm.PowersTrainsGym.gui;

import gm.PowersTrainsGym.servicio.ClienteServicio;
import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class PowerTrainsForm extends JFrame{

    private JPanel panelPrincipal;

    IClienteServicio clienteServicio;

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


}
