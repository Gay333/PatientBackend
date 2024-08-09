import pandas as pd
import sys

# Load the dataset with error handling
try:
    df = pd.read_csv('C:/Users/Gayathri.Venkatesan/Downloads/drugsComTrain_raw.csv').head(5000)
    df['drugName'] = df['drugName'].astype(str)
    df['review'] = df['review'].astype(str)
    df['date'] = df['date'].astype(str)
except FileNotFoundError:
    print("CSV file not found. Please check the file path.")
    sys.exit(1)

def find_answer(user_input):
    for index, row in df.iterrows():
        drug_name = str(row['drugName'])
        condition = str(row['condition'])
        if user_input.lower() in drug_name.lower() or user_input.lower() in condition.lower():
            return f"Drug: {row['drugName']}\nCondition: {row['condition']}\nReview: {row['review']}\nRating: {row['rating']}\nDate: {row['date']}\nUseful Count: {row['usefulCount']}"
    return "Sorry, I don't have information on that drug or condition."

if __name__ == "__main__":
    user_input = sys.argv[1]
    #print(f"Received user input: {user_input}")
    response = find_answer(user_input)
    print(response)
