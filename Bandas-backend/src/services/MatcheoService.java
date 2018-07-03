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
		Busqueda b2 = new Busqueda("Bateria","2 años","2018-07-12");
		BusquedaDAO daoBusqueda = new BusquedaDAOJPA();
		daoBusqueda.crear(b1);
		daoBusqueda.crear(b2);
	
		//Traemos todas las busquedas
		List <Busqueda> busquedas = daoBusqueda.todos();
		
		//Traemos todas las postulaciones
		List <Postulacion> postulaciones = daoPostulacion.todos();
		
		//Recorremos las busquedas
		for (Busqueda busqueda: busquedas){
			//Recorremos las postulaciones
			for(Postulacion postulacion : postulaciones){
				NotificacionDAO daoNotificacion = new NotificacionDAOJPA();
				List<Notificacion> notificaciones=daoNotificacion.todos();
				
				//Comparamos el instrumento de la postulacion con el de la busqueda de la banda
				if(postulacion.getInstrumento().equals(busqueda.getInstrumento())){
					System.out.println("Busqueda:"+ busqueda.getInstrumento());
					System.out.println("Postulacion: "+ postulacion.getInstrumento());
					
					//ver
					Long idBusqueda=busqueda.getId();
					Long idPostulacion=postulacion.getId();
					
					//no se deberian repetir las notificaciones?
					if(notificaciones.isEmpty()){
//					//Se debe crear una notificacion 
//						//Notificacion nueva
						Notificacion n1 = new Notificacion(postulacion,busqueda);
						daoNotificacion.crear(n1);	
						
						//nose si hay que hacer esto:
						postulacion.addNotificacion(n1);
						busqueda.addNotificacion(n1);
					}
				} 
			}
		}
		daoBusqueda.cerrar();
		daoPostulacion.cerrar();
	}
}
