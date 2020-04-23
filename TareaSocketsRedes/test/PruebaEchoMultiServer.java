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
public class PruebaEchoMultiServer {
    
    public PruebaEchoMultiServer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
public void givenClient1_whenServerResponds_thenCorrect() throws IOException {
    GreetClient client1 = new GreetClient();
    client1.startConnection("127.0.0.1", 5555);
    String msg1 = client1.sendMessage("hello");
    String msg2 = client1.sendMessage("world");
    String terminate = client1.sendMessage(".");
     
    assertEquals(msg1, "hello");
    assertEquals(msg2, "world");
    assertEquals(terminate, "bye");
    
    System.out.println("Cliente 1");
    System.out.println(msg1);
    System.out.println(msg2);
}
 
@Test
public void givenClient2_whenServerResponds_thenCorrect() throws IOException {
    GreetClient client2 = new GreetClient();
    client2.startConnection("127.0.0.1", 5555);
    String msg1 = client2.sendMessage("hello");
    String msg2 = client2.sendMessage("world");
    String terminate = client2.sendMessage(".");
     
    System.out.println("Cliente 2");
    assertEquals(msg1, "hello");
    assertEquals(msg2, "world");
    assertEquals(terminate, "bye");
    
    System.out.println(msg1);
    System.out.println(msg2);
}
}
