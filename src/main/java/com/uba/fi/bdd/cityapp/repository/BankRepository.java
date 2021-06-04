package com.uba.fi.bdd.cityapp.repository;

import static com.uba.fi.bdd.cityapp.repository.DatabaseConnection.getConnection;

import com.uba.fi.bdd.cityapp.model.Bank;
import com.uba.fi.bdd.cityapp.model.Bank;
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
public class BankRepository extends BaseRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankRepository.class);

	public static final String TABLE_NAME = "bancos";

	public List<Bank> getAll() {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 */

			List<Bank> bankList = new ArrayList<>();
			/*
			 * TODO: completame
			 * while (resultSet.next()) {
			 *   ...
			 * }
			 */
			LOGGER.debug("Retrieved {} banks", bankList.size());
			return bankList;
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting bank data", e);
			throw new RuntimeException(e);
		}
	}

	public Bank get(Integer bankId) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 *
			 * resultSet.next();
			 * Bank bank = buildBank(resultSet);
			 */

			LOGGER.debug("Retrieved the bank {}", bankId);
			return new Bank();
		} catch (SQLException e) {
			LOGGER.error("An error occurred while getting bank {} data", bankId, e);
			throw new RuntimeException(e);
		}
	}

	public void add(Bank bank) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 *
			 * resultSet.next();
			 * Bank bank = buildBank(resultSet);
			 */
			LOGGER.debug("Bank {} created", bank.getId());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while creating bank {}", bank.getId(), e);
			throw new RuntimeException(e);
		}
	}

	public void update(Bank bank) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 *
			 * resultSet.next();
			 * Bank bank = buildBank(resultSet);
			 */
			LOGGER.debug("Bank {} updated", bank.getId());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while updating bank {}", bank.getId(), e);
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer bankId) {
		try (Connection conn = getConnection()) {
			/*
			 * TODO: completame
			 * PreparedStatement preparedStatement = conn.prepareStatement(
			 *   ...
			 * );
			 *
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 *
			 * resultSet.next();
			 * Bank bank = buildBank(resultSet);
			 */
			LOGGER.debug("Bank {} deleted", bankId);
		} catch (SQLException e) {
			LOGGER.error("An error occurred while deleting bank {}", bankId, e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	private static Bank buildBank(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("nombre");

		return new Bank(id, name);
	}

}
