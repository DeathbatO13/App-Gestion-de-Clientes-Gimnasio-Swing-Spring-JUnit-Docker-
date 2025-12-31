package gm.PowersTrainsGym;

import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class PowersTrainsGymApplication implements CommandLineRunner {

    @Autowired
    private IClienteServicio clienteServicio;

    private static final Logger logger =
           LoggerFactory.getLogger(PowersTrainsGymApplication.class);

	public static void main(String[] args){

        logger.info("Iniciando la aplicación");
        //Levantar fabrica Spring
        SpringApplication.run(PowersTrainsGymApplication.class, args);
        logger.info("Finalizado");
	}

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** App PowerTrains Gym *** ");


    }
}
