import io.javalin.Javalin;

public class Server {
    public static void main(String[] args){
        Javalin app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello Javalin"))
                .start(7070);
    }
}