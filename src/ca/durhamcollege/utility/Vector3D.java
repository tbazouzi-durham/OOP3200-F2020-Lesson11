package ca.durhamcollege.utility;

public class Vector3D extends Vector2D
{
    // PRIVATE INSTANCE VARIABLES
    private float z;

    // PUBLIC PROPERTIES
    public float getZ()
    {
        return z;
    }

    public void setZ(float z)
    {
        this.z = z;
    }

    @Override
    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
        this.z = 0.0f;
    }

    public void set(final float x, final float y, final float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void set(final Vector2D vector)
    {
        this.x = vector.x;
        this.y = vector.y;
        this.z = 0.0f;
    }

    public void set(final Vector3D vector)
    {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    // CONSTRUCTORS
    Vector3D()
    {
        super();
        setZ(0.0f);
    }

    Vector3D(final float x, final float y, final float z)
    {
        super(x, z);
        setZ(z);
    }

    Vector3D(final Vector2D vector)
    {
        super(vector);
        setZ(0.0f);
    }

    Vector3D(final Vector3D vector)
    {
        super(vector.x, vector.y);
        setZ(vector.z);
    }

    // PRIVATE METHODS

    // PUBLIC METHODS
    public void add(final Vector3D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
        this.setZ(this.getZ() + rhs.getZ());
    }

    public void subtract(final Vector3D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
        this.setZ(this.getZ() - rhs.getZ());
    }

    public void multiply(final Vector3D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
        this.setZ(this.getZ() * rhs.getZ());
    }

    public void divide(final Vector3D rhs)
    {
        this.setX(this.getX() / rhs.getX());
        this.setY(this.getY() / rhs.getY());
        this.setZ(this.getZ() / rhs.getZ());
    }

    public boolean equals(final Vector3D rhs)
    {
        return ((getX() == rhs.getX()) && (getY() == rhs.getY()) && (getZ() == rhs.getZ()));
    }

    @Override
    public float getMagnitude()
    {
        return (float)(Mathf.Sqrt(this.getX() * this.getX() + this.getY() * this.getY()) );
    }

    @Override
    public float getSqrMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());
    }

    @Override
    public void setScale(final float scale)
    {
        this.set(this.getX() * scale, this.getY() * scale, this.getZ() * scale);
    }

    public void setScale(final Vector3D scale)
    {
        this.set(this.getX() * scale.x, this.getY() * scale.y, this.getZ() * scale.z);
    }

    @Override
    public void normalize()
    {
        final var magnitude = this.getMagnitude();
        if ((double)(magnitude) > 9.99999974737875E-06)
        {
            set(getX() / magnitude, getY() / magnitude, getZ() / magnitude);
        }
        else
        {
            set(Vector3D.zero());
        }
    }

    @Override
    public Vector2D getNormalized()
    {
        Vector3D vector = new Vector3D(getX(), getY(), getZ());
        vector.normalize();
        return vector;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // STATIC METHODS
    public static Vector3D zero()
    {
        return new Vector3D(0.0f, 0.0f, 0.0f);
    }

    public static Vector3D one()
    {
        return new Vector3D(1.0f, 1.0f, 1.0f);
    }

    public static Vector3D up()
    {
        return new Vector3D(0.0f, 1.0f, 0.0f);
    }

    public static Vector3D down()
    {
        return new Vector3D(0.0f, -1.0f, 0.0f);
    }

    public static Vector3D left()
    {
        return new Vector3D(-1.0f, 0.0f, 0.0f);
    }

    public static Vector3D right()
    {
        return new Vector3D(1.0f, 0.0f, 0.0f);
    }

    public static Vector3D forward()
    {
        return new Vector3D(0.0f, 0.0f, 1.0f);
    }

    public static Vector3D back()
    {
        return new Vector3D(0.0f, 0.0f, -1.0f);
    }
}