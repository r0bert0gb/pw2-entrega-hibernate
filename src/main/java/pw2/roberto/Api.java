package pw2.roberto;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pw2.roberto.model.Channel;
import pw2.roberto.model.User;

@Path("/user")
public class Api {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User createUser(@FormParam("name") String name) {

        var message = new Message();
        message.setText("Mensagem de teste");
        message.persist();

        var channel = new Channel();
        channel.setHash("Hash do Canal");
        channel.addMessage(message);
        channel.persist();

        User user = new User();
        user.setName(name);
        user.addChannel(channel);
        user.persist();

        return user;
    }

}
