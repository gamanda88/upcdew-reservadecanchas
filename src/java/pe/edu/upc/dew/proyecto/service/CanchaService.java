/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.proyecto.service;

import java.util.List;
import pe.edu.upc.dew.proyecto.dao.CanchaDao;

import pe.edu.upc.dew.proyecto.model.Cancha;

/**
 *
 * @author usuario
 */
public interface CanchaService {

    public Cancha obtenerCancha(int codigo);

    public List<Cancha> obtenerCanchas();

    public int registrarCancha(Cancha cancha);

    public int modificarCancha(Cancha cancha);

    public int eliminarCancha(Cancha cancha);

}
