import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class FoodChannelScraper {
    public static void main(String[] args) {
        try {
            // Create a UserAgent object to connect to the website
            UserAgent userAgent = new UserAgent();
            userAgent.visit("https://www.foodchannel.com/recipes/");

            // Extract recipe elements from the website
            Elements recipeElements = userAgent.doc.findEvery("<div class='card-inner'>");

            // Loop through each recipe element and extract relevant information
            for (Element recipeElement : recipeElements) {
                String title = recipeElement.findFirst("<h2>").getText().trim();
                String imageUrl = recipeElement.findFirst("<img>").getAttx("src");
                String description = recipeElement.findFirst("<p class='card-text'>").getText().trim();

                // Print out the extracted information
                System.out.println("Title: " + title);
                System.out.println("Image URL: " + imageUrl);
                System.out.println("Description: " + description);
                System.out.println();
            }
        } catch (JauntException e) {
            e.printStackTrace();
        }
    }
}
