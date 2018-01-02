package clients;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.StackExchangeClient;
import fr.tunaki.stackoverflow.chat.Room;

import services.Runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by bhargav.h on 18-May-17.
 */
public class RunDetector {

    public static void main(String[] args) {

        StackExchangeClient client;

        Properties prop = new Properties();

        try{
            prop.load(new FileInputStream("./properties/login.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String email = prop.getProperty("email");
        String password = prop.getProperty("password");

        client = new StackExchangeClient(email, password);

        Room[] rooms = {client.joinRoom(ChatHost.STACK_EXCHANGE ,54445),
        client.joinRoom(ChatHost.STACK_EXCHANGE ,59667)};

        for (Room room: rooms){
            room.send("[ [GetAllTehCommentz](https://git.io/vbxFf) ] started");
        }

        Runner runner = new Runner(rooms);
        runner.startDetector();

    }
}
