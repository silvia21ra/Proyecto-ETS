package ETS;

/**
 * @author silvi
 *
 */
public class TarifaCliente {
	private String nombreT;
	private double precioT;

	/**
	 * Constructor
	 * 
	 * @param nomT Nombre de la tarifa
	 * @param preT Precio de la tarifa
	 */
	public TarifaCliente(String nomT, double preT) {
		nombreT = nomT;
		precioT = preT;
	}

	/**
	 * Cambia el nombre de la tarifa
	 * 
	 * @param nom Nombre
	 */
	public void setTarifaNombre(String nom) {
		nombreT = nom;
	}

	/**
	 * Cambia el precio de la tarifa
	 * 
	 * @param pre Precio
	 */
	public void setTariPrecio(double pre) {
		precioT = pre;
	}

	/**
	 * @return Nombre
	 */
	public String getTarifaNombre() {
		return nombreT;
	}

	/**
	 * @return precio
	 */
	public Double getTarifaGas() {
		return precioT;
	}

	/**
	 * Devuelve los datos de la tarifa
	 */
	@Override
	public String toString() {
		String cadenaTarifa = ("Tarifa: " + getTarifaNombre() + "\nPrecio: " + getTarifaGas());
		return cadenaTarifa;
	}
}
