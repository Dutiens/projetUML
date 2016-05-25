package uml.dutiens.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.CssLayout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* import for explicit declaration of callback */
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button.ClickEvent;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("uml.dutiens.org.MyAppWidgetset")
public class MyUI extends UI {

	private static final Logger log = LoggerFactory.getLogger(MyUIServlet.class);

	private final VerticalLayout layout = new VerticalLayout();
	private final HorizontalLayout menuBar = new HorizontalLayout();
	private final CssLayout menuBarRight = new CssLayout();
	private final Label nomProj = new Label("SalleOp") ;
	private final TextField tfRecherche = new TextField();
	private final Button bRecherche = new Button("Recherche") ;


	private final GridLayout grid = new GridLayout(1, 2);
	private final VerticalLayout left = new VerticalLayout();
	private final VerticalLayout right = new VerticalLayout();
	private final HorizontalLayout bottom = new HorizontalLayout();

	private final Panel informations = new Panel("Informations");

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		// Style de la barre de menu
		menuBar.setStyleName(" menu-bar");
		
		// Barre de menu
		menuBar.addComponent(nomProj);
		menuBar.addComponent(menuBarRight);
		menuBarRight.setStyleName(" element-align-middle element-align-right");
		nomProj.setStyleName(" element-align-middle");

		menuBarRight.addComponent(tfRecherche);
		menuBarRight.addComponent(bRecherche);


		// Title
		nomProj.setStyleName(" title-h1");

		//Recherche

		// Layout principal
		layout.addComponent(menuBar);
		layout.addComponent(grid);
		layout.addComponent(bottom);
		layout.setStyleName(" full-width");

		grid.addComponent(left, 0, 0);
		grid.addComponent(right, 0, 1);
		grid.setWidth("80%");
		grid.setStyleName(" full-width");

		left.setWidth("35%");
		right.setWidth("65%");

		// Panel informations
		left.addComponent(informations);


		// Annonce
		// Titre
		
		// Texte
		
		// Bouton réservation
		
		// Galerie photos

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
