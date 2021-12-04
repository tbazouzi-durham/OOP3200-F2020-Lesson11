package ca.durhamcollege.core;
/*
 *  @title Vector2D.java
 *  @course OOP3200 - F2021 - Lesson 11
 *  @author Tom Tsiliopoulos
 *  @author Taylor Bazouzi
 *
 *
 *
 */
import ca.durhamcollege.utility.*;
import java.util.Scanner;
import java.util.Vector;

// driver class
public class Main {

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String prompt = "";
        int numOfPoints = 4;

        // instantiates the collection container
        Vector<Vector2D> points = new Vector<Vector2D>();

        // builds a Vector of 4 points
        for (int i = 0; i < numOfPoints; i++)
        {
            points.add(Vector2D.zero());
        }

        for (int i = 0; i < 3; i += 2)
        {
            System.out.print("Enter the first point (x, y): ");
            prompt = keyboard.nextLine();
            var values = prompt.split(",");
            points.get(i).set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("You Entered " + points.get(i).toString() + " for the first point" );
            System.out.println("--------------------------------------------------------------\n" );

            System.out.print("Enter the second point (x, y): ");

            prompt = keyboard.nextLine();
            values = prompt.split(",");
            points.get(i+1).set(Float.parseFloat(values[0]), Float.parseFloat(values[1]));

            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("You Entered " + points.get(i+1).toString() + " for the second point" );
            System.out.println("--------------------------------------------------------------\n" );

            //Vector2D randomVector2D = RandomVector.Instance().createVector2D(points.get(i), points.get(i+1));
            Vector2D randomVector2D = Vector2D.random(points.get(i), points.get(i+1));
            System.out.println("\n--------------------------------------------------------------" );
            System.out.println("The Random Vector is: " + randomVector2D.toString());
            System.out.println("--------------------------------------------------------------\n" );

            points.add(randomVector2D);
        }




        System.out.printf("Magnitude of first random point is: %.3f \n", points.get(4).getMagnitude());
        System.out.printf("Magnitude of second random point is: %.3f \n",points.get(5).getMagnitude());
        System.out.printf("Distance between first random point and second random point is: %.3f \n", Vector2D.distance(points.get(4), points.get(5)));
        System.out.println("--------------------------------------------------------------\n" );

    }
}
