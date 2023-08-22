import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class Server {
    public static void main(String[] args){
        
        Javalin app = Javalin.create();

        app.get("/", Server::handler1);
        app.get("/hello/{name}", Server::helloHandler);
        app.start(7070);
        app.post("painting", Server::postPaintingHandler);
        app.get("unauthorized", Server::handleUnauthorized);

    }
    public static void postPaintingHandler(Context ctx) throws JsonMappingException, JsonProcessingException{
        // {"author":"wassily kandinsky", "title":"composition x"}
        String requestBody = ctx.body(); 
        ObjectMapper om = new ObjectMapper();
        Painting painting = om.readValue(requestBody, Painting.class);
        if(painting.title == null){
            ctx.status(400);
        }else{
            ctx.json(painting);
        }
    }
    public static void handleUnauthorized(Context ctx){
        ctx.status(401);
    }

    /*
     * Context is the object in Javalin that represents your interaction with both the HTTP request and HTTP response
     */
    public static void handler1(Context ctx){
        System.out.println("hello console");
        ctx.result("Hello Javalin");
    }

    public static void helloHandler(Context ctx){
        String str = ctx.pathParam("name");
        // ctx.result(str);
        ctx.json(str);
    }
    /**
     * path parameters
     * website.com/accounts/12345
     * website.com/accounts/{account_id}
     * query parameters
     * website.com/search?search_query=something
     * headers
     * (security stuff, generally)
     * request body
     * (a certain piece of data)
     * status codes
     * (was the response successful?)
     */

}