package game;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerList implements Serializable {
    protected static HashMap<String,Integer> players = new HashMap<>();
    PlayerList(){

        loadFromFile();
    }
    public static void loadFromFile() { // load the players from the file
        try (ObjectInputStream ois = new ObjectInputStream(
                PlayerList.class.getClassLoader().getResourceAsStream("players.txt"))) {
            players = (HashMap<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void addPlayer(String name, int score) { // add a player to the list
        if(name == null || name.equals(""))
            return;
        if (players != null)
        {
            if(players.containsKey(name))
                {
                    if(players.get(name)<score)
                    {
                        players.put(name,score);
                    }
                }
                else
                {
                    players.put(name,score);
                }
        }
        else {
            players = new HashMap<>();
            players.put(name,score);
        }
        saveToFile();



    }

    public static void saveToFile() { // save the players to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File(PlayerList.class.getClassLoader().getResource("players.txt").toURI())))) {
            oos.writeObject(players);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static String getPlayersDescendingOrder(HashMap<String,Integer> players ) { // get the players in descending order
        if(players == null)
            return "No players yet";
        return players.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(entry -> entry.getKey() + ": " + entry.getValue() + " points")
                .collect(Collectors.joining("\n"));
    }
}
