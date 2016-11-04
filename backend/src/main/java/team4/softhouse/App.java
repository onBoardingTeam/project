package team4.softhouse;


import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import team4.softhouse.db.InventoryDAO;
//import team4.softhouse.process.NoteProcess;
//import team4.softhouse.process.NoteProcessDbImpl;
import team4.softhouse.resource.InventoryResource;



public class App extends Application<TestConfiguration> {

    @Override
    public void run(TestConfiguration configuration, Environment environment) throws Exception {
        final Server h2db = Server.createWebServer("-webDaemon");
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        // h2
        h2db.start();

        // data access objects
        final InventoryDAO inventoryDAO = dbi.onDemand(InventoryDAO.class);

        // tables
        inventoryDAO.createTable();

        // processes
        //NoteProcess noteProcess = new NoteProcessDbImpl(inventoryDAO);

        // resources
        InventoryResource inventoryResource = new InventoryResource(inventoryDAO);

        // environment
        environment.jersey().register(inventoryResource);
    }

    @Override
    public void initialize(Bootstrap<TestConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


}

