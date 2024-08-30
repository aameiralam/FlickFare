package com.jdbcLearning;

import com.jdbcLearning.DAOs.MoviesImpl;
import com.jdbcLearning.DAOs.SubscriptionImpl;
import com.jdbcLearning.DAOs.UserImpl;
import com.jdbcLearning.Models.Movies;
import com.jdbcLearning.Models.Subscription;
import com.jdbcLearning.Models.User;
import com.jdbcLearning.Util.SQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {


        Connection connection2 = SQLConnector.createConnection();
        System.out.println(connection2);


        UserImpl userDatabase = new UserImpl();
        MoviesImpl moviesDatabase = new MoviesImpl();
        SubscriptionImpl subscriptionDatabase = new SubscriptionImpl();


        Scanner scan = new Scanner(System.in);
        System.out.println("************************  FlickFare  ************************");
        System.out.println();

        boolean Halt = false;
        while (!Halt) {


            System.out.println("1) Hop into User Details");
            System.out.println();
            System.out.println("2) Hop into Movies");
            System.out.println();
            System.out.println("3) Hop into Subscription");
            System.out.println();
            System.out.println("4) Recommend Movies based on Genre");



            int mainOption = scan.nextInt();
            scan.nextLine();


            if (mainOption == 1) {

                boolean Stop = false;
                while (!Stop) {

                    System.out.println("1) Enter your User Details: ");

                    System.out.println("2) Show all the User listed in the database: ");

                    System.out.println("3) Update User details from the database: ");

                    System.out.println("4) Delete any User detail: ");

                    System.out.println("5) Exit from FlickFaree: ");

                    int Option = scan.nextInt();
                    scan.nextLine();

                    if (Option == 1) {

                        System.out.println("Enter your First Name: ");
                        String firstName = scan.nextLine();

                        System.out.println("Enter your Last Name: ");
                        String lastName = scan.nextLine();

                        System.out.println("Enter your Phone Number: ");
                        long phoneNumber = scan.nextLong();
                        scan.nextLine();

                        System.out.println("Enter your address: ");
                        String address = scan.nextLine();

                        User userMaking = new User(firstName, lastName, phoneNumber, address);
                        userDatabase.insertUser(userMaking);
                        System.out.println();
                        System.out.println();
                        System.out.println("You have successfully entered your user details in FlickFaree ! ");


                    } else if (Option == 2) {
                        System.out.println("All the USER listed are as follows: ");
                        System.out.println();
                        System.out.println();
                        List<User> userList = userDatabase.getAllUser();

                        for (User userRead : userList) {
                            System.out.println("User Id: " + userRead.getId());
                            System.out.println();
                            System.out.println("First Name: " + userRead.getFirstName());
                            System.out.println("Last Name: " + userRead.getLastName());
                            System.out.println("Phone Number: " + userRead.getPhoneNumber());
                            System.out.println("Address:  " + userRead.getAddress());



                        }

                    } else if (Option == 3) {


                        System.out.println("Enter the ID of the User you want to update: ");
                        int userId = scan.nextInt();
                        scan.nextLine();

                        User userToUpdate = new User();
                        userToUpdate.setId(userId);

                        System.out.println("Enter the updated first name: ");
                        String newFirstName = scan.nextLine();


                        System.out.println("Enter the updated last name: ");
                        String newLastName = scan.nextLine();


                        System.out.println("Enter the updated phone number: ");
                        long newPhoneNumber = scan.nextLong();
                        scan.nextLine();


                        System.out.println("Enter the updated address: ");
                        String newAddress = scan.nextLine();

                        userToUpdate.setFirstName(newFirstName);
                        userToUpdate.setLastName(newLastName);
                        userToUpdate.setPhoneNumber(newPhoneNumber);
                        userToUpdate.setAddress(newAddress);

                        int updateStatus = userDatabase.updateUser(userToUpdate);
                        System.out.println(updateStatus);
                        System.out.println();
                        System.out.println();
                        System.out.println("Your User with the given ID have been successfully updated");


                    } else if (Option == 4) {

                        System.out.println("Enter the User ID you would want to delete from the system: ");
                        int userDeleteId = scan.nextInt();
                        scan.nextLine();

                        User userToDelete = new User();
                        userToDelete.setId(userDeleteId);

                        int deleteStatus = userDatabase.deleteUser(userToDelete);
                        System.out.println();
                        System.out.println();
                        System.out.println("The details for the given User ID has been deleted successfully");


                    } else if (Option == 5) {

                        System.out.println();
                        System.out.println();
                        System.out.println(" Thank you for using the dealership app ! ");
                        Stop = true;
                    }
                }
            } else if (mainOption == 2) {


                boolean Halt2 = false;
                while (!Halt2) {

                    System.out.println("1) Enter Movie details: ");

                    System.out.println("2) Show all the Movies listed in the database: ");

                    System.out.println("3) Update Movie details from the database: ");

                    System.out.println("4) Delete any Movie detail: ");

                    System.out.println("5) Exit from FlickFaree: ");

                    int Option2 = scan.nextInt();
                    scan.nextLine();

                    if (Option2 == 1) {

                        System.out.println("Enter Movie Title: ");
                        String movieTitle = scan.nextLine();

                        System.out.println("Enter Movie Genre: ");
                        String movieGenre = scan.nextLine();

                        System.out.println("Enter release date: ");
                        String releaseDate = scan.nextLine();


                        Movies moviesMaking = new Movies(movieTitle, movieGenre, releaseDate);
                        moviesDatabase.insertMovies(moviesMaking);
                        System.out.println();
                        System.out.println();
                        System.out.println("You have successfully entered Movie details into FlickFaree ! ");


                    } else if (Option2 == 2) {
                        System.out.println("All the movie information are listed as follows: ");
                        System.out.println();
                        System.out.println();
                        List<Movies> movieList = moviesDatabase.getAllMovies();

                        for (Movies moviesFor : movieList) {
                            System.out.println("Movie Id: " + moviesFor.getMovieId());
                            System.out.println();
                            System.out.println("Movie Title: " + moviesFor.getMovieTitle());
                            System.out.println("Movie Genre: " + moviesFor.getMovieGenre());
                            System.out.println("Released Date: " + moviesFor.getReleaseDate());



                        }

                    } else if (Option2 == 3) {


                        System.out.println("Enter the MOVIE ID you want to update: ");
                        int movieId = scan.nextInt();
                        scan.nextLine();

                        Movies moviesToUpdate = new Movies();
                        moviesToUpdate.setMovieId(movieId);

                        System.out.println("Enter the updated Movie Title: ");
                        String newTitle = scan.nextLine();


                        System.out.println("Enter the updated Movie Genre: ");
                        String newGenre = scan.nextLine();


                        System.out.println("Enter the updated release date: ");
                        String newDate = scan.nextLine();

                        moviesToUpdate.setMovieTitle(newTitle);
                        moviesToUpdate.setMovieGenre(newGenre);
                        moviesToUpdate.setReleaseDate(newDate);


                        int updateStatus2 = moviesDatabase.updateMovies(moviesToUpdate);
                        System.out.println(updateStatus2);
                        System.out.println();
                        System.out.println();
                        System.out.println("Your MOVIE with the given ID have been successfully updated");


                    } else if (Option2 == 4) {

                        System.out.println("Enter the MOVIE ID you would want to delete from the system: ");
                        int movieDeleteId = scan.nextInt();
                        scan.nextLine();

                        Movies moviesToDelete = new Movies();
                        moviesToDelete.setMovieId(movieDeleteId);

                        int movieStatus2 = moviesDatabase.deleteMovies(moviesToDelete);
                        System.out.println();
                        System.out.println();
                        System.out.println("The details for the given MOVIES ID has been deleted successfully");


                    } else if (Option2 == 5) {

                        System.out.println();
                        System.out.println();
                        System.out.println(" Thank you for using FlickFaree ! ");
                        Halt2 = true;


                    }
                }
            } else if (mainOption == 3) {

                boolean Halt3 = false;
                while (!Halt3) {

                    System.out.println("1) Enter Subscription details: ");

                    System.out.println("2) Update Movie details from the database: ");

                    System.out.println("3) Delete any Subscription detail: ");

                    System.out.println("4) Exit from FlickFaree: ");

                    int Option3 = scan.nextInt();
                    scan.nextLine();

                    if (Option3 == 1) {

                        System.out.println("Enter Subscription type eg. (monthly,yearly): ");
                        String subType = scan.nextLine();

                        System.out.println("Enter Start Date eg. (YYYY-MM-DD): ");
                        String subDate = scan.nextLine();

                        System.out.println("Enter Subscription Status eg. (Active, Inactive, Paused): ");
                        String subStatus = scan.nextLine();


                        Subscription subMaking = new Subscription( subType,subDate, subStatus );
                        subscriptionDatabase.insertSubscription(subMaking);
                        System.out.println();
                        System.out.println();
                        System.out.println("You have successfully entered Subscription details into FlickFaree ! ");



                    } else if (Option3 == 2) {


                        System.out.println("Enter the Subscription ID you want to update: ");
                        int subId = scan.nextInt();
                        scan.nextLine();

                        Subscription subToUpdate = new Subscription();
                        subToUpdate.setSubscriptionId(subId);

                        System.out.println("Enter the updated Subscription Type: ");
                        String newType = scan.nextLine();

                        subToUpdate.setSubscriptionType(newType);

                        int updateStatus3 = subscriptionDatabase.updateSubscription(subToUpdate);
                        System.out.println(updateStatus3);
                        System.out.println();
                        System.out.println();
                        System.out.println("Your Subscription with the given ID have been successfully updated");


                    } else if (Option3 == 3) {

                        System.out.println("Enter the SUBSCRIPTION ID you would want to delete from the system: ");
                        System.out.println();
                        int subDeleteId = scan.nextInt();
                        scan.nextLine();

                        Subscription subToDelete = new Subscription();
                        subToDelete.setSubscriptionId(subDeleteId);

                        int subStatus3 = subscriptionDatabase.deleteSubscription(subToDelete);
                        System.out.println();
                        System.out.println();
                        System.out.println("The details for the given SUBSCRIPTION ID has been deleted successfully");


                    } else if (Option3 == 4) {

                        System.out.println();
                        System.out.println();
                        System.out.println(" Thank you for using FlickFaree ! ");
                       Halt3 = true;


                    }
                }


            } else if (mainOption==4) {

                System.out.print("Enter genre: ");
                System.out.println();
                String genre = scan.nextLine();

                List<Movies> movies = moviesDatabase.getAllMovies();
                boolean found = false;

                System.out.println("Recommended Movies:");
                System.out.println();
                for (Movies movie : movies) {
                    if (movie.getMovieGenre().equalsIgnoreCase(genre)) {
                        System.out.println("Movie Id: " + movie.getMovieId());
                        System.out.println("Movie Title: " + movie.getMovieTitle());
                        System.out.println("Movie Genre: " + movie.getMovieGenre());
                        System.out.println("Released Date: " + movie.getReleaseDate());
                        System.out.println();
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println();
                    System.out.println("No movies found for the genre: " + genre);
                }

            }else{
                System.out.println();
                System.out.println(" Invalid Option. Please try again. ");
            }
        }














    }
}
