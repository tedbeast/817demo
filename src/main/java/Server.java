import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Server {
    public static void main(String[] args){
        
        Javalin app = Javalin.create();

        app.get("/", Server::handler1);
        app.get("/endpoint", Server::handler2);
        app.post("/endpoint1", Server::handler3);

        app.start(7070);
    
        /*
        List<String> names = new ArrayList<>();
        names.add("Joe");
        names.add("Bill");
        names.add("Jane");
        names.add("Sally");

        names.stream().forEach(name -> {System.out.println(name);});
        // provide java with a method that determines if a item should be filtered out of a result stream, then turn it back to a list
        List<String> namesWithoutJ = names.stream().filter(name -> {return !name.contains("J");}).collect(Collectors.toList());
        System.out.println(namesWithoutJ);
        // provide java with a method that transforms every piece of data in the stream
        List<String> uppercaseNames = names.stream().map(name -> {return name.toUpperCase();}).collect(Collectors.toList());
        System.out.println(uppercaseNames);
        */
    }
    /*
     * Context is the object in Javalin that represents your interaction with both the HTTP request and HTTP response
     */
    public static void handler1(Context ctx){
        System.out.println("hello console");
        ctx.result("Hello Javalin");
    }
    public static void handler2(Context ctx){
        System.out.println("hello console");
        ctx.result("response 2");
    }
    public static void handler3(Context ctx){
        // do something here
    }
}