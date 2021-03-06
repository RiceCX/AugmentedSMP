package dev.ricecx.augmentedsmp.models.daos;

import dev.ricecx.augmentedsmp.AugmentedSMP;
import dev.ricecx.augmentedsmp.database.Table;
import dev.ricecx.augmentedsmp.models.AugmentedPlayer;
import dev.ricecx.augmentedsmp.utils.LoggingUtils;

import java.sql.SQLException;


public class AugmentedPlayerTable implements Table<AugmentedPlayer> {

    public static void createDefaultTable() {
        try(var con = AugmentedSMP.getInstance().getDatabaseManager().getConnection()) {
            var preparedStatement = con.prepareStatement("CREATE TABLE IF NOT EXISTS `players` (`uuid` VARCHAR(255) UNIQUE NULL PRIMARY KEY, `last_jointime` TIMESTAMP NULL)"
            );
            preparedStatement.execute();
        } catch (SQLException throwables) {
            LoggingUtils.error("Could not set up database");
            throwables.printStackTrace();
        }
    }
}
