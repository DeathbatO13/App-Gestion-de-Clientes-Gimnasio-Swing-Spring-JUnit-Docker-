package gm.PowersTrainsGym;

import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class PowersTrainsGymApplication implements CommandLineRunner {

    @Autowired
    private IClienteServicio clienteServicio;

    private static final Logger logger =
           LoggerFactory.getLogger(PowersTrainsGymApplication.class);

    String nl = System.lineSeparator();

	public static void main(String[] args){

        logger.info("Iniciando la aplicación");
        //Levantar fabrica Spring
        SpringApplication.run(PowersTrainsGymApplication.class, args);
        logger.info("Finalizado");
	}

    @Override
    public void run(String... args) throws Exception {

        powerTrainsApp();
    }

    private void powerTrainsApp(){

        logger.info(nl + nl + "*** App PowerTrains Gym *** " + nl + nl);

        var salir = false;
        var consola = new Scanner(System.in);

        while( !salir ){
            var opcion = mostrarMenu(consola);
            //salir = ejecutarOpciones(consola, opcion);
            logger.info(nl);
        }
    }

    private int mostrarMenu(Scanner consola){
        logger.info("""
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opción: \s
                """);

        return Integer.parseInt(consola.nextLine());
    }
}
