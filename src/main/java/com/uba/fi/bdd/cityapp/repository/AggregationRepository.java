package com.uba.fi.bdd.cityapp.repository;

import static com.uba.fi.bdd.cityapp.repository.DatabaseConnection.getConnection;

import com.uba.fi.bdd.cityapp.model.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AggregationRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(AggregationRepository.class);

	public Map<String, Integer> getAggregationQuery1() {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			Map<String, Integer> atmPerNeighbourhoodMap = new LinkedHashMap<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
			LOGGER.debug("Retrieved {} records which satisfy the requirement", atmPerNeighbourhoodMap.size());
			return atmPerNeighbourhoodMap;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting aggregation bank data", e);
			throw new RuntimeException(e);
		}
	}

	public List<String> getAggregationQuery2() {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			List<String> bankList = new ArrayList<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
			LOGGER.debug("Retrieved {} banks which satisfy the requirement", bankList.size());
			return bankList;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting aggregation bank data", e);
			throw new RuntimeException(e);
		}
	}

}
