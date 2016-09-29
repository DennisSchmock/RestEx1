/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.it2learn.rest1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dennisschmock
 */
@Path("quote")
public class GenericResource {

    private static Person person = new Person("Dennis", "Schmock");
    private static Gson gson = new Gson();
    private static int nextId = 0;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        nextId = quotes.size();

    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postQuote(String q) {
        nextId++;
        String[] q2 = q.split("=");
        quotes.put(nextId, q2[1]);

        JsonObject quote = new JsonObject();
        quote.addProperty("id", nextId);
        quote.addProperty("quote", q);

        String jsonResponse = gson.toJson(quote);
        return jsonResponse;
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putQuote(@PathParam("id") int id,String q) {
        String[] q2 = q.split("=");
        quotes.put(id, q2[1]);

        JsonObject quote = new JsonObject();
        quote.addProperty("id", id);
        quote.addProperty("quote", q2[1]);

        String jsonResponse = gson.toJson(quote);
        return jsonResponse;
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteQuote(@PathParam("id") int id) {
        String q = quotes.get(id);
        quotes.remove(id);

        JsonObject quote = new JsonObject();
        quote.addProperty("quote", q);

        String jsonResponse = gson.toJson(quote);
        return jsonResponse;
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) {

        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(id));
        String jsonResponse = new Gson().toJson(quote);
        return jsonResponse;
    }
    
    

    @Path("random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote() {
        Random rand = new Random();

        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(rand.nextInt(quotes.size())));
        String jsonResponse = new Gson().toJson(quote);
        return jsonResponse;
    }

    

    

    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(0, "Life isn’t about getting and having, it’s about giving and being. - Kevin Kruse");
            put(1, "Life isn’t about getting and having, it’s about giving and being. - Kevin Kruse");
            put(2, "Whatever the mind of man can conceive and believe, it can achieve. - Napoleon Hill");
            put(3, "Strive not to be a success, but rather to be of value. - Albert Einstein");
            put(4, "Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference. - Robert Frost");
            put(5, "I attribute my success to this: I never gave or took any excuse. - Florence Nightingale");
            put(6, "You miss 100% of the shots you don’t take. - Wayne Gretzky");
            put(7, "I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed. - Michael Jordan");
            put(8, "The most difficult thing is the decision to act, the rest is merely tenacity. - Amelia Earhart");
            put(9, "Every strike brings me closer to the next home run. - Babe Ruth");
            put(10, "Definiteness of purpose is the starting point of all achievement. - W. Clement Stone");
            put(11, "We must balance conspicuous consumption with conscious capitalism. - Kevin Kruse");
            put(12, "Life is what happens to you while you’re busy making other plans. - John Lennon");
            put(13, "We become what we think about. - Earl Nightingale");
            put(14, "14.Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do, so throw off the bowlines, sail away from safe harbor, catch the trade winds in your sails.  Explore, Dream, Discover. - Mark Twain");
            put(15, "15.Life is 10% what happens to me and 90% of how I react to it. - Charles Swindoll");
            put(16, "The most common way people give up their power is by thinking they don’t have any. - Alice Walker");
            put(17, "The mind is everything. What you think you become. - Buddha");
            put(18, "The best time to plant a tree was 20 years ago. The second best time is now. - Chinese Proverb");
            put(19, "An unexamined life is not worth living. - Socrates");
            put(20, "Eighty percent of success is showing up. - Woody Allen");
            put(21, "Your time is limited, so don’t waste it living someone else’s life. - Steve Jobs");
            put(22, "Winning isn’t everything, but wanting to win is. - Vince Lombardi");
            put(23, "I am not a product of my circumstances. I am a product of my decisions. - Stephen Covey");
            put(24, "Every child is an artist.  The problem is how to remain an artist once he grows up. - Pablo Picasso");
            put(25, "You can never cross the ocean until you have the courage to lose sight of the shore. - Christopher Columbus");
            put(26, "I’ve learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel. - Maya Angelou");
            put(27, "Either you run the day, or the day runs you. - Jim Rohn");
            put(28, "Whether you think you can or you think you can’t, you’re right. - Henry Ford");
            put(29, "The two most important days in your life are the day you are born and the day you find out why. - Mark Twain");
            put(30, "Whatever you can do, or dream you can, begin it.  Boldness has genius, power and magic in it. - Johann Wolfgang von Goethe");
            put(31, "The best revenge is massive success. - Frank Sinatra");
            put(32, "People often say that motivation doesn’t last. Well, neither does bathing.  That’s why we recommend it daily. - Zig Ziglar");
            put(33, "Life shrinks or expands in proportion to one’s courage. - Anais Nin");
            put(34, "If you hear a voice within you say “you cannot paint,” then by all means paint and that voice will be silenced. - Vincent Van Gogh");
            put(35, "There is only one way to avoid criticism: do nothing, say nothing, and be nothing. - Aristotle");
            put(36, "Ask and it will be given to you; search, and you will find; knock and the door will be opened for you. - Jesus");
            put(37, "The only person you are destined to become is the person you decide to be. - Ralph Waldo Emerson");
            put(38, "Go confidently in the direction of your dreams.  Live the life you have imagined. - Henry David Thoreau");
            put(39, "When I stand before God at the end of my life, I would hope that I would not have a single bit of talent left and could say, I used everything you gave me. - Erma Bombeck");
            put(40, "Few things can help an individual more than to place responsibility on him, and to let him know that you trust him. - Booker T. Washington");
            put(41, "Certain things catch your eye, but pursue only those that capture the heart. -  Ancient Indian Proverb");
            put(42, "Believe you can and you’re halfway there. - Theodore Roosevelt");
            put(43, "Everything you’ve ever wanted is on the other side of fear. - George Addair");
            put(44, "We can easily forgive a child who is afraid of the dark; the real tragedy of life is when men are afraid of the light. - Plato");
            put(45, "Teach thy tongue to say, “I do not know,” and thous shalt progress. - Maimonides");
            put(46, "Start where you are. Use what you have.  Do what you can. - Arthur Ashe");
            put(47, "When I was 5 years old, my mother always told me that happiness was the key to life.  When I went to school, they asked me what I wanted to be when I grew up.  I wrote down ‘happy’.  They told me I didn’t understand the assignment, and I told them they didn’t understand life. - John Lennon");
            put(48, "Fall seven times and stand up eight. - Japanese Proverb");
            put(49, "When one door of happiness closes, another opens, but often we look so long at the closed door that we do not see the one that has been opened for us. - Helen Keller");
            put(50, "Everything has beauty, but not everyone can see. - Confucius");

        }
    ;
};
}
