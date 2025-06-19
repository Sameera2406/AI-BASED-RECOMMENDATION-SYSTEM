import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ProductRecommender {

    public static void main(String[] args) throws Exception {
        // Load data model
        File dataFile = new File("src/data/preferences.csv");
        DataModel model = new FileDataModel(dataFile);

        // Item similarity
        ItemSimilarity similarity = new LogLikelihoodSimilarity(model);

        // Recommender
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);

        Scanner scanner = new Scanner(System.in);

        // Open output file
        try (PrintWriter writer = new PrintWriter(new FileWriter("recommendations_output.txt", true))) {
            while (true) {
                System.out.print("\nEnter User ID : ");
                long userId = scanner.nextLong();

                if (userId == 0) {
                    System.out.println("Exiting...");
                    break;
                }

                try {
                    // Recommend 5 items per user
                    List<RecommendedItem> recommendations = recommender.recommend(userId, 5);

                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations found for User " + userId);
                        writer.println("No recommendations found for User " + userId);
                    } else {
                        System.out.println("Recommendations for User " + userId + ":");
                        writer.println("Recommendations for User " + userId + ":");
                        for (RecommendedItem recommendation : recommendations) {
                            String output = "  Item: " + recommendation.getItemID() +
                                            ", Estimated Preference: " + String.format("%.2f", recommendation.getValue());
                            System.out.println(output);
                            writer.println(output);
                        }
                    }
                    writer.println(); // blank line after each user
                } catch (Exception e) {
                    String errorMsg = "Error for user " + userId + ": " + e.getMessage();
                    System.out.println(errorMsg);
                    writer.println(errorMsg);
                }
            }
        }

        scanner.close();
    }
}
