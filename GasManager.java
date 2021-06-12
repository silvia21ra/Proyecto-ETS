package ETS;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

/**
 * @author silvi
 *
 */
public class GasManager {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Estas son las variables
		String nombreUsuario;
		Double saldo;
		int tipoTarifa;
		char opcion;

		//Pide el nombre
		nombreUsuario = JOptionPane.showInputDialog("Introduza su nombre");

		//Pide el saldo
		do {
			saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduza  saldo mayor 20€"));
		}

		while (saldo <= 20);
		
		//Pide la tarifa, 1 o 2
		do {
			
			tipoTarifa = Integer.parseInt(JOptionPane.showInputDialog("Introduza el tipo tarifa"));
		}

		while (tipoTarifa < 1 || tipoTarifa > 2);

		
		
		

		//Se crea el cliente
		claseGasCliente cliente1 = new claseGasCliente(nombreUsuario, saldo, tipoTarifa);

		//Menú
		do {
			opcion = JOptionPane.showInputDialog(
					"1)Introducir recarga \n 2)Introducir gas gastado \n 3)Obtener saldo \n 4)Obtener datos totales \n 5)obtener factura \n 6)Obtener gráfica \n 7)s= salir")
					.charAt(0);

			switch (opcion) {
			case '1':
				saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduza  recarga"));
				cliente1.setSaldo(saldo);
				break;
			case '2':
				double gasgastado = Double.parseDouble(JOptionPane.showInputDialog("Introduza  gas gastado"));
				cliente1.gastoGas(gasgastado);
				break;
			case '3':
				JOptionPane.showMessageDialog(null,
						"El saldo de " + cliente1.getNombre() + " es " + cliente1.getSaldo());
				break;

			case '4':
				JOptionPane.showMessageDialog(null, "Los datos del cliente detallados\n" + cliente1.getDatosTotales());
				break;
			case '5':
				cliente1.generaFactura();
				JOptionPane.showMessageDialog(null, "Se ha generado su factura");
				break;
			case '6':
				cliente1.generarGrafica();
				break;
			case 's':
				break;
			}

		} while (opcion != 's');

	}

}
