package ca.durhamcollege.utility;
/*
 *  @title Vector2D.java
 *  @course OOP3200 - F2021 - Lesson 11
 *  @author Tom Tsiliopoulos
 *  @author Taylor Bazouzi
 *
 *
 *
 */

public class Vector2D
{
    public static Vector2D zero;
    // PRIVATE INSTANCE VARIABLES
    private float x;
    private float y;

    // PUBLIC PROPERTIES (MUTATORS & ACCESSORS)
    public float getX()
    {
        return x;
    }

    public void setX(final float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(final float y)
    {
        this.y = y;
    }

    // set function that takes care of everything
    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
    }
    // set function that takes care of everything
    public void set(final Vector2D vector)
    {
        this.x = vector.x;
        this.y = vector.y;
    }

    // CONSTRUCTORS

    Vector2D()  // if no parameters set  x and y to 0
    {
        set(Vector2D.zero());   // takes place of default values in a constructor function
        //this.x= 0;
        //this.y = 0;
    }

    Vector2D(final float x, final float y)
    {
        set(x, y); // calls set function
    }

    // get a vector 2d and pass in another vector 2d
    Vector2D(final Vector2D vector)
    {
        set(vector.getX(), vector.getY()); // get stuff from vector and pass it into the function
    }

    // PRIVATE METHODS

    // PUBLIC METHODS
    public void add(final Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }

    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
        //set(getX() - rhs.getX(), getY() - rhs.getY());
    }

    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }

    public void divide(final Vector2D rhs)
    {
        this.setX(this.getX() / rhs.getX());
        this.setY(this.getY() / rhs.getY());
    }

    public boolean equals(final Vector2D rhs)
    {
        return ((getX() == rhs.getX()) && (getY() == rhs.getY()));
    }


    // Utility functions
    public float getMagnitude()
    {
        return (float)(Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()));
    }

    public float getSqrMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY());
    }

    public void setScale(final float scale)
    {
        this.set(this.getX() * scale, this.getY() * scale);
    }

    // overloaded method to scale up x or y
    public void setScale(final Vector2D scale)  // final makes it type safe, we are using them not modifying them
    {
        this.set(this.getX() * scale.x, this.getY() * scale.y);
    }


    // changes a vectors range between 0 and 1
    public void normalize() //modifies the actual object
    {
        final var magnitude = this.getMagnitude();
        if ((double)(magnitude) > 9.99999974737875E-06)
        {
            set(getX() / magnitude, getY() / magnitude);
        }
	    else
        {
		    set(Vector2D.zero());
        }
    }


    public Vector2D getNormalized() // returns what vector would be if it was normalized
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + "}";
    }

    // STATIC METHODS

    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }

    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }

    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }

    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }

    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        // clamp t between 0.0 and 1.0
        if ((double)(t) < 0.0)
        {
            t = 0.0f;
        }
        if ((double)(t) > 1.0)
        {
            t = 1.0f;
        }

        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    public static float distance(final Vector2D a, final Vector2D b)
    {
	final var delta_x = (double)(b.getX()) - (double)(a.getX());
	final var delta_y = (double)(b.getY()) - (double)(a.getY());

    return (float)(Math.sqrt(delta_x * delta_x + delta_y * delta_y));
    }
    public static final Vector2D random(final Vector2D start, final Vector2D end)
    {
        // generate random Y value
        float minX = Mathf.Min(start.getX(), end.getX());
        float maxX = Mathf.Max(start.getX(), end.getX());
        float randomX = Mathf.RandomRange(minX, maxX);

        // generate random X value
        float minY = Mathf.Min(start.getY(), end.getY());
        float maxY = Mathf.Max(start.getY(), end.getY());
        float randomY = Mathf.RandomRange(minY, maxY);

        return new Vector2D(randomX, randomY);
    }

}
