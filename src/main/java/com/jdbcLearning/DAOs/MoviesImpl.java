package com.jdbcLearning.DAOs;

import com.jdbcLearning.Models.Movies;
import com.jdbcLearning.Models.User;
import com.jdbcLearning.Util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesImpl implements MoviesRepository {


    @Override
    public int insertMovies(Movies movies) {

        int status = 0;

        try (Connection connection2 = SQLConnector.createConnection()) {
            String sql = "INSERT INTO movies (movieTitle, movieGenre, releaseDate) Values (?,?,?)";
            PreparedStatement ps = connection2.prepareStatement(sql);
            ps.setString(1, movies.getMovieTitle());
            ps.setString(2, movies.getMovieGenre());
            ps.setString(3, movies.getReleaseDate());

            status = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return status;
    }

    @Override
    public List<Movies> getAllMovies() {
        ArrayList<Movies> movieList = new ArrayList<>();
        try (Connection connection2 = SQLConnector.createConnection()) {
            String query = "SELECT * from movies";
            PreparedStatement ps = connection2.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Movies moviesRs = new Movies();
                moviesRs.setMovieId(rs.getInt(1));
                moviesRs.setMovieTitle(rs.getString(2));
                moviesRs.setMovieGenre(rs.getString(3));
                moviesRs.setReleaseDate(rs.getString(4));
                movieList.add(moviesRs);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList;
    }

    @Override
    public int updateMovies(Movies updatedMovies) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()){
            String updateQuery = "UPDATE movies set movieTitle =?, movieGenre = ?, releaseDate = ? where movieId = ?";
            PreparedStatement ps = connection2.prepareStatement(updateQuery);
            ps.setString(1, updatedMovies.getMovieTitle());
            ps.setString(2, updatedMovies.getMovieGenre());
            ps.setString(3, updatedMovies.getReleaseDate());
            ps.setInt(4, updatedMovies.getMovieId());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    @Override
    public int deleteMovies(Movies deletedMovies) {
        int status = 0;
        try (Connection connection2 = SQLConnector.createConnection()) {
            String deleteQuery = "DELETE from Movies where movieId = ?";
            PreparedStatement ps = connection2.prepareStatement(deleteQuery);
            ps.setInt(1, deletedMovies.getMovieId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

}



