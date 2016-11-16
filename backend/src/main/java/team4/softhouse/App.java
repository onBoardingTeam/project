package team4.softhouse;


import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import team4.softhouse.auth.LoginAuthenticator;
import team4.softhouse.auth.LoginAuthorizer;
import team4.softhouse.db.InventoryDAO;
import team4.softhouse.db.LoginDAO;
import team4.softhouse.db.OrdersDAO;
import team4.softhouse.db.entity.Login;
import team4.softhouse.process.*;
import team4.softhouse.resource.InventoryResource;
import team4.softhouse.resource.LoginResource;
import team4.softhouse.resource.OrdersResource;

//import team4.softhouse.process.NoteProcess;
//import team4.softhouse.process.NoteProcessDbImpl;



public class App extends Application<TestConfiguration> {

    @Override
    public void run(TestConfiguration configuration, Environment environment) throws Exception {
        final Server h2db = Server.createWebServer("-webDaemon");
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        environment.jersey().setUrlPattern("/api/*");

        // h2
        h2db.start();

        // data access objects
        final InventoryDAO inventoryDAO = dbi.onDemand(InventoryDAO.class);
        final LoginDAO loginDAO = dbi.onDemand(LoginDAO.class);
        final OrdersDAO ordersDAO = dbi.onDemand(OrdersDAO.class);

        // tables
        inventoryDAO.createTable();
        loginDAO.createTable();
        ordersDAO.createTable();


        // processes
        InventoryProcess inventoryProcess = new InventoryProcessDbImpl(inventoryDAO);
        LoginProcess loginProcess = new LoginProcessDbImpl(loginDAO);
        OrdersProcess ordersProcess = new OrdersProcessDbImpl(ordersDAO);

        // resources
        InventoryResource inventoryResource = new InventoryResource(inventoryProcess);
        LoginResource loginResource = new LoginResource(loginProcess);
        OrdersResource ordersResource = new OrdersResource(ordersProcess);

        // environment
        environment.jersey().register(inventoryResource);
        environment.jersey().register(loginResource);
        environment.jersey().register(ordersResource);

        //Authentication and Authorization
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<Login>()
                        .setAuthenticator(new LoginAuthenticator(loginProcess))
                        .setAuthorizer(new LoginAuthorizer(loginProcess))
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Login.class));
    }

    @Override
    public void initialize(Bootstrap<TestConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


}

