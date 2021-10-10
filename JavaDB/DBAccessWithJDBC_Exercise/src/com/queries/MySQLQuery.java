package com.queries;

public class MySQLQuery {
    public static final String villainsNames = "SELECT name, COUNT(DISTINCT minion_id) AS number FROM villains\n" +
            "JOIN minions_villains mv on villains.id = mv.villain_id\n" +
            "GROUP BY name\n" +
            "HAVING number > 15\n" +
            "ORDER BY number DESC;";
    public static final String villainNameByID = "SELECT name FROM villains WHERE id = ?;";
    public static final String minionsNameAndAge = "SELECT name, age FROM minions\n" +
            "JOIN minions_villains mv on minions.id = mv.minion_id\n" +
            "WHERE villain_id = ?;";
    public static final String towns = "SELECT name FROM towns\n" +
            "WHERE country = ?;";
    public static final String townsToUpper = "UPDATE towns SET name = UPPER(name)\n" +
            "WHERE country = ?;";
    public static final String allMinionsNames = "SELECT name FROM minions;";
    public static final String getTowns = "SELECT * FROM towns\n" +
            "WHERE name = ?;";
    public static final String getVillains = "SELECT * FROM villains\n" +
            "WHERE name = ?;";
    public static final String getMinions = "SELECT * FROM minions\n" +
            "WHERE name = ?;";
    public static final String insertTown = "INSERT INTO towns(name) VALUES (?);";
    public static final String insertVillain = "INSERT INTO villains(name, evilness_factor) VALUES (?, 'evil');";
    public static final String insertMinion = "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?);";
    public static final String setMinionToVillain = "INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, ?);";
    public static final String getTownID = "SELECT id FROM towns\n" +
            "WHERE name = ?;";
    public static final String getVillainID = "SELECT id FROM villains\n" +
            "WHERE name = ?;";
    public static final String getMinionID = "SELECT id FROM minions\n" +
            "WHERE name = ?;";
    public static final String increaseAge = "UPDATE minions SET age = age + 1, name = LOWER(name)\n" +
            "WHERE id = ?;";
    public static final String minionsNameAge = "SELECT name, age FROM minions;";
    public static final String getMinionNameAndAge = "SELECT name, age FROM minions WHERE id = ?;";
    public static final String getVillainByID = "SELECT name FROM villains WHERE id = ?;";
    public static final String deleteMinionsByVillainID = "DELETE FROM minions_villains WHERE villain_id = ?;";
    public static final String deleteVillain = "DELETE FROM villains WHERE id = ?;";
}
