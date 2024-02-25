package net.falseme.rmlch.ui.window;

import java.awt.Container;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JLabel;

import net.falseme.rmlch.assets.Assets;
import net.falseme.rmlch.ui.Button;
import net.falseme.rmlch.ui.Screen;
import net.falseme.rmlch.ui.layout.WindowLayout;

public class HelpWindow extends Window {
	private static final long serialVersionUID = 1l;

	private HashMap<Integer, JLabel[]> labels = new HashMap<Integer, JLabel[]>();
	private int currentPage = 0;

	public HelpWindow(Screen screen) {
		super("Ayuda", null, Assets.HELP, screen, 750, 0);

		setLayout(new HelpLayout());

		add(new JLabel("Sistema de Ayuda BeetrootOS", JLabel.CENTER));

		add(new Button("", Assets.BACK, () -> {
			if (currentPage <= 0)
				return;
			loadPage(currentPage - 1, true);
			doLayout();
			repaint();
		}));

		add(new Button("", Assets.NEXT, () -> {
			if (currentPage >= labels.size() - 1)
				return;
			loadPage(currentPage + 1, true);
			doLayout();
			repaint();
		}));

		labels.put(0,
				new JLabel[] { 
					new JLabel("Bienvenido al Sistema de Ayuda", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• El sistema de ayuda le acompañará y guiará para facilitarle el uso ", JLabel.LEFT),
					new JLabel("del sistema operativo.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Para navegar atraves del sistema de ayuda utilice las fechas", JLabel.LEFT),
					new JLabel("debajo para avanzar o retroceder en caso de así desearlo.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• En caso de mayores problemas no dude en contactarse con", JLabel.LEFT),
					new JLabel("nuestro soporte al cliente.", JLabel.LEFT)
				});
		
		labels.put(1,
				new JLabel[] { 
					new JLabel("Como utilizar el Decodec", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• El sistema operativo trae consigo un Decodec, utilícelo para ", JLabel.LEFT),
					new JLabel("descifrar mensajes encriptados.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("El Decodec puede desencriptar los siguientes tipos de mensajes:", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tipo 2: Cesar Simple 'k'              (ejemplo: 'jklm' >> 'zabc')", JLabel.LEFT),
					new JLabel("• Tipo 7: Base 64                           (ejemplo: 'YWJjZA==' >> 'abcd')", JLabel.LEFT),
					new JLabel("• Tipo D: Hexadecimal a Texto    (ejemplo: '6B 6C 6D' >> 'KLM')", JLabel.LEFT),
				});
		
		labels.put(2,
				new JLabel[] { 
					new JLabel("Secretos", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Pueden estar guardados en cualquier carpeta.", JLabel.LEFT),
					new JLabel("Navegue por el sistema operativo y resulva los 7 secretos.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• La clave para resolverlos puede ser una palabra o un conjunto", JLabel.LEFT),
					new JLabel("de varias. Utilice todas las utilidades del SO para obtener los", JLabel.LEFT),
					new JLabel("mensajes encriptados ocultos y el decodec para obtener la palabra", JLabel.LEFT),
					new JLabel("correcta. Finalmente, junte todas las respuestas y resuelva el puzzle.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• A continuación, diferentes pistas para ayudar.", JLabel.LEFT),
				});
		
		labels.put(3,
				new JLabel[] { 
					new JLabel("Secreto 1", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /Imágenes/ ", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 16 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Contenido + Nombre. Recuerda los espacios.", JLabel.LEFT),
				});
		
		labels.put(4,
				new JLabel[] { 
					new JLabel("Secreto 1 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• En la carpeta /Imágenes/ hay 4 fotos con dos digitos", JLabel.LEFT),
					new JLabel("hexadecimales en el nombre del archivo y dentro de la imagen.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo esos dígitos da como resultado 'comotanmuchacho?'.", JLabel.LEFT),
					new JLabel(""),
				});

		labels.put(5,
				new JLabel[] { 
					new JLabel("Secreto 2", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /Escritorio/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 5 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• El sistema operativo tiene opciones de personalización.", JLabel.LEFT),
					new JLabel("Deberías echarle un vistazo.", JLabel.LEFT),
				});
		
		labels.put(6,
				new JLabel[] { 
					new JLabel("Secreto 2 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• En los ajustes puedes cambiar el color del fondo, lo que", JLabel.LEFT),
					new JLabel("te permite ver 5 dígitos hexadecimales en el escritorio.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo esos dígitos da como resultado 'patas'.", JLabel.LEFT),
					new JLabel(""),
				});
		
		labels.put(7,
				new JLabel[] { 
					new JLabel("Secreto 3", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /m7B/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 24 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• En este caso, el orden de los factores altera el producto", JLabel.LEFT),
				});
		
		labels.put(8,
				new JLabel[] { 
					new JLabel("Secreto 3 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Las imágenes dentro de /Documentos/m7B/ tienen un texto", JLabel.LEFT),
					new JLabel("encriptado con Base64. Sumando los textos obtienes:", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• cGFyYWN1YW5kb2xhdGVyY2VyYT9IRFAh.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo este texto da como resultado", JLabel.LEFT),
					new JLabel("'paracuandolatercera?HDP!'.", JLabel.LEFT),
				});
		
		labels.put(9,
				new JLabel[] { 
					new JLabel("Secreto 4", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /DW4/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 9 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Puedes usar un celular.", JLabel.LEFT),
				});
		
		labels.put(10,
				new JLabel[] { 
					new JLabel("Secreto 4 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• La imágen contiene un QR que puede ser escaneado para obtener", JLabel.LEFT),
					new JLabel("un texto encriptado en Base64 que al traducirlo se obtiene un", JLabel.LEFT),
					new JLabel("texto encriptado en Hexadecimal.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo los dígitos da como resultado 'Remolacha'.", JLabel.LEFT),
				});
		
		labels.put(11,
				new JLabel[] { 
					new JLabel("Secreto 5", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /EdW/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 6 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• A veces solo debemos reordenar un poco nuestras ideas.", JLabel.LEFT),
				});
		
		labels.put(12,
				new JLabel[] { 
					new JLabel("Secreto 5 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Las dos imágenes dentro de /Documentos/EdW/ contienen un", JLabel.LEFT),
					new JLabel("texto encriptado bajo el algoritmo Cesar Simple.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Mqhtud.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo el texto da como resultado 'Warden'.", JLabel.LEFT),
				});
		
		labels.put(13,
				new JLabel[] { 
					new JLabel("Secreto 6", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /EdW/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 4 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Hay imágenes perdidas.", JLabel.LEFT),
				});
		
		labels.put(14,
				new JLabel[] { 
					new JLabel("Secreto 6 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Las 4 imágenes perdidas en el orden correcto son:", JLabel.LEFT),
					new JLabel("'perdido.png', 'perdido', 'tres.png' y 'cuatro.png'", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Cada una tiene una letra encriptada bajo Base64.", JLabel.LEFT),
					new JLabel("• Al traducirlo se obtiene un código hexadecimal.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo letra por letra da como resultado 'Uvas'.", JLabel.LEFT),
				});
		
		labels.put(15,
				new JLabel[] { 
					new JLabel("Secreto 7", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• /Buscaminas/", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Tiene 6 letras.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• No nos damos cuenta de lo que tenemos hasta que lo perdemos.", JLabel.LEFT),
				});
		
		labels.put(16,
				new JLabel[] { 
					new JLabel("Secreto 7 - SOLUCIÓN", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Dejando ver la posición de las bombas en el buscaminas y", JLabel.LEFT),
					new JLabel("posicionando la tarjeta sobre la pantalla, se puede asociar", JLabel.LEFT),
					new JLabel("un código hexadecimal a cada bomba según indica la tarjeta.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo los dígitos en orden de izquierda a derecha se", JLabel.LEFT),
					new JLabel("obtiene un texto encriptado bajo el algoritmo Cesar Simple.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Traduciendo el texto da como resultado 'nigger'.", JLabel.LEFT),
				});
		
		labels.put(17,
				new JLabel[] { 
					new JLabel("Solución General", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Una vez resueltos todos los secretos, solo queda juntar las", JLabel.LEFT),
					new JLabel("respuestas y completar el link de la tarjeta principal.", JLabel.LEFT),
					new JLabel(""),
					new JLabel("• Muchas gracias por elegirnos como su sistema operativo de", JLabel.LEFT),
					new JLabel("confianza y ante cualquier problema no dude en consultar", JLabel.LEFT),
					new JLabel("nuevamente a nuestro Sistema de Ayuda BeetrootOS.", JLabel.LEFT),
				});

		System.out.println(labels.size());
		loadPage(0, false);
		
	}

	private void loadPage(int page, boolean remove) {
		
		if (remove)
			for (JLabel l : labels.get(currentPage))
				remove(l);
		currentPage = page;
		for (JLabel l : labels.get(currentPage))
			add(l);

	}
	
	public void add(JLabel label) {
		label.setFont(Assets.w98);
		super.add(label);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int iconW = 96;
		g.drawImage(Assets.ICON, (getWidth() - iconW) / 2, header.getHeight(), iconW, iconW, null);

	}

}

class HelpLayout extends WindowLayout {

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);

		int size = 30;
		parent.getComponent(1).setBounds(0, 120, parent.getWidth(), 25);
		parent.getComponent(2).setBounds(parent.getWidth() / 2 - size, parent.getHeight() - size / 2 - size, size, size);
		parent.getComponent(3).setBounds(parent.getWidth() / 2, parent.getHeight() - size / 2 - size, size, size);

		int w = (int) (parent.getWidth() * 0.8);
		int y0 = 170;
		size = 30;
		for(int i=4; i<parent.getComponentCount(); i++) {
			parent.getComponent(i).setBounds((parent.getWidth() - w) / 2, y0 + size * (i - 4), w, size);
		}
		
	}

}
