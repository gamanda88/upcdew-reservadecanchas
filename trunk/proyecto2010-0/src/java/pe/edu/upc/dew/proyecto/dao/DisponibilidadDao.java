/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.proyecto.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.upc.dew.proyecto.model.Cancha;
import pe.edu.upc.dew.proyecto.model.Disponibilidad;

/**
 *
 * @author Marco Antonio
 */
public class DisponibilidadDao {

    private CanchaDao canchaDao;

    public DisponibilidadDao() {
        this.canchaDao = new CanchaDao();
    }

    private List<Disponibilidad> llenarDatos(){
         Date myDate = null;
        Date myDate1 = null;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            myDate  = dateFormat.parse("17/02/2010");
            myDate1 = dateFormat.parse("18/02/2010");
        } catch (ParseException e) {
            e.printStackTrace();
        }
         List<Cancha> canchas = canchaDao.obtenerCanchas();
        List<Disponibilidad> canchasDisponibles = new ArrayList<Disponibilidad>();

        Disponibilidad canchaDisponible = new Disponibilidad();
        canchaDisponible.setFechaDisponible(myDate);
        canchaDisponible.setHoraInicio(8);
        canchaDisponible.setHoraFin(10);
        canchaDisponible.setCancha(canchas.get(2));
        canchasDisponibles.add(canchaDisponible);

        Disponibilidad canchaDisponible2 = new Disponibilidad();
        canchaDisponible2.setFechaDisponible(myDate1);
        canchaDisponible2.setHoraInicio(10);
        canchaDisponible2.setHoraFin(12);
        canchaDisponible2.setCancha(canchas.get(4));
        canchasDisponibles.add(canchaDisponible2);


        Disponibilidad canchaDisponible3 = new Disponibilidad();
        canchaDisponible3.setFechaDisponible(myDate);
        canchaDisponible3.setHoraInicio(14);
        canchaDisponible3.setHoraFin(16);
        canchaDisponible3.setCancha(canchas.get(5));
        canchasDisponibles.add(canchaDisponible3);

     return canchasDisponibles;
    }




    public List<Disponibilidad> obtenerCanchasDisponibles(String fecha) {
    List<Disponibilidad> Listacanchas =llenarDatos();
    List<Disponibilidad> canchasDisponibles=new ArrayList();
    Date myDate = null;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            myDate  = dateFormat.parse(fecha);

        } catch (ParseException e) {
            e.printStackTrace();
        }

       for (int i =0;i< Listacanchas.size();i++){
       Disponibilidad canchas =(Disponibilidad)Listacanchas.get(i);
           if (canchas.getFechaDisponible().compareTo( myDate)==0)
               canchasDisponibles.add(canchas);

       }
        return canchasDisponibles;
    }
}