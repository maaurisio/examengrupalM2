package com.krakedev.moduloii.grupal.servicios;


import java.sql.Connection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.moduloii.grupal.utils.ConexionBDD;

@Path("libros")
public class ServicioLibro {
	@Path("probarConexion")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String probarConexion() {
	    try {
	        Connection con = ConexionBDD.obtenerConexion();
	        if (con != null && !con.isClosed()) {
	            con.close();
	            return "Conexión exitosa a la base de datos.";
	        } else {
	            return "No se pudo establecer conexión.";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error al conectar: " + e.getMessage();
	    }
	}
}