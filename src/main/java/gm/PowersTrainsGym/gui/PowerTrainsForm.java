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
    }
}
