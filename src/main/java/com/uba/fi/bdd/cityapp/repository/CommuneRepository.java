package com.uba.fi.bdd.cityapp.repository;

import static com.uba.fi.bdd.cityapp.repository.DatabaseConnection.getConnection;

import com.uba.fi.bdd.cityapp.model.Commune;
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
public class CommuneRepository extends BaseRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommuneRepository.class);

	public static final String TABLE_NAME = "comunas";

	public List<Commune> getAll() {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			List<Commune> communeList = new ArrayList<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
			LOGGER.debug("Retrieved {} communes", communeList.size());
			return communeList;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting commune data", e);
			throw new RuntimeException(e);
		}
	}

	public Commune get(Integer communeId) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 * resultSet.next();
			 * Commune commune = buildCommune(resultSet);
			 */
			LOGGER.debug("Retrieved the commune {}", communeId);
			return new Commune();
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting commune {} data", communeId, e);
			throw new RuntimeException(e);
		}
	}

	public void add(Commune commune) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Commune {} created", commune.getId());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while creating commune {}", commune.getId(), e);
			throw new RuntimeException(e);
		}
	}

	public void update(Commune commune) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Commune {} updated", commune.getId());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while updating commune {}", commune.getId(), e);
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer communeId) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */
			LOGGER.debug("Commune {} deleted", communeId);
		} catch (SQLException e) {
			LOGGER.error("An error occurred while deleting commune {}", communeId, e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	private static Commune buildCommune(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		double area = resultSet.getDouble("area");
		double perimeter = resultSet.getDouble("perimetro");
		String neighbourhoodsList = resultSet.getString("listado_barrios");

		return new Commune(id, area, perimeter, neighbourhoodsList);
	}

}
