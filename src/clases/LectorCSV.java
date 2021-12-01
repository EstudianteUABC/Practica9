package clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import clases.Alumno;

public class LectorCSV {
	private static String datos = "";
	private static String campos[];
	private static Alumno alumnos[] = new Alumno[3];
	
	public static void ejecutar() {
		leerDatos();
		datosAlumnos();
		asignarCalificaciones();
		mostrarDatos();
		escribirDatosEnArchivo();
	}
		
	public static void leerDatos() {
		try {
			FileInputStream fin = new FileInputStream("practica9.csv");
			int i = 0;
			while ((i = fin.read()) != -1) {
				datos += (char)i;
			}
			
			//se parte la cadena leida, y se almacena en forma de arreglo
			campos = datos.split(",");
			
			System.out.println( "\n--- Datos leidos desde el CSV --- \n");
			System.out.println( Arrays.toString( campos ) + "\n" );
			
			fin.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void datosAlumnos() {
		for( int i = 0; i < alumnos.length; i++ ) {
			System.out.println("Datos de Alumno[" + (i+1) + "]");
			alumnos[i] = new Alumno();
		}
		
	}
	
	//esta calificacion le asigna 7 calificaciones a cada alumno
	public static void asignarCalificaciones() {
		int indice = 0; //identifica la siguiente calificacion del archivo
		for( int i = 0; i < alumnos.length; i++ ) {
			for( int j = 0; j < 7; j++ ) {
				//A cada alumno se le agrega una calificacion del archivo
				//Se convierten las cadenas a enteros
				alumnos[i].addCalificacion( Integer.parseInt( campos[indice] ) );
				indice++;
			}
		}
	}
	
	public static void escribirDatosEnArchivo() {
		try{    
            FileOutputStream fout=new FileOutputStream("Alumnos.txt");        
      
            for( int i = 0; i < alumnos.length; i++ ) {
            	String nuevaLinea = "\n";
            	String separador = "-------------------------\n";
            	String nombre = "Nombre: " + alumnos[i].getNombre();
            	String matricula ="Matricula: " + alumnos[i].getMatricula();
            	String listaCalif ="Lista de calificaciones: \n" +  alumnos[i].getListCalif();
            	String promedio ="Promedio: " + Double.toString( alumnos[i].getPromedio() );
            	
            	byte nuevaLineaB[] = nuevaLinea.getBytes();
            	byte separadorB[] = separador.getBytes();
            	byte nombreB[] = nombre.getBytes();
            	byte matriculaB[] = matricula.getBytes();
            	byte listaCalifB[] = listaCalif.getBytes();
            	byte promedioB[] = promedio.getBytes();
            	
            	fout.write(separadorB);
            	fout.write(nombreB);
            	fout.write( nuevaLineaB );
            	fout.write(matriculaB);
            	fout.write( nuevaLineaB );
            	fout.write(listaCalifB);
            	fout.write( nuevaLineaB );
            	fout.write(promedioB);
            	fout.write( nuevaLineaB );
            	
            }

            fout.close();    
            System.out.println("El archivo se guardo correctamente...");    
           }catch(Exception e){System.out.println(e);}    
     }  
	
	public static void mostrarDatos() {
		for( int i = 0; i < alumnos.length; i++ ) {
			System.out.println( "\n-----------------------------" );
			System.out.println( "Datos de alumno [" + (i + 1) + "]" );
			System.out.println( "Nombre: " + alumnos[i].getNombre() );
			System.out.println( "Matricula: " + alumnos[i].getMatricula() );
			System.out.println( "Lista de calificaciones: \n" + alumnos[i].getListCalif() );
			System.out.println( "Promedio: " + alumnos[i].getPromedio());
		}
	}
		
}
