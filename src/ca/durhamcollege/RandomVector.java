package ca.durhamcollege;


import java.util.Random;


public class RandomVector
{
    private Random m_rand;

    // singleton never create more than one instance of this class, ever
    // control global access to this class so others cannot create a not needed constructor
    // 1: private static instance member
    private static RandomVector m_instance = null;

    // 2: make default constructor private
    private RandomVector()   // new keyword can't be used anymore because it is private
    {
        m_rand = new Random();

    }
    // 3: Make a public instance method that acts as a "portal" or "bridge" to the class
    public static RandomVector Instance()  // return pointer to RandomVector
    {
        if(m_instance == null) // if null then create a brand new and save reference to instance member (allocate memory on the heap)
        {
            m_instance = new RandomVector();
        }
        return m_instance;
    }



    //public Vector2D createVector2D(Vector2D start, Vector2D end)
    public final Vector2D createVector2D(final Vector2D start, final Vector2D end)  // never want this method overwritten
    {
        //Random rand = new Random();// instance of the random class --> see singleton method above

        // generate random Y value
        float minX = Math.min(start.getX(), end.getX());
        float maxX = Math.max(start.getX(), end.getX());
        float randomX = (m_rand.nextFloat() * (maxX - minX)) + minX;

        // generate random X value
        float minY = Math.min(start.getY(), end.getY());
        float maxY = Math.max(start.getY(), end.getY());
        float randomY = (m_rand.nextFloat() * (maxY - minY)) + minY;

        return new Vector2D(randomX, randomY);
    }

}
