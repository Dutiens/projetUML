package uml.dutiens.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;


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

	private VerticalLayout layout = new VerticalLayout();
	private HorizontalLayout menuBar = new HorizontalLayout();
	private Label nomProj = new Label("SalleOp") ;
	private TextField tfRecherche = new TextField("Recherche");
	private Button bRecherche = new Button("Recherche") ;


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		// Style de la barre de menu
		menuBar.setStyleName(" menu-bar");
		
		// Barre de menu
		menuBar.addComponent(nomProj);

		// Title
		nomProj.setStyleName(" title-h1");

		//Recherche

		// Layout principal
		layout.addComponent(menuBar);
		layout.setStyleName(" main-layout");

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
