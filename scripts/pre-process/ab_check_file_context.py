# -*- coding: Shift-JIS -*-

import os
import pandas as pd
import codecs

BASE_DIR = 'C:\\work\\AbInitioExercise\\data\\'

# Check if 'customer.csv' consists of lines having 8 elements as expected.
def check_customer_csv_file(cust_file) :
    with codecs.open(cust_file, "r", "Shift-JIS", "ignore") as dec_cust_file :
        #cust_df = pd.DataFrame(pd.read_csv(dec_cust_file))
        #print(cust_df.shape)
        for line in dec_cust_file :
            len_of_line = len(line.split(","))
            if len_of_line != 8 :
                print(line + " contains " + str(len_of_line))
    print("Enf of check_customer_csv_file")


if __name__ == '__main__' :

    customer_file_name = 'customer.csv'
    customer_csv_file = os.path.join(BASE_DIR, customer_file_name)
    check_customer_csv_file(customer_csv_file)
