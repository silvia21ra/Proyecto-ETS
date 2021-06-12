package ETS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author silvi
 **/
 
public class claseGasCliente {

	final private static String nombreTarifa1 = "Día Agua";
	final private static String nombreTarifa2 = "Noche Agua";
	final private static double precioTarifa1 = 20;
	final private static double precioTarifa2 = 10;

	private String nombre;
	protected double saldo;
	private int tarifaSelect;

	protected TarifaCliente tarifafinal;

	protected ArrayList<Double> registroGastoGas = new ArrayList<>();

	/** 
	 * Constructor
	 * 
	 * @param nom nombre
	 * @param sal salario
	 * @param TS Selección de tarifa
	 */
	public claseGasCliente(String nom, double sal, int TS) {
		nombre = nom;
		saldo = sal;
		tarifaSelect = TS;
		crearTarifa(tarifaSelect);
	}

	/**
	 * If para los parametros de tarfifa 1 o 2
	 * 
	 * @param sel Tarifa
	 */
	public void crearTarifa(int sel) {
		if (sel == 1)
			tarifafinal = new TarifaCliente(nombreTarifa1, precioTarifa1);
		else
			tarifafinal = new TarifaCliente(nombreTarifa2, precioTarifa2);
	}

	/**
	 * Cambia el nombre
	 * 
	 * @param nom Nombre
	 */
	public void setNombre(String nom) {
		nombre = nom;
	}

	/**
	 * Añadir saldo
	 * 
	 * @param sal saldo
	 */
	public void setSaldo(double sal) {
		saldo = saldo + sal;
	}

	/**
	 * Calcula el coste de agua y lo resta al saldo
	 * 
	 * @param cant Cantidad de agua
	 */
	public void gastoGas(double cant) {
		double coste = cant * tarifafinal.getTarifaGas();
		saldo = saldo - (coste);
		registroGastoGas.add(coste);
	}

	/**
	 * @return Nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return Saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Devuelve los datos de la tarifa
	 * 
	 * @return Cadena to.String
	 */
	public String getDatosClienteTarifa() {
		return tarifafinal.toString();
	}

	/**
	 * Devuelve los datos de la tarifa y del cliente
	 * 
	 * @return Cadena de datos
	 */
	public String getDatosTotales() {
		String cadenaDatosFinales = ("\nNombre: " + getNombre() + "\nSaldo: " + getSaldo() + "\n"
				+ getDatosClienteTarifa());
		return cadenaDatosFinales;
	}

	/**
	 * Crear una factura
	 * 
	 * @throws FileNotFoundException
	 */
	public void generaFactura() throws FileNotFoundException {// Por si el archivo no existe se cree
		String filenombre = "Factura.txt";
		File file = new File(filenombre);
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < registroGastoGas.size(); i++) {
			output.println((i + 1) + " " + registroGastoGas.get(i));

		}
		output.close();
	}

	/**
	* Crea una gráfica
	* 
	*/
	public void generarGrafica() {
		XYSeries series = new XYSeries("series gasto agua");
		for (int i = 0; i < registroGastoGas.size(); i++) {
			series.add((i + 1), registroGastoGas.get(i));

			XYSeriesCollection data = new XYSeriesCollection();
			data.addSeries(series);

			JFreeChart chart = ChartFactory.createXYLineChart("Grafica gasto gas", "n factura", "coste", data);

			ChartFrame frame = new ChartFrame("graph using JFreeChart", chart);
			frame.pack();
			frame.setVisible(true);

		}
	}

}
