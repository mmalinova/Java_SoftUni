package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

import static com.queries.MySQLQuery.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static Connection connection = null;

    public static void main(String[] args) throws IOException, SQLException {
        connection = getConnection();

        System.out.println("Enter exercise number:");
        int number = Integer.parseInt(reader.readLine());

        switch (number) {
            case 2 -> exTwo();
            case 3 -> exThree();
            case 4 -> exFour();
            case 5 -> exFive();
            case 6 -> exSix();
            case 7 -> exSeven();
            case 8 -> exEight();
            case 9 -> exNine();
        }
    }

    private static void exNine() throws IOException, SQLException {
        System.out.println("Enter minion id:");
        int id = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, id);
        callableStatement.executeUpdate();

        PreparedStatement statement = connection.prepareStatement(getMinionNameAndAge);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static void exEight() throws IOException, SQLException {
        System.out.println("Enter minions IDs, separated by space:");
        String ids = reader.readLine();
        String[] id = ids.split("\\s+");
        for (String item : id) {
            PreparedStatement preparedStatement = connection.prepareStatement(increaseAge);
            preparedStatement.setInt(1, Integer.parseInt(item));
            preparedStatement.executeUpdate();
        }

        PreparedStatement statement = connection.prepareStatement(minionsNameAge);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static void exSeven() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(allMinionsNames);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> minions = new LinkedList<>();
        while (resultSet.next()) {
            minions.add(resultSet.getString("name"));
        }

        int startIndex = 0;
        int endIndex = minions.size() - 1;
        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i % 2 == 0 ? minions.get(startIndex++) : minions.get(endIndex--));
        }
    }

    private static void exSix() throws IOException, SQLException {
        System.out.println("Enter villain id to delete:");
        int id = Integer.parseInt(reader.readLine());
        PreparedStatement preparedStatement = connection.prepareStatement(getVillainByID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            PreparedStatement statement = connection.prepareStatement(deleteMinionsByVillainID);
            statement.setInt(1, id);
            int affected = statement.executeUpdate();

            PreparedStatement stm = connection.prepareStatement(deleteVillain);
            stm.setInt(1, id);
            stm.executeUpdate();

            System.out.println(resultSet.getString("name") + " was deleted");
            System.out.println(affected + " minions released");
        } else {
            System.out.println("No such villain was found");
        }
    }

    private static void exFive() throws IOException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(towns);
        System.out.println("Enter country name:");
        String country = reader.readLine();
        preparedStatement.setString(1, country);
        ResultSet resultSet = preparedStatement.executeQuery();

        PreparedStatement statement = connection.prepareStatement(townsToUpper);
        statement.setString(1, country);
        int result = statement.executeUpdate();
        if (result > 0) {
            System.out.println(result + " town names were affected.");

            Set<String> towns = new LinkedHashSet<>();
            while (resultSet.next()) {
                towns.add(resultSet.getString("name").toUpperCase(Locale.ROOT));
            }
            System.out.println("[" + String.join(", ", towns) + "]");
        } else {
            System.out.println("No town names were affected.");
        }
    }

    private static void exFour() throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(getTowns);
        System.out.println("Enter minion:");
        String minion = reader.readLine();
        String name = minion.split("\\s+")[1];
        int age = Integer.parseInt(minion.split("\\s+")[2]);
        String town = minion.split("\\s+")[3];

        System.out.println("Enter villain:");
        String villain = reader.readLine();
        String villainName = villain.split("\\s+")[1];

        preparedStatement.setString(1, town);
        ResultSet resultSet = preparedStatement.executeQuery();
        int townID = -1;
        if (!resultSet.next()) {
            PreparedStatement stm = connection.prepareStatement(insertTown);
            stm.setString(1, town);
            stm.execute();
            System.out.println("Town "+ town +" was added to the database.");
        }
        PreparedStatement prepstmt = connection.prepareStatement(getTownID);
        prepstmt.setString(1, town);
        ResultSet r = prepstmt.executeQuery();
        if (r.next()) {
            townID = r.getInt("id");
        }

        PreparedStatement statement = connection.prepareStatement(getVillains);
        statement.setString(1, villainName);
        ResultSet result = statement.executeQuery();
        int villainID = -1;
        if (!result.next()) {
            PreparedStatement pstm = connection.prepareStatement(insertVillain);
            pstm.setString(1, villainName);
            pstm.execute();
            System.out.println("Villain " + villainName + " was added to the database.");
        }
        PreparedStatement s = connection.prepareStatement(getVillainID);
        s.setString(1, villainName);
        ResultSet res = s.executeQuery();
        if (res.next()) {
            villainID = res.getInt("id");
        }

        int minionID = -1;
        PreparedStatement getMinion = connection.prepareStatement(getMinions);
        getMinion.setString(1, name);
        ResultSet set = getMinion.executeQuery();
        if (!set.next()) {
            if (townID >= 0) {
                PreparedStatement prepStat = connection.prepareStatement(insertMinion);
                prepStat.setString(1, name);
                prepStat.setInt(2, age);
                prepStat.setInt(3, townID);
                prepStat.execute();
            }
        }
        PreparedStatement st = connection.prepareStatement(getMinionID);
        st.setString(1, name);
        ResultSet re = st.executeQuery();
        if (re.next()) {
            minionID = re.getInt("id");
        }

        if (minionID >= 0 && villainID >= 0) {
            PreparedStatement ste = connection.prepareStatement(setMinionToVillain);
            ste.setInt(1, minionID);
            ste.setInt(2, villainID);
            ste.execute();
            System.out.println("Successfully added "+ name +" to be minion of "+ villainName +".");
        }
    }

    private static void exThree() throws IOException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(villainNameByID);
        System.out.println("Enter villain id:");
        int id = Integer.parseInt(reader.readLine());
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("Villain: %s%n", resultSet.getString("name"));
        }

        PreparedStatement statement = connection.prepareStatement(minionsNameAndAge);
        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();
        int count = 0;
        while (result.next()) {
            System.out.printf("%d. %s %d%n", ++count, result.getString("name"), result.getInt("age"));
        }
    }

    private static void exTwo() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(villainsNames);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("number"));
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        System.out.println("Enter username:");
        String user = reader.readLine();
        System.out.println("Enter password:");
        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        return DriverManager.getConnection(URL + DB_NAME, properties);
    }
}
