package uml.dutiens.org;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.shared.ui.label.*;
import com.vaadin.addon.calendar.event.*;
import com.vaadin.addon.calendar.*;
import com.vaadin.tapio.googlemaps.*;
import com.vaadin.tapio.googlemaps.client.*;
import com.vaadin.tapio.googlemaps.client.overlays.*;

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

	private Metier metier;

	private static final Logger log = LoggerFactory.getLogger(MyUIServlet.class);

	private final VerticalLayout layout = new VerticalLayout();
	private final HorizontalLayout menuBar = new HorizontalLayout();
	private final CssLayout menuBarRight = new CssLayout();
	private final Label nomProj = new Label("SalleOp") ;
	private final TextField tfRecherche = new TextField();
	private final Button bRecherche = new Button("Recherche") ;


	private final HorizontalLayout content = new HorizontalLayout();
	private final VerticalLayout left = new VerticalLayout();
	private final VerticalLayout right = new VerticalLayout();
	private final HorizontalLayout bottom = new HorizontalLayout();

	private final Panel informationsP = new Panel("Informations");
	private final FormLayout infoContent = new FormLayout();

	private final Label nom = new Label("Nom : ", ContentMode.HTML) ;
	private final Label adresse = new Label("Adresse : ", ContentMode.HTML) ;
	private final Label tarif = new Label("Tarif : ", ContentMode.HTML) ;

	private final GoogleMap googleMap = new GoogleMap(null, null, null);
	private final Calendar calendar = new Calendar();

	private final Label titreAnnonce = new Label("<h1>Un titre</h1>", ContentMode.HTML);
	private final Label annonce = new Label();
	private final Button bReservation = new Button("Reserver") ;


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		this.metier = new Metier(1);

		//Définition des textes
		nom.setValue(String.format("Nom : %s", metier.getNom()));
		adresse.setValue(String.format("Adresse : %s", metier.getAdresse()));
		tarif.setValue(String.format("Tarif : %.2f €", metier.getTarif()));
		//browser = new BrowserFrame("Browser", new ExternalResource(metier.getMap()));
		titreAnnonce.setValue(String.format("<h1>%s</h1>", metier.getTitre()));
		annonce.setValue(metier.getDescription());

		// Style de la barre de menu
		menuBar.setStyleName(" menu-bar");

		// Barre de menu
		menuBar.addComponent(nomProj);
		menuBar.addComponent(menuBarRight);
		menuBarRight.setStyleName(" element-align-middle element-align-right");
		nomProj.setStyleName(" element-align-middle");

		menuBarRight.addComponent(tfRecherche);
		menuBarRight.addComponent(bRecherche);
		bRecherche.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				System.out.println(String.format("GOTO PAGE recherche %s", tfRecherche.getValue()));
			}
		});

		// Title
		nomProj.setStyleName(" title-h1");

		//Recherche

		// Layout principal
		layout.addComponent(menuBar);
		layout.addComponent(content);
		layout.addComponent(bottom);
		layout.setStyleName(" full-width");

		content.addComponent(left);
		content.addComponent(right);
		content.setWidth("80%");
		content.setStyleName(" full-width block-margin");

		content.setExpandRatio(left, (float)3.0);
		content.setExpandRatio(right, (float)7.0);

		// Panel informations
		left.addComponent(informationsP);
		infoContent.addComponent(nom);
		infoContent.addComponent(adresse);
		infoContent.addComponent(tarif);
		informationsP.setContent(infoContent);
		informationsP.setWidth("100%");

		googleMap.setCenter(new LatLon(49.4405134, 1.0751172000000224));
		googleMap.addMarker(new GoogleMapMarker("Maaria",new LatLon(49.4405134, 1.0751172000000224), false));
    googleMap.setZoom(15);
    googleMap.setSizeFull();

		Date start = new Date();
		Date end = new Date(start.getTime() + 2*24*60*60*1000);

		calendar.setStartDate(start);
		calendar.setEndDate(end);
		calendar.setStyleName(" calendar");
		calendar.setWidth("576px");
		calendar.setHeight("400px");

		left.addComponent(googleMap);
		left.addComponent(calendar);
		left.setStyleName(" marginTop20");

		// Annonce
		annonce.setContentMode(ContentMode.HTML);
		right.addComponent(titreAnnonce);
		right.addComponent(annonce);

		// Bouton réservation
		bReservation.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				System.out.println(String.format("GOTO PAGE reservation id: %d", metier.getId()));
			}
		});
		bReservation.setStyleName(" marginTop20 floatRight");
		right.addComponent(bReservation);
		right.setStyleName(" padding20");
		// Galerie photos

		setContent(layout);

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
