import io.javalin.http.Context;

public class Handlers {
    
    public static void handler1(Context ctx){
        System.out.println("hello console");
        ctx.result("Hello Javalin");
    }
    public static void handler2(Context ctx){
        System.out.println("hello console");
        ctx.result("response 2");
    }
}
