package main.java.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Staff")
public class StaffService {
	
	@POST
	@Path("/Service")
	@Produces(MediaType.APPLICATION_JSON )
	public Result CheckMethod(@FormParam("Name") String name) {
		System.out.println("Check method");
		Result result = new Result();
		result.setCode(200);
		result.setMessage(name);
		return result;
//		return "{'friends': ['Michael', 'Tom', 'Daniel', 'John', 'Nick']}";
	}
	
	
	@GET
	@Path("/friends")
	@Produces(MediaType.APPLICATION_JSON)
	public Result getFriends() {
	
//		JsonParser parser = new JsonParser();

	    Result result = new Result();
	    result.setCode(200);
	    result.setMessage("success");
	    return result;
//	    JsonObject json = (JsonObject) parser.parse(result.toString());
//	    return json;
	}

}
