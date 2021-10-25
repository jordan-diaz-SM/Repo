package tienda;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

import tienda.config.DBConnectionManager;
import tienda.controllers.impl.CustomerControllerImpl;
import tienda.controllers.impl.OrderControllerImpl;
import tienda.repositories.impl.ClienteRepositorioImpl;
import tienda.repositories.impl.PedidoRepositorioImpl;

public class Main {

    private final DBConnectionManager manager;
    private final CustomerControllerImpl customerController;
    private final OrderControllerImpl orderController;

    public Main() {
        this.manager = new DBConnectionManager();

        ClienteRepositorioImpl customerRepositoryImpl = new ClienteRepositorioImpl(this.manager.getDatabase());
        this.customerController = new CustomerControllerImpl(customerRepositoryImpl);

        PedidoRepositorioImpl orderRepositoryImpl = new PedidoRepositorioImpl(this.manager.getDatabase());
        this.orderController = new OrderControllerImpl(orderRepositoryImpl, customerRepositoryImpl);

    }

    public void startup() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("Demo API");
        OpenApiOptions openApi = new OpenApiOptions(applicationInfo)
                .path("/api")
                .swagger(new SwaggerOptions("/api-ui")); // endpoint for swagger-ui
        Javalin server = Javalin.create(
                config -> {
                    config.registerPlugin(new OpenApiPlugin(openApi));
                }
        ).start(7000);

        server.get("api/customer/:id", this.customerController::find);
        server.delete("api/customer/:id", this.customerController::delete);
        server.get("api/customers", this.customerController::findAll);
        server.post("api/customer", this.customerController::create);

        server.get("api/order/:id", this.orderController::find);
        server.delete("api/order/:id", this.orderController::delete);
        server.get("api/orders", this.orderController::findAll);
        server.post("api/order", this.orderController::create);

        //server.post("api/order/pay/:id", this.orderController::pay);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.manager.closeDatabase();
            server.stop();
        }));
    }

    public static void main(String[] args) {
        new Main().startup();
    }
}
