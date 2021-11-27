package ca.durhamcollege;

import java.util.Scanner;
import java.util.Vector;

// driver class
public class Main {

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String prompt = "";
        int numOfPoints = 6;
        // instantiates the collection container.... generate list of vector
        Vector<Vector2D> points = new Vector<Vector2D>();

        // builds a vector of 4 points
        for(int i = 0; i< numOfPoints; i++)
        {
            points.add(Vector2D.zero());
        }

        for (int i = 0; i <3; i += 2) // for loop to loop twice
        {
            System.out.print("Enter the first point (x, y): ");
            prompt = keyboard.nextLine();
            var values = prompt.split(",");
            points.get(i).set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("You entered " + points.get(i).toString() + " for the first point" );
            System.out.println("--------------------------------------------------------------\n" );
            //Vector2D point2 =  new Vector2D();  // already been instantiated from the points vector
            System.out.print("Please enter the second point (x, y): ");

            prompt = keyboard.nextLine();
            values = prompt.split(",");
            points.get(1).set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("You entered " + points.get(i+1).toString() + " for the second point" );
            System.out.println("--------------------------------------------------------------\n" );

            // skip over a point (0 and 1 next will be 0 and 2, then 0 and 3 and so on if allowed)
            Vector2D randomVector2D = RandomVector.Instance().createVector2D(points.get(i), points.get(i+1));
            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("The random vector is:  " + randomVector2D.toString());
            System.out.println("--------------------------------------------------------------\n" );
            //keyboard.reset();
            points.add(randomVector2D);
        }

        System.out.printf("Magnitude of random first point is: %.3f \n", points.get(4).getMagnitude());
        System.out.printf("Magnitude of random second point is: %.3f \n",points.get(5).getMagnitude());
        System.out.printf("Distance between first random point and second random point is: %.3f \n", Vector2D.distance(points.get(4), points.get(5)));
        System.out.println("--------------------------------------------------------------\n" );
    }



}
