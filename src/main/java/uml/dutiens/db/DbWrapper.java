package uml.dutiens.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.*;
import org.h2.tools.*;

import java.lang.ClassLoader;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.ArrayList;

public class DbWrapper {

	private static final Logger log = LoggerFactory.getLogger(DbWrapper.class);
	String DBNAME = "salleop" ;
	Server server ;
	Connection conn ;
	Statement stat ;
	boolean not_started = true ;
	String the_ddl_url = "./target/classes/ddl.sql";
	// the file is in ./src/main/resources/ddl.sql
	String the_dml_url = "./target/classes/dml.sql";


	// throws ClassNotFoundException, SQLException, IOException
	public void init() 
	{
		// open the in-memory database within a VM
		try
		{   

			if ( not_started )
			{
				try
				{
					URL the_resource_for_ddl_file = DbWrapper.class.getResource("/ddl.sql");
					// URL resource = getClassLoader().getResource("ddl.sql"); // KO
					if ( the_resource_for_ddl_file != null ) 
					{
						the_ddl_url = new File(the_resource_for_ddl_file.toURI()).getAbsolutePath();
						log.info("Directory : " + the_ddl_url );
					}
					else
					{
						log.info("resource null"  );
					}

				} catch (final URISyntaxException e)
				{ 
					log.info("URISyntaxException !");
					return;
				}


				// String runscript = "INIT = runscript from 'ddl.sql'\\;runscript from 'dml.sql'" ;
				String runscript_ddl = "runscript from '" + the_ddl_url + "'" ; // OK : absolute_path
				// String script_ddl = "runscript from '~/ddl.sql'" ; // a verifier
				// String runscript_ddl = "runscript from 'classpath:ddl.sql'" ; // KO (source : http://stackoverflow.com/questions/4490138/problem-with-init-runscript-and-relative-paths)
				// String runscript_ddl = "runscript from 'classpath:/ddl.sql'" ; // a verifier (source : http://stackoverflow.com/questions/4490138/problem-with-init-runscript-and-relative-paths)
				// String runscript_dml = "runscript from '" + the_dml_url + "'" ; // OK : absolute_path


				// String runscript_all = "INIT=" + runscript_ddl + "\\;" + runscript_dml ; // KO
				// String runscript_all = "INIT = " + runscript_ddl + ";" ; // KO - pas d'espace autour de INIT !!!
				String runscript_all = "INIT=" + runscript_ddl + ";" ; // OK
				// runscript = "INIT=runscript from './target/classes/ddl.sql'" ; // OK
				// runscript = "INIT=runscript from 'ddl.sql'" ; // KO
				// runscript = "CREATE TABLE TEST(ID INT, NAME VARCHAR)" ; // a verifier

				String JDBC_URL = "jdbc:h2:mem:" + DBNAME + ";" + runscript_all  ;
				log.info("JDBC_URL : " + JDBC_URL );
				// URL = "jdbc:h2:mem:" + DBNAME ;

				Class.forName("org.h2.Driver"); // (1)
				conn 
					= DriverManager.getConnection( JDBC_URL , "sa", "sa"); // (2)
				// username:password are very important and must be used for connecting via H2 Console
				log.info("CONNECTION OK !");

				stat = conn.createStatement();
				log.info("createStatement OK !");

			} // end if started

			// finally { log.info("DB mem initiated !");
		} catch (final ClassNotFoundException e) {
			log.info("ClassNotFoundException !");
			return;
		} catch (final SQLException e) {
			log.info("SQLException sur H2mem !");
			return;
		}

		// load in memory a web server for H2 SQL console accessible at port 8082
		if ( not_started )
		{
			// http://stackoverflow.com/questions/34238142/how-to-show-content-of-local-h2-databaseweb-console
			not_started = false ;
			try
			{
				server = Server.createWebServer("-web","-webAllowOthers","-webPort","8082");
				server.start();
				// server = Server.createTcpServer().start();
				log.info(" URL " + server.getURL() ) ;
			} catch (final SQLException e) {
				log.info("SQLException sur Server !");
				return;
			}
		} // end if started
	} // end init()

	public String getNom(long id_annonce) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT u.nom, u.prenom FROM Annonce a, Utilisateur u WHERE a.id = ? AND a.utilisateur_id = u.id");
		ps.setLong(1, id_annonce);
		ResultSet rs = ps.executeQuery();
		String res = String.format("%s %s",
									rs.getString(1),
									rs.getString(2));
		rs.close();
		ps.close();
		return res;
	}

	public String getTitre(long id_annonce) throws SQLException  {
		return null;
	}

	public String getDescription(long id_annonce) throws SQLException {
		return null;
	}	

	public double getTarif(long id_annonce) throws SQLException {
		return 0;
	}

	public String getAdresse(long id_annonce) throws SQLException {
		return null;
	}

	public ArrayList<String> getPhotos(long id_annonce) throws SQLException {
		return null;
	}
}
	/*
	   public class DbStuff1 {
// public void DbStuff();

public void init()
{
	// SOURCE :
	// https://github.com/bmatthews68/inmemdb-maven-plugin/blob/master/src/it/webapp/src/main/java/com/btmatthews/testapp/ListUsersServlet.java
	log.info("DB initiated !");




	try {
	final Context ctx = new InitialContext();
	final DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myDb");
	final Connection con = ds.getConnection();
	try {


	} finally {
	con.close();
	}
	} catch (final SQLException e) {
	log.info("SQLException !");
	return;
	} catch (final NamingException e) {
	log.info("NamingException !");
	return;
	}

}
	   }
	   */
