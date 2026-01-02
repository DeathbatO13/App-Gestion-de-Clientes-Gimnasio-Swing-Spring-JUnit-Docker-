package gm.PowersTrainsGym;

import gm.PowersTrainsGym.modelo.Cliente;
import gm.PowersTrainsGym.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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

    private boolean ejecutarOpciones(Scanner consola, int opcion){
        var salir = false;
        switch(opcion){

            case 1 -> {
                logger.info(nl + " --- Listado de Clientes: --- "+ nl);
                List<Cliente> clientes = clienteServicio.listarClientes();
                clientes.forEach(cliente -> logger.info(cliente.toString()));
            }

            case 2 -> {
                logger.info(nl + "--- Buscar por id ---- " + nl);
                logger.info("Id para buscar: ");
                var idCliente  = Integer.parseInt(consola.nextLine());
                Cliente res = clienteServicio.buscarClientePorId(idCliente);
                if(res != null)
                    logger.info("Cliente encontrado:" + res + nl);
                else
                    logger.info("Cliente no encontrado" + nl);
            }
        }
        return salir;
    }

    private void powerTrainsApp(){

        logger.info(nl + nl + "*** App PowerTrains Gym *** " + nl + nl);

        var salir = false;
        var consola = new Scanner(System.in);

        while( !salir ){
            var opcion = mostrarMenu(consola);
            salir = ejecutarOpciones(consola, opcion);
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
