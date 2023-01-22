import com.goit.feature.database.DatabaseQueryService;
import com.goit.feature.utils.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        List<MaxProjectsClient> maxProjectsClientsList = databaseQueryService.findMaxProjectsClient();
        System.out.println("maxProjectsClients = " + maxProjectsClientsList);

        List<LongestProject> longestProjectList = databaseQueryService.findLongestProject();
        System.out.println("longestProject = " + longestProjectList);

        List<MaxSalaryWorker> maxSalaryWorkerList = databaseQueryService.findMaxSalaryWorker();
        System.out.println("maxSalaryWorker = " + maxSalaryWorkerList);

        List<ProjectPrices> projectPricesList = databaseQueryService.getProjectPrices();
        System.out.println("projectPrices = " + projectPricesList);

        List<YoungestEldestWorker> youngestEldestWorkerList = databaseQueryService.findYoungestEldestWorker();
        System.out.println("youngestEldestWorker = " + youngestEldestWorkerList);
    }
}
