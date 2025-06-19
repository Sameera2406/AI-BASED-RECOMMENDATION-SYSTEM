# AI-BASED-RECOMMENDATION-SYSTEM

COMPANY : CODTECH IT SOLUTIONS

NAME : MULASAMEERA

INTERNID : CT04DN836

DOMAIN : JAVA PROGRAMMING

DURATION : 4 WEEKS

MENTOR : NEELA SANTOSH

##DESCRIPTION

## Description of the ProductRecommender Java Program:

The ProductRecommender Java program is a console-based recommendation system built using the Apache Mahout library. It is designed to analyze user-item preference data and suggest items to users based on item-based collaborative filtering. This program is a great example of how to integrate data science techniques such as recommender systems with Java development, particularly leveraging the power of open-source libraries like Mahout.

This implementation demonstrates item-based recommendation using log-likelihood similarity, a statistical method that identifies similarities between items by analyzing the likelihood that two items are co-preferred by the same users more often than would be expected by chance. The goal of the system is to predict and recommend the most relevant products (items) to each user, based on historical interaction data (ratings or preferences).

## Program Components and Workflow:

The application is composed of several core components and steps:

1. Data Loading (FileDataModel)
The program starts by loading a CSV file named preferences.csv located in the src/data/ directory. This file is structured such that each line represents a user’s preference for a particular item in the format:

userID,itemID,preferenceValue

Apache Mahout’s FileDataModel is used to parse and manage this data efficiently. The model forms the backbone of all recommendation logic by encapsulating the relationships between users and items.

2. Similarity Measurement
The program uses LogLikelihoodSimilarity, an implementation of Mahout’s ItemSimilarity interface. This similarity algorithm compares how likely it is that two items co-occur in users’ preferences more often than they would by chance, making it particularly useful for datasets with implicit feedback (e.g., clicks, views, purchases rather than explicit ratings).

3. Recommender Initialization
An instance of GenericItemBasedRecommender is initialized with the data model and similarity measure. This class performs the actual recommendation logic by finding similar items and estimating the user’s preference for items they haven’t yet interacted with.

4. Interactive User Input
The application enters a loop where it continuously prompts the user to enter a user ID. If a valid user ID is entered, the system generates and displays the top 5 recommended items for that user. If the user enters 0, the program exits gracefully.

This user-driven loop makes the system interactive and suitable for experimentation or testing with different user IDs.

5. Output to Console and File
All recommendations are displayed in the terminal and simultaneously written to a file named recommendations_output.txt. This feature is useful for logging or reviewing recommendations later. If no recommendations are found, an appropriate message is shown and logged.

## Educational and Practical Value
This program is valuable for both academic learning and practical implementation:

Academic Use: It demonstrates key machine learning concepts like collaborative filtering, similarity computation, and recommendation logic using real tools.

Practical Use: It serves as a foundational module for integrating recommendation engines into larger e-commerce or content delivery systems.

Additionally, the use of Apache Mahout shows how complex machine learning models can be applied using Java without having to write algorithmic code from scratch.

## Data Format and Example
The input file preferences.csv should follow this structure:

1,101,5.0

1,102,3.0

1,103,2.5

1,106,4.0

2,101,2.0

2,102,2.5

2,103,5.0

2,107,3.5

3,101,2.5

3,104,4.0

3,105,4.5

4,102,4.5

4,103,4.0

4,104,1.0

4,108,4.5

5,101,3.0

5,103,3.5

5,105,4.0

5,106,2.5

6,102,4.0

6,104,4.5

6,107,3.0

7,103,5.0

7,105,3.0

7,108,4.0

8,101,4.0

8,102,3.5

8,106,5.0

9,104,4.0

9,107,4.5

9,108,3.5

10,101,3.5

10,103,4.0

10,105,3.0

Where:

1 = user ID

101 = item ID

5.0 = preference value (rating or interaction strength)

## Use Cases
This project can be extended or adapted for:

1.Recommending products in an e-commerce website.

2.Suggesting content like movies, music, or books.

3.Educational demonstrations of collaborative filtering.

4.Creating offline testing frameworks for recommendation strategies.

## How to Run:

1.Compile the code using:

javac -cp .;lib/* ProductRecommender.java

2.Run the program:

java -cp .;lib/* ProductRecommender

## OUTPUT:

![Image](https://github.com/user-attachments/assets/9d4507ca-71e1-42e4-b59d-2f49e7e44d35)

![Image](https://github.com/user-attachments/assets/31f61fa4-c07d-483d-bb0c-168cdc8b7316)

