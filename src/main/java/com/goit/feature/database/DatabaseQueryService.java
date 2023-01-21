package com.goit.feature.database;

import com.goit.feature.prefs.Prefs;
import com.goit.feature.utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> projectList = new ArrayList<>();
        String selectLongestProjectFileName = new Prefs().getString(Prefs.SELECT_LONGEST_PROJECT_FILE_PATH);
        String selectSql = Files.readString(Paths.get(selectLongestProjectFileName));

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(selectSql);

        while(rs.next()) {
            LongestProject project = new LongestProject();
            int name = rs.getInt("name");
            int monthCount = rs.getInt("month_count");

            project.setName(name);
            project.setMonthCount(monthCount);

            projectList.add(project);
        }
        return projectList;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectsClient> clientsList = new ArrayList<>();
        String selectMaxProjectsClientFileName = new Prefs().getString(Prefs.SELECT_MAX_PROJECTS_CLIENT_FILE_PATH);
        String selectSql = Files.readString(Paths.get(selectMaxProjectsClientFileName));

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(selectSql);

        while(rs.next()) {
            MaxProjectsClient client = new MaxProjectsClient();
            String name = rs.getString("name");
            int projectCount = rs.getInt("project_count");

            client.setName(name);
            client.setProjectCount(projectCount);

            clientsList.add(client);
        }
        return clientsList;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> workerList = new ArrayList<>();
        String selectMaxSalaryWorkerFileName = new Prefs().getString(Prefs.SELECT_MAX_SALARY_WORKER_FILE_PATH);
        String selectSql = Files.readString(Paths.get(selectMaxSalaryWorkerFileName));

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(selectSql);

        while(rs.next()) {
            MaxSalaryWorker worker = new MaxSalaryWorker();
            String name = rs.getString("name");
            int salary = rs.getInt("salary");

            worker.setName(name);
            worker.setSalary(salary);

            workerList.add(worker);
        }
        return workerList;
    }

    public List<ProjectPrices> printProjectPrices() throws IOException, SQLException {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        String projectPricesFileName = new Prefs().getString(Prefs.SELECT_PROJECT_PRICES_FILE_PATH);
        String selectSql = Files.readString(Paths.get(projectPricesFileName));

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(selectSql);

        while(rs.next()) {
            ProjectPrices projectPrice = new ProjectPrices();
            String name = rs.getString("name");
            int price = rs.getInt("price");

            projectPrice.setName(name);
            projectPrice.setPrice(price);

            projectPricesList.add(projectPrice);
        }
        return projectPricesList;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() throws IOException, SQLException {
        List<YoungestEldestWorker> youngestEldestWorkerList = new ArrayList<>();
        String youngestEldestWorkerFileName = new Prefs().getString(Prefs.SELECT_YOUNGEST_ELDEST_WORKERS_FILE_PATH);
        String selectSql = Files.readString(Paths.get(youngestEldestWorkerFileName));

        Database database = Database.getInstance();

        Statement st = database.getConnection().createStatement();
        ResultSet rs = st.executeQuery(selectSql);

        while(rs.next()) {
            YoungestEldestWorker worker = new YoungestEldestWorker();
            String type = rs.getString("type");
            String name = rs.getString("name");
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));

            worker.setType(type);
            worker.setName(name);
            worker.setBirthday(birthday);

            youngestEldestWorkerList.add(worker);
        }
        return youngestEldestWorkerList;
    }
}
