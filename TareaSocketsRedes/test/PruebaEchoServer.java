/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tareasocketsredes.GreetClient;


/**
 *
 * @author Steven
 */
public class PruebaEchoServer {
    GreetClient client;
    
    public PruebaEchoServer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        client = new GreetClient();
        client.startConnection("127.0.0.1", 4444);
    }
    
    @After
    public void tearDown() throws IOException {
        client.stopConnection();
    }

    @Test
public void givenClient_whenServerEchosMessage_thenCorrect() throws IOException {
    String resp1 = client.sendMessage("hello");
    String resp2 = client.sendMessage("world");
    String resp3 = client.sendMessage("!");
    String resp4 = client.sendMessage(".");
     
    assertEquals("hello", resp1);
    assertEquals("world", resp2);
    assertEquals("!", resp3);
    assertEquals("good bye", resp4);
    
    System.out.println(resp1);
    System.out.println(resp2);
    System.out.println(resp3);
    System.out.println(resp4);
    
}
}
