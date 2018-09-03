package principal.maquinaestado.estados.enpausa;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import principal.graficos.SuperficieDibujo;
import principal.herramientas.CargadorRecursos;
import principal.maquinaestado.EstadoJuego;

public class EnPausa implements EstadoJuego {

	private final SuperficieDibujo sd;
	BufferedImage logo = CargadorRecursos
			.cargarImagenCompatibleTranslucida("/imagenes/hojasTexturas/sulekrad_back0.png");

	public EnPausa(final SuperficieDibujo sd) {
		this.sd = sd;

		//
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(logo, 0, 0, null);

	}

}
