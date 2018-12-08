# -*- coding: utf-8 -*-

import os

BASE_DIR = 'C:\\work\\AbInitioExercise\\data-work\\'

def fix_filename_transction_to_transaction(file_before_fix) :

    wrong_file_name_with = 'transction'
    correct_file_name_with = 'transaction'

    file_after_fix = file_before_fix

    if file_before_fix.startswith(wrong_file_name_with) :
        file_after_fix = file_before_fix.replace(wrong_file_name_with, correct_file_name_with)

    return file_after_fix


def fix_file_names() :
    for dir, subdirs, lists in os.walk(BASE_DIR) :
        for file in lists :
            old_file_name = file
            new_file_name = fix_filename_transction_to_transaction(file)
            oldfile = os.path.join(dir, old_file_name)
            newfile = os.path.join(dir, new_file_name)
            print("Rename file name from " + old_file_name + " to " + new_file_name)
            os.rename(oldfile, newfile)


if __name__ == '__main__':
    fix_file_names()

