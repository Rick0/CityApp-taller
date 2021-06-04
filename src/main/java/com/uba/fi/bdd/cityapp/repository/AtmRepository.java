package com.uba.fi.bdd.cityapp.repository;

import static com.uba.fi.bdd.cityapp.repository.DatabaseConnection.getConnection;

import com.uba.fi.bdd.cityapp.model.ATM;
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
public class AtmRepository extends BaseRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AtmRepository.class);

	public static final String TABLE_NAME = "cajeros_automaticos";

	public List<ATM> get(int limit, int page) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			List<ATM> atmList = new ArrayList<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
//			LOGGER.debug("Retrieved {} ATMs with offset {}", atmList.size(), offset);
			return atmList;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting ATM data", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	private static ATM buildATM(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String bankName = resultSet.getString("banco");
		String bankNetwork = resultSet.getString("red");
		int terminalQty = resultSet.getInt("terminales");
		String streetName = resultSet.getString("calle");
		int streetHeight = resultSet.getInt("altura");
		String neighbourhoodName = resultSet.getString("barrio");
		int communeId = resultSet.getInt("comuna");

		return new ATM(id, bankName, bankNetwork, terminalQty, streetName, streetHeight, neighbourhoodName, communeId);
	}

}
