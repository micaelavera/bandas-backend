package services;

import java.util.List;

import dao.BusquedaDAO;
import dao.NotificacionDAO;
import dao.PostulacionDAO;
import dao.impl.BusquedaDAOJPA;
import dao.impl.NotificacionDAOJPA;
import dao.impl.PostulacionDAOJPA;
import domainModel.Busqueda;
import domainModel.Notificacion;
import domainModel.Postulacion;

public class MatcheoService {
	
	public static void main(String [] args){
		Postulacion p1 = new Postulacion("Rock","Guitarra");
		PostulacionDAO daoPostulacion = new PostulacionDAOJPA();
		daoPostulacion.crear(p1);
		
		Busqueda b1 = new Busqueda("Guitarra","1 año","2018-07-15");
		Busqueda b2 = new Busqueda("Bateria","2 años","2018-07-15");
		BusquedaDAO daoBusqueda = new BusquedaDAOJPA();
		daoBusqueda.crear(b1);
		daoBusqueda.crear(b2);
		
		List<Busqueda> busquedas = daoBusqueda.todos();
		List <Postulacion> postulaciones = daoPostulacion.todos();
		
		for (Busqueda busqueda: busquedas){
			for(Postulacion postulacion : postulaciones){
				
				//Comparamos el instrumento de la postulacion con el de la busqueda de la banda
				if(postulacion.getInstrumento().equals(busqueda.getInstrumento())){
					System.out.println("Busqueda:"+ busqueda.getInstrumento());
					System.out.println("Postulacion: "+ postulacion.getInstrumento());
					
					//Se debe crear una notificacion pero falta los mapeos 
					Notificacion n1 = new Notificacion(postulacion,busqueda);
					NotificacionDAO notificacion = new NotificacionDAOJPA();
					notificacion.crear(n1);
			}}
		}
		daoBusqueda.cerrar();
		daoPostulacion.cerrar();
	}
}
