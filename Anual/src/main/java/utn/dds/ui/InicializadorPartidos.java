package utn.dds.ui;

import java.util.Date;

import utn.dds.db.EntityManagerHelper;
import utn.dds.jugador.Jugador;
import utn.dds.jugador.JugadorHome;
import utn.dds.partido.Partido;
import utn.dds.tipoInscripcion.Condicional;
import utn.dds.tipoInscripcion.Estandar;
import utn.dds.tipoInscripcion.Solidaria;

public class InicializadorPartidos {
	
	private static Estandar estandar;
	private static Condicional condicional;
	private static Solidaria solidaria;
	
	public static void inicializar(Partido partido){
		EntityManagerHelper.beginTransaction();
		
		Jugador juan = new Jugador();
		juan.setNombre("juan");
		JugadorHome.getInstancia().create(juan);
		
		Jugador lalo = new Jugador();
		lalo.setNombre("lalo");
		JugadorHome.getInstancia().create(lalo);
		
		Jugador juancho = new Jugador();
		juancho.setNombre("juancho");
		JugadorHome.getInstancia().create(juancho);
		
		Jugador carlos = new Jugador();
		carlos.setNombre("carlos");
		JugadorHome.getInstancia().create(carlos);
		
		Jugador pepito = new Jugador();
		pepito.setNombre("pepito");
		JugadorHome.getInstancia().create(pepito);
		
		Jugador martin = new Jugador();
		martin.setNombre("martin");
		JugadorHome.getInstancia().create(martin);
		
		Jugador lucas = new Jugador();
		lucas.setNombre("lucas");
		JugadorHome.getInstancia().create(lucas);
		
		Jugador pato = new Jugador();
		pato.setNombre("pato");
		JugadorHome.getInstancia().create(pato);
		
		Jugador marcelo = new Jugador();
		marcelo.setNombre("marcelo");
		JugadorHome.getInstancia().create(marcelo);
		
		Jugador leandro = new Jugador();
		leandro.setNombre("leandro");
		JugadorHome.getInstancia().create(leandro);
		
		juan.setHandicap(10);
		pepito.setHandicap(1);
		marcelo.setHandicap(4);
		leandro.setHandicap(5);
		martin.setHandicap(6);
		juancho.setHandicap(7);
		carlos.setHandicap(2);
		pato.setHandicap(8);
		lalo.setHandicap(3);
		lucas.setHandicap(9);
		
		juan.setApodo("Tato");
		pepito.setApodo("Enano");
		marcelo.setApodo("Micho");
		leandro.setApodo("Tito");
		martin.setApodo("Pelado");
		juancho.setApodo("Negrito");
		carlos.setApodo("Gordo");
		pato.setApodo("Cabezon");
		lalo.setApodo("Colo");
		lucas.setApodo("Lucho");
		
		EntityManagerHelper.persist(leandro);
		EntityManagerHelper.persist(juan);
		EntityManagerHelper.persist(marcelo);
		EntityManagerHelper.persist(pepito);
		EntityManagerHelper.persist(martin);
		EntityManagerHelper.persist(juancho);
		EntityManagerHelper.persist(pato);
		EntityManagerHelper.persist(lalo);
		EntityManagerHelper.persist(lucas);
		EntityManagerHelper.persist(carlos);
		
		Partido riverboca = new Partido(new Date());
		
		estandar = new Estandar();
		condicional = new Condicional();
		solidaria = new Solidaria();
		
		riverboca.inscribirJugador(carlos, estandar);
		riverboca.inscribirJugador(juancho, estandar);
		riverboca.inscribirJugador(juan, estandar);
		riverboca.inscribirJugador(lucas, estandar);
		riverboca.inscribirJugador(pato, estandar);
		riverboca.inscribirJugador(martin, estandar);
		riverboca.inscribirJugador(leandro, estandar);
		riverboca.inscribirJugador(marcelo, estandar);
		riverboca.inscribirJugador(lalo, estandar);
		riverboca.inscribirJugador(pepito, estandar);
		
		EntityManagerHelper.persist(estandar);
		EntityManagerHelper.persist(condicional);
		EntityManagerHelper.persist(solidaria);
		
		EntityManagerHelper.persist(riverboca);
		
		carlos.calificar(juancho, riverboca, 2, "Es horrible");
		carlos.calificar(juan, riverboca, 3, "Arquero manco");
		carlos.calificar(pato, riverboca, 1, "Es ma malo que el cigarro");
		carlos.calificar(lucas, riverboca, 6, "Jugo bien");
		carlos.calificar(martin, riverboca, 10, "La estrella");
		carlos.calificar(marcelo, riverboca, 9, "Sabella marcelito es argentino");
		carlos.calificar(lalo, riverboca, 5, "Regular");
		carlos.calificar(pepito, riverboca, 7, "Lateral con proyeccion");
		carlos.calificar(leandro, riverboca, 4, "Defensor rustico");
		martin.calificar(carlos, riverboca, 8, "Un volante con magia");
				
		partido = new Partido(new Date());
		partido.inscribirJugador(lalo, solidaria);
		partido.inscribirJugador(juan, estandar);
		partido.inscribirJugador(lucas, solidaria);
		partido.inscribirJugador(pepito, condicional);
		partido.inscribirJugador(martin, condicional);
		partido.inscribirJugador(juancho, estandar);
		partido.inscribirJugador(carlos, estandar);
		partido.inscribirJugador(marcelo, condicional);
		partido.inscribirJugador(leandro, estandar);
		partido.inscribirJugador(pato, estandar);		
		
		EntityManagerHelper.commit();
	}

	public static Estandar getEstandar() {
		return estandar;
	}

	public static void setEstandar(Estandar estandar) {
		InicializadorPartidos.estandar = estandar;
	}

	public static Condicional getCondicional() {
		return condicional;
	}

	public static void setCondicional(Condicional condicional) {
		InicializadorPartidos.condicional = condicional;
	}

	public static Solidaria getSolidaria() {
		return solidaria;
	}

	public static void setSolidaria(Solidaria solidaria) {
		InicializadorPartidos.solidaria = solidaria;
	}
}
