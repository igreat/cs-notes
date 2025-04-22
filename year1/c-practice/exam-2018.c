#include <stdio.h>
#include <stdlib.h>

// -- FUNCTIONS -- //

int sum_of_negatives_arr(int numbers[], int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        if (numbers[i] < 0) {
            sum += numbers[i];
        }
    }
    return sum;
}

int sum_of_negatives_ptr(int *numbers, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        if (*(numbers + i) < 0) {
            sum += *(numbers + i);
        }
    }
    return sum;
}

int **copy_array(int **nums, int size) {
    int **copy = malloc(size * sizeof(int *));
    for (int i = 0; i < size; i++) {
        copy[i] = nums[i];
    }
    return copy;
}

typedef struct Node {
    int value;
    struct Node *next;
} Node;

void add_item(Node *head, int value) {
    Node *current = head;
    while (current->next) {
        current = current->next;
    }
    Node *new_item = (Node *)malloc(sizeof(Node));
    new_item->value = value;
    new_item->next = NULL;
    current->next = new_item;
}

void free_linked_list(Node *head) {
    if (head->next) {
        free_linked_list(head->next);
    }
    free(head);
}

int find(char *s1, char *s2) {
    int i = 0;
    int j = 0;
    while (s1[i]) {
        j = 0;
        while (s2[j] && s1[i + j] == s2[j]) {
            j++;
        }
        if (!s2[j]) {
            return i;
        }
        i++;
    }
    return -1;
}

// double parse_double(char *s) {
//     double result = 0;
//     int start = 0;
//     int neg_pos_multiplier = 1;
//     if (s[0] == '-') {
//         neg_pos_multiplier = -1;
//         start++;
//     }
//     int end = start;
//     while (s[end] != '.') {
//         end++;
//     }

//     int place = 1;
//     for (int i = end - 1; i >= start; i--) {
//         result += (s[i] - '0') * place;
//         place *= 10;
//     }

//     result += (s[end + 1] - '0') * 0.1;
//     result *= neg_pos_multiplier;
//     return result;
// }

double parse_double(char *str) {
    int start = 0;
    double multiplier = 1.0;
    if (str[start] == '-') {
        multiplier = -1.0;
        start++;
    }

    int i = start;
    while (str[i] != '.') i++;

    double result = 0.0;
    double power = 1.0;
    for (int j = i - 1; j >= start; j--) {
        result += (str[j] - '0') * power;
        power *= 10;
    }

    result += 0.1 * (str[i + 1] - '0');

    return result * multiplier;
}

// -- TESTS -- //

void test_arithmetic() {
    printf("10 / 2 + 25 / 5 * 0.5 = %f\n", 10 / 2 + 25 / 5 * 0.5);
}

void test_sum_of_negatives_arr() {
    int numbers1[] = {1, -2, 3, -4, 5, -6, 7, -8, 9, -10};
    int size1 = 10;  // should return -30
    printf("sum_of_negatives(numbers1, %d) = %d\n", size1,
           sum_of_negatives_arr(numbers1, size1));

    int numbers2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size2 = -10;  // should return 0 now
    printf("sum_of_negatives(numbers2, %d) = %d\n", size2,
           sum_of_negatives_arr(numbers2, size2));

    int numbers3[] = {1, -2, 3, 4, 5, 6, 7, 8, 9, -10};
    int size3 = 0;  // should return 0 now also
    printf("sum_of_negatives(numbers3, %d) = %d\n", size3,
           sum_of_negatives_arr(numbers3, size3));

    int numbers4[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size4 = 10;  // should return 0 now also
    printf("sum_of_negatives(numbers4, %d) = %d\n", size4,
           sum_of_negatives_arr(numbers4, size4));
}

void test_sum_of_negatives_ptr() {
    int numbers1[] = {1, -2, 3, -4, 5, -6, 7, -8, 9, -10};
    int size1 = 10;  // should return -30
    printf("sum_of_negatives(numbers1, %d) = %d\n", size1,
           sum_of_negatives_ptr(numbers1, size1));

    int numbers2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size2 = -10;  // should return 0 now
    printf("sum_of_negatives(numbers2, %d) = %d\n", size2,
           sum_of_negatives_ptr(numbers2, size2));

    int numbers3[] = {1, -2, 3, 4, 5, 6, 7, 8, 9, -10};
    int size3 = 0;  // should return 0 now also
    printf("sum_of_negatives(numbers3, %d) = %d\n", size3,
           sum_of_negatives_ptr(numbers3, size3));

    int numbers4[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size4 = 10;  // should return 0 now also
    printf("sum_of_negatives(numbers4, %d) = %d\n", size4,
           sum_of_negatives_ptr(numbers4, size4));
}

void test_copy_array() {
    // 2d array
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {6, 7, 8, 9, 10};
    int *numbers[] = {arr1, arr2};  // array of pointers to arrays
    int size = 2;
    int **copy = copy_array(numbers, size);

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < 5; j++) {
            printf("copy[%d][%d] = %d\n", i, j, copy[i][j]);
        }
    }

    free(copy);
}

void test_linked_list() {
    Node *head = (Node *)malloc(sizeof(Node));
    head->value = 0;
    head->next = NULL;

    add_item(head, 1);
    add_item(head, 2);
    add_item(head, 3);
    add_item(head, 4);
    add_item(head, 5);

    Node *current = head;
    while (current) {
        printf("current->value = %d\n", current->value);
        current = current->next;
    }

    free_linked_list(head);
}

void test_find() {
    char *s1 = "hello world";
    char *s2 = "world";
    int result = find(s1, s2);
    if (result != -1) {
        printf("'%s' found in '%s' at index %d\n", s2, s1, result);
    } else {
        printf("'%s' not found in '%s'\n", s2, s1);
    }

    char *s3 = "This is a sentence";
    char *s4 = "is";
    result = find(s3, s4);
    if (result != -1) {
        printf("'%s' found in '%s' at index %d\n", s4, s3, result);
    } else {
        printf("'%s' not found in '%s'\n", s4, s3);
    }

    char *s5 = "This is a sentence";
    char *s6 = "your mom";
    result = find(s5, s6);
    if (result != -1) {
        printf("'%s' found in '%s' at index %d\n", s6, s5, result);
    } else {
        printf("'%s' not found in '%s'\n", s6, s5);
    }
}

void test_parse_double() {
    char *s1 = "123.1";
    char *s2 = "-123.1";
    char *s3 = "0.1";
    char *s4 = "-0.1";
    char *s5 = "0.0";

    printf("parse_double(%s) = %f\n", s1, parse_double(s1));
    printf("parse_double(%s) = %f\n", s2, parse_double(s2));
    printf("parse_double(%s) = %f\n", s3, parse_double(s3));
    printf("parse_double(%s) = %f\n", s4, parse_double(s4));
    printf("parse_double(%s) = %f\n", s5, parse_double(s5));
}

int main(int argc, char const *argv[]) {
    test_arithmetic();
    puts("");
    // test_sum_of_negatives_arr();
    // puts("");
    // test_sum_of_negatives_ptr();
    // puts("");
    // test_copy_array();
    // puts("");
    // test_linked_list();
    // puts("");
    // test_find();
    // puts("");
    // test_parse_double();
    // puts("");
    // return 0;
}
