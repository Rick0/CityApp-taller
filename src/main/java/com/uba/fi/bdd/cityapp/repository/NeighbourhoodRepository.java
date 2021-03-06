package com.uba.fi.bdd.cityapp.repository;

import static com.uba.fi.bdd.cityapp.repository.DatabaseConnection.getConnection;

import com.uba.fi.bdd.cityapp.model.Neighbourhood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NeighbourhoodRepository extends BaseRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(NeighbourhoodRepository.class);

	public static final String TABLE_NAME = "barrios";

	public List<Neighbourhood> getAll() {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			List<Neighbourhood> neighbourhoodList = new ArrayList<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
			LOGGER.debug("Retrieved {} neighbourhoods", neighbourhoodList.size());
			return neighbourhoodList;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting neighbourhood data", e);
			throw new RuntimeException(e);
		}
	}

	public Neighbourhood get(String neighbourhoodName) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 * resultSet.next();
			 * Neighbourhood neighbourhood = buildNeighbourhood(resultSet);
			 */
			LOGGER.debug("Retrieved the neighbourhood {}", neighbourhoodName);
			return new Neighbourhood();
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting neighbourhood {} data", neighbourhoodName, e);
			throw new RuntimeException(e);
		}
	}

	public void add(Neighbourhood neighbourhood) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Neighbourhood {} created", neighbourhood.getName());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while creating neighbourhood {}", neighbourhood.getName(), e);
			throw new RuntimeException(e);
		}
	}

	public void update(Neighbourhood neighbourhood) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Neighbourhood {} updated", neighbourhood.getName());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while updating neighbourhood {}", neighbourhood.getName(), e);
			throw new RuntimeException(e);
		}
	}

	public void delete(String neighbourhoodName) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Neighbourhood {} deleted", neighbourhoodName);
		} catch (SQLException e) {
			LOGGER.error("An error occurred while deleting neighbourhood {}", neighbourhoodName, e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	private static Neighbourhood buildNeighbourhood(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("nombre");
		double area = resultSet.getDouble("area");
		double perimeter = resultSet.getDouble("perimetro");
		int communeId = resultSet.getInt("comuna");

		return new Neighbourhood(name, area, perimeter, communeId);
	}

}
