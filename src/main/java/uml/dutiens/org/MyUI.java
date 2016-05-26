package uml.dutiens.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.shared.ui.label.*;

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


	private final HorizontalLayout content = new HorizontalLayout();
	private final VerticalLayout left = new VerticalLayout();
	private final VerticalLayout right = new VerticalLayout();
	private final HorizontalLayout bottom = new HorizontalLayout();

	private final Panel informationsP = new Panel("Informations");
	private final FormLayout infoContent = new FormLayout();

	private final Label informations = new Label("Des informations super cool\nAvoue, t'es jaloux\nTrolol", ContentMode.HTML) ;

	private final Label titreAnnonce = new Label("<h1>Un titre</h1>", ContentMode.HTML);
	private final Label label = new Label(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean enim lacus, mollis eu leo sed, interdum semper mauris. Morbi tortor nulla, tempor sed sem consequat, convallis tincidunt neque. Nunc commodo dolor turpis, eu venenatis metus faucibus vel. Donec id orci dui. Curabitur vitae tristique odio. Aenean sagittis lacus leo, ac tincidunt lectus mattis at. Praesent at enim ac dolor pulvinar suscipit. Aliquam consequat mollis ultrices. Phasellus velit nisl, semper ut tempor placerat, eleifend sit amet sem. Donec porttitor odio magna, nec gravida nisi maximus sit amet. Curabitur et quam porttitor, pulvinar neque a, scelerisque urna. Vivamus nec ante lobortis, dignissim leo a, sagittis est. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent vitae est semper, luctus elit ac, ultricies tortor. Pellentesque gravida ut purus quis condimentum. Proin bibendum vitae arcu et viverra. Phasellus mollis erat sem, vitae scelerisque risus tristique et. Aliquam scelerisque nisl eu nulla ultricies elementum. Ut urna nulla, facilisis et elit sit amet, laoreet viverra nulla. Quisque commodo eu elit eu luctus. Morbi varius suscipit tortor vel finibus. Maecenas ullamcorper leo id nulla fermentum, in semper metus posuere. Maecenas a maximus lacus, a varius tellus. Mauris ullamcorper lobortis luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer sit amet metus gravida, accumsan nibh non, maximus nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ut ipsum imperdiet, fringilla leo quis, ullamcorper augue. Vestibulum quis venenatis tortor. Quisque eget magna sed dui rhoncus tempor in in leo. Maecenas eget nulla eu nunc pretium mattis. Vivamus maximus elementum ante a rhoncus. Cras rhoncus finibus eros sit amet consectetur. Proin fermentum elit at lectus vehicula euismod. Nullam ut sem placerat, facilisis tellus et, sagittis nisi. Aliquam ut eros sed risus facilisis ornare. Suspendisse vitae mi nec lacus luctus lobortis nec pellentesque tortor. Vivamus at enim et ligula maximus efficitur. In hac habitasse platea dictumst. In lacus massa, vehicula ut feugiat eu, vehicula at turpis. Fusce blandit vitae risus viverra pharetra. Donec sit amet luctus sapien. Maecenas leo libero, semper quis dignissim et, mattis a mi. Cras sed tellus suscipit risus lacinia convallis. Ut nec volutpat leo, eu gravida mauris. Vestibulum a porttitor nisl, id fermentum lectus. Nullam pellentesque nibh sit amet rutrum consectetur. Praesent nec felis luctus, rutrum mauris eget, hendrerit nisl. Vestibulum euismod a elit eget fringilla. Nullam fringilla pretium ullamcorper. Nullam ac arcu nunc. Nam justo leo, ornare ut gravida ac, hendrerit id justo. Fusce auctor sodales felis malesuada porta. Suspendisse suscipit dolor eget tellus mollis fermentum. Donec a eros metus. Vivamus elit magna, porta et vulputate et, auctor quis orci.");



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
		layout.addComponent(content);
		layout.addComponent(bottom);
		layout.setStyleName(" full-width");

		content.addComponent(left);
		content.addComponent(right);
		content.setWidth("80%");
		content.setStyleName(" full-width block-margin");

		left.setWidth("35%");

		// Panel informations
		left.addComponent(informationsP);
		infoContent.addComponent(informations);
		informationsP.setContent(infoContent);

		// Annonce
		right.addComponent(titreAnnonce);
		right.addComponent(label);

		// Bouton réservation
		
		// Galerie photos

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
