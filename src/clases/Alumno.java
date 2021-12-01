package clases;

public class Alumno {
	private String nombre;
	private String matricula;
	private int calificaciones[];
	private String listaCalif = "";
	private double promedio = 0;
	private int contador = 0;
	
	public Alumno() {
		nombre = Entrada.cadena( "Nombre del alumno: " );
		matricula = Entrada.cadena( "Matricula: " );
		
		calificaciones = new int[7];
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void addCalificacion( int nuevaCalif ) {
		if( contador <= 7 ) {
			calificaciones[contador] = nuevaCalif;
			contador++;
			
			listaCalif += nuevaCalif + " ";
		}
		else
			System.out.println( "Ya no ha espacio para mas calificaciones." );
	}
	
	public String getListCalif() {
		return listaCalif;
	}
	
	public double getPromedio() {
		int acumulador = 0;
		for( int i = 0; i < calificaciones.length; i++ ) {
			acumulador += calificaciones[i];
		}
		
		promedio = (double)acumulador / calificaciones.length;
		
		return promedio;
	}
	
	

}
