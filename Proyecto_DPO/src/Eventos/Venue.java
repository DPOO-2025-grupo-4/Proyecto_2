package Eventos;

public class Venue {
	private String tipoVenue;
	private int latitud;
	private int longitud;
	private int capacidadMaxima;
	private String restriccionesUso;
	private String nombreVenue;
	private int idVenue;
	private static int idSecuencial = 1;
	private String estado;
	private boolean disponible;
	
	public Venue() {
		
	}
	public Venue(String tipoVenue, int latitud, int longitud, int capacidadMaxima,
			String restriccionesUso, String nombre, String estado) throws Exception {
			this.tipoVenue = tipoVenue;
			this.latitud = latitud;
			this.longitud = longitud;
			if (capacidadMaxima>0) {
				this.capacidadMaxima = capacidadMaxima;
			}
			else {
				throw new Exception("La capacidad del venue es negativa");
			}
			
			this.restriccionesUso = restriccionesUso;
			this.nombreVenue = nombre;
			this.estado = estado;
			this.disponible = true;
			idVenue = idSecuencial;
			idSecuencial ++;
	}
	public static void setIdSecuencial(int idActual) {
		idSecuencial = idActual;
	}
	public static int getIdSecuencial() {
		return idSecuencial;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado){
		this.estado = estado;
	}	
	public void ocuparVenue() {
		disponible = false;
	}
	public void liberarVenue() {
		disponible = true;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public String getUbicacion() {
		int lat = latitud;
		int lon = longitud;
		String rst = Integer.toString(lat) +","+ Integer.toString(lon);
		return rst;
	}
	
	public String getTipoVenue() {
		return tipoVenue;
	}

	public void setTipoVenue(String tipoVenue) {
		this.tipoVenue = tipoVenue;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public String getRestriccionesUso() {
		return restriccionesUso;
	}

	public void setRestriccionesUso(String restriccionesUso) {
		this.restriccionesUso = restriccionesUso;
	}

	public String getNombreVenue() {
		return nombreVenue;
	}

	public void setNombreVenue(String nombreVenue) {
		this.nombreVenue = nombreVenue;
	}
	public int getIdVenue() {
		return idVenue;
	}

	
}
