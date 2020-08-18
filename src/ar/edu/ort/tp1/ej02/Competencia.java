package ar.edu.ort.tp1.ej02;

import java.util.ArrayList;
import java.util.Scanner;

public class Competencia {
	
	public static Scanner in = new Scanner(System.in);
	
	private String nombre;
	private ArrayList<Participante> participante;
	private ArrayList<Participante> ganador;
	
	private Podio ganadores;
	
	public Competencia(String nombre) 
	{
		this.nombre = nombre;
		participante = new ArrayList<Participante>();
		ganador = new ArrayList<Participante>();		
		
	}
	
	public void setDatos(String nombre, float tiempo) 
	{
		participante.add(new Participante(nombre, tiempo));
	}
	
	public void mostrarParticipantes()
	{
		System.out.println("Nombre | Tiempo");
		for(Participante p: participante) 
		{
			System.out.println(p.toString());
		}
	}
	
	private void calcularGanador() 
	{
		
		float primerPuesto = Float.MAX_VALUE;
		float segundoPuesto = Float.MAX_VALUE + 1;
		float tercerPuesto = Float.MAX_VALUE + 2 ;
		
		float auxTiempo = 0;
		for(Participante p: participante) 
		{
			auxTiempo = p.getTiempo();
			if(auxTiempo < tercerPuesto && auxTiempo < segundoPuesto && auxTiempo < primerPuesto) 
			{
				ganadores.vaciarPrimero();
				ganadores.agregarPrimero(p);
			}
		}
				
	}
	
	public void mostrarGanador() 
	{	
		calcularGanador();
		if(ganador.size() > 1)
		{
			System.out.println("Hubo empate en el primer puesto");
		}
		recorrerLista();
	}
	
	private void recorrerLista()
	{
		for(Participante g : ganador) 
		{
			System.out.println(g.toString());
		}
	}
		
	
	public String getNombre() 
	{
		return nombre;
	}
		
}