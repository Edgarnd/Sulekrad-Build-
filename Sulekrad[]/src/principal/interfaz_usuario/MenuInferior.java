package principal.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.ElementosPrincipales;
import principal.entes.Jugador;
import principal.herramientas.CargadorRecursos;
import principal.herramientas.DibujoDebug;
import principal.inventario.armas.Desarmado;

public class MenuInferior {

	private Rectangle areaInventario;
	private Rectangle bordeAreaInventario;

	private Color negroDesaturado;
	private Color negroOscuro;
	private Color negroClaro;
	private Color marronOscuro;
	private Color marronClaro;
	private Color rojoClaro;
	private Color rojoOscuro;
	private Color naranjaClaro;
	private Color naranjaOscuro;

	private BufferedImage img = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_ARMAS);

	public MenuInferior() {

		int altoMenu = 64;
		areaInventario = new Rectangle(0, Constantes.ALTO_JUEGO - altoMenu, Constantes.ANCHO_JUEGO, altoMenu);
		bordeAreaInventario = new Rectangle(areaInventario.x, areaInventario.y - 1, areaInventario.width, 1);

		negroDesaturado = new Color(169, 169, 169);
		negroOscuro = new Color(0, 0, 0);
		negroClaro = new Color(40, 40, 40);
		marronOscuro = new Color(90, 56, 38);
		marronClaro = new Color(93, 41, 5);
		rojoClaro = new Color(250, 0, 0);
		rojoOscuro = new Color(100, 11, 10);
		naranjaClaro = new Color(208, 65, 9);
		naranjaOscuro = new Color(193, 88, 14);
	}

	public void dibujar(final Graphics g) {
		dibujarAreaInventario(g);
		dibujarBarraVitalidad(g);
		dibujarBarraPoder(g);
		dibujarBarraResistencia(g);
		dibujarBarraExperiencia(g, 75);
		dibujarRanurasObjetos(g);
		dibujarPuntos(g);
		dibujarObjetoEnRanura(g);
	}

	private void dibujarObjetoEnRanura(Graphics g) {
		if (!(ElementosPrincipales.jugador.obtenerAlmacenEquipo().obtenerArma1() instanceof Desarmado)) {
			DibujoDebug.dibujarImagen(g, img, areaInventario.x + 220, areaInventario.y + 4);
		}

	}

	private void dibujarPuntos(final Graphics g) {
		final int medidaVertical = 4;
		DibujoDebug.dibujarString(g, "Puntos: " + ElementosPrincipales.jugador.puntos, areaInventario.x + 10,
				areaInventario.y + medidaVertical * 15, Color.white);
	}

	private void dibujarAreaInventario(final Graphics g) {
		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario, negroDesaturado);
		DibujoDebug.dibujarRectanguloRelleno(g, bordeAreaInventario, Color.white);
	}

	private void dibujarBarraVitalidad(final Graphics g) {
		final int medidaVertical = 4;
		final int anchoTotal = 100;

		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical, anchoTotal,
				medidaVertical, negroOscuro);
		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 2,
				anchoTotal, medidaVertical, negroClaro);

		g.setColor(Color.white);
		DibujoDebug.dibujarString(g, "VIT", areaInventario.x + 10, areaInventario.y + medidaVertical * 3);
		DibujoDebug.dibujarString(g, "1000", anchoTotal + 45, areaInventario.y + medidaVertical * 3);
	}

	private void dibujarBarraPoder(final Graphics g) {
		final int medidaVertical = 4;
		final int anchoTotal = 100;

		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 4,
				anchoTotal, medidaVertical, marronOscuro);
		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 5,
				anchoTotal, medidaVertical, marronClaro);

		g.setColor(Color.white);
		DibujoDebug.dibujarString(g, "POW", areaInventario.x + 10, areaInventario.y + medidaVertical * 6);
		DibujoDebug.dibujarString(g, "1000", anchoTotal + 45, areaInventario.y + medidaVertical * 6);
	}

	private void dibujarBarraResistencia(final Graphics g) {
		final int medidaVertical = 4;
		final int anchoTotal = 100;
		final int ancho = anchoTotal * ElementosPrincipales.jugador.obtenerResistencia() / Jugador.RESISTENCIA_TOTAL;

		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 7, ancho,
				medidaVertical, rojoClaro);
		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 8, ancho,
				medidaVertical, rojoOscuro);

		g.setColor(Color.white);
		DibujoDebug.dibujarString(g, "RST", areaInventario.x + 10, areaInventario.y + medidaVertical * 9);
		DibujoDebug.dibujarString(g, "" + ElementosPrincipales.jugador.obtenerResistencia(), anchoTotal + 45,
				areaInventario.y + medidaVertical * 9);
	}

	private void dibujarBarraExperiencia(final Graphics g, final int experiencia) {
		final int medidaVertical = 4;
		final int anchoTotal = 100;
		final int ancho = anchoTotal * experiencia / anchoTotal;

		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 10, ancho,
				medidaVertical, naranjaClaro);
		DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 11, ancho,
				medidaVertical, naranjaOscuro);

		g.setColor(Color.white);
		DibujoDebug.dibujarString(g, "EXP", areaInventario.x + 10, areaInventario.y + medidaVertical * 12);
		DibujoDebug.dibujarString(g, experiencia + "%", anchoTotal + 45, areaInventario.y + medidaVertical * 12);
	}

	private void dibujarRanurasObjetos(final Graphics g) {
		final int anchoRanura = 32;
		final int numeroRanuras = 10;
		final int espaciadoRanuras = 10;
		final int anchoTotal = anchoRanura * numeroRanuras + espaciadoRanuras * numeroRanuras;
		final int xInicial = Constantes.ANCHO_JUEGO - anchoTotal;
		final int anchoRanuraYEspacio = anchoRanura + espaciadoRanuras;

		g.setColor(Color.white);

		for (int i = 0; i < numeroRanuras; i++) {
			int xActual = xInicial + anchoRanuraYEspacio * i;

			Rectangle ranura = new Rectangle(xActual, areaInventario.y + 4, anchoRanura, anchoRanura);
			DibujoDebug.dibujarRectanguloRelleno(g, ranura);
			DibujoDebug.dibujarString(g, "" + i, xActual + 13, areaInventario.y + 54);
		}
	}
}