#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int number_of_digits(int n) {
    int result = 1;
    while (n > 9 || n < -9) {
        n /= 10;
        result++;
    }
    return result;
}

char *number_to_string(int n) {
    int length = number_of_digits(n);
    int isNegative = 0;
    if (n < 0) {
        length++;
        isNegative = 1;
        n = -n;
    };

    char *string = (char *)malloc(sizeof(char) * (length + 1));
    *(string + length) = '\0';
    if (isNegative) *string = '-';

    char *endPtr = string + length - 1;
    do {
        *endPtr = '0' + (n % 10);
        n /= 10;
        endPtr--;
    } while (n != 0);

    return string;
}

typedef struct File {
    char *name;
    int size;
    char *date;
} File;

File *init_file(char *name, int size, char *date) {
    File *file = (File *)malloc(sizeof(File));

    file->name = strdup(name);
    file->size = size;
    file->date = strdup(date);

    return file;
}

typedef struct Directory {
    char *name;
    int num_files;
    File **files;
} Directory;

Directory *init_directory(char *name) {
    Directory *directory = (Directory *)malloc(sizeof(Directory));
    directory->name = strdup(name);
    directory->num_files = 0;
    directory->files = NULL;
    return directory;
}

void add_file(Directory *directory, File *file) {
    directory->num_files++;
    directory->files =
        realloc(directory->files, sizeof(File *) * directory->num_files);
    directory->files[directory->num_files - 1] = file;
}

void free_file(File *file) {
    free(file->name);
    free(file->date);
    free(file);
}

void free_directory(Directory *directory) {
    for (int i = 0; i < directory->num_files; i++) {
        free_file(directory->files[i]);
    }
    free(directory->files);
    free(directory->name);
    free(directory);
}

void test_directory() {
    Directory *directory = init_directory("root");
    add_file(directory, init_file("file1", 100, "2022-01-01"));
    add_file(directory, init_file("file2", 200, "2022-01-02"));
    add_file(directory, init_file("file3", 300, "2022-01-03"));

    for (int i = 0; i < directory->num_files; i++) {
        File *file = directory->files[i];
        printf("%s %d %s\n", file->name, file->size, file->date);
    }

    free_directory(directory);
}

void test_number_to_string() {
    printf("%s\n", number_to_string(123));
    printf("%s\n", number_to_string(-12));
    printf("%s\n", number_to_string(100));
    printf("%s\n", number_to_string(0));
}

void test_number_of_digits() {
    printf("%d\n", number_of_digits(123));
    printf("%d\n", number_of_digits(-12));
    printf("%d\n", number_of_digits(0));
}

void test_arithmetic() {
    double result = 2 * 3 * 4 + 5 / 0.2;
    printf("%lf\n", result);
}

int main(int argc, char const *argv[]) {
    // test_arithmetic();
    // test_number_of_digits();
    // test_number_to_string();
    test_directory();
    return 0;
}
