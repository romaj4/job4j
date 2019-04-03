package ru.job4j.sqlite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL implements AutoCloseable {

    private final Config config;

    private Connection connect;

    private final int size;

    public StoreSQL(int size) {
        this.config = new Config();
        this.size = size;
        config.init();
        try {
            Class.forName("org.sqlite.JDBC");
            this.connect = DriverManager.getConnection(config.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.generate();
    }

    /**
     * Заполняет таблицу значениями.
     */
    public void generate() {
        this.createTable();
        try (PreparedStatement prst = this.connect.prepareStatement("insert into entry values (?);")) {
            this.connect.setAutoCommit(false);
            for (int i = 1; i <= this.size; i++) {
                prst.setInt(1, i);
                prst.addBatch();
            }
            prst.executeBatch();
            this.connect.commit();
        } catch (SQLException e) {
            try {
                this.connect.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * Создает таблицу, если ее нет.
     * Очищает данные.
     */
    public void createTable() {
        try (Statement stmt = this.connect.createStatement()) {
            stmt.executeUpdate("CREATE TABLE  IF NOT EXISTS entry(field INTEGER);");
            stmt.executeUpdate("delete from entry;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сохраняет данные из БД в list.
     *
     * @return list.
     */
    public List<Entry> load() {
        List<Entry> resultList = new ArrayList<>();
        try (Statement st = this.connect.createStatement()) {
            ResultSet resultSet = st.executeQuery("select * from entry");
            while (resultSet.next()) {
                resultList.add(new Entry(resultSet.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}