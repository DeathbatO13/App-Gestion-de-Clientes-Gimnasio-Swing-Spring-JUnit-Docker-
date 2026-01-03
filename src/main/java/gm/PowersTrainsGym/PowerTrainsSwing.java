package gm.PowersTrainsGym;


import com.formdev.flatlaf.FlatDarculaLaf;
import gm.PowersTrainsGym.gui.PowerTrainsForm;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


import javax.swing.*;

@SpringBootApplication
public class PowerTrainsSwing {

    public static void main(String[] args) {
        //Configurar modo Oscuro
        FlatDarculaLaf.setup();
        //Instancia la fabrica de Spring
        ConfigurableApplicationContext contextToSpring =
                new SpringApplicationBuilder(PowerTrainsSwing.class).headless(false)
                        .web(WebApplicationType.NONE).run(args);

        //Crear el objeto de Swing
        SwingUtilities.invokeLater(()->{
            PowerTrainsForm powerTrainsForm = contextToSpring.getBean(PowerTrainsForm.class);
            powerTrainsForm.setVisible(true);
        });
    }
}
