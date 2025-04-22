#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// -- FUNCTIONS -- //
void swap(int a[], int m, int n) {
    int temp = a[m];
    a[m] = a[n];
    a[n] = temp;
}

void swap_pairs(int a[], int length) {
    for (int i = 0; i < length - 1; i++) {
        if (a[i] > a[i + 1]) {
            swap(a, i, i + 1);
        }
    }
}

void bubble_sort(int a[], int length) {
    for (int i = length; i >= 2; i--) {
        swap_pairs(a, i);
    }
}

void print_array(int a[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
}

// char *copy_string(char *s) {
//     int l = 0;
//     while (*(s + l)) l++;
//     char *copy = (char *)malloc((l + 1) * sizeof(char));
//     for (int i = 0; i <= l; i++) {
//         *(copy + i) = *(s + i);
//     }
//     return copy;
// }
char *copy_string(char *str) {
    int length = 0;
    while (*(str + length) != '\0') {
        length++;
    }

    char *copy = (char *)malloc((length + 1) * sizeof(char));

    for (int i = 0; i <= length; i++) {
        *(copy + i) = *(str + i);
    }
    return copy;
}

void print_as_binary(int n) {
    if (n == 0) return;

    int bit = n % 2;
    print_as_binary(n / 2);
    printf("%d", bit);
}

int strings_equal(char *str1, char *str2) {
    while (*str1 && *str2 && (*str1 == *str2)) {
        str1++;
        str2++;
    }
    return *str1 == *str2;
}

// -- TESTS -- //
void test_arithmetic() {
    printf("1 * 2 * 3 / 4 * 5 - 6 = %d\n", 1 * 2 * 3 / 4 * 5 - 6);
}

void test_swap() {
    int a[] = {3, 5, 7, 9, 11};
    swap(a, 2, 3);
    print_array(a, 5);
}

void test_swap_pairs() {
    int a[] = {5, 7, 3, 4, 9, 3};
    swap_pairs(a, 6);
    print_array(a, 6);
}

void test_bubble_sort() {
    int a[] = {5, 7, 3, 4, 9, 3};
    bubble_sort(a, 6);
    print_array(a, 6);
}

void test_copy_string() {
    char *s = "Hello, World!";
    char *copy = copy_string(s);
    printf("Original: %s\n", s);
    printf("Copy: %s\n", copy);
    free(copy);
}

void test_print_as_binary() {
    print_as_binary(5);
    printf("\n");
    print_as_binary(11);
    printf("\n");
}

void test_strings_equal() {
    char *s1 = "Hello, World!";
    char *s2 = "Hello, World!";
    char *s3 = "Hello, World";
    printf("s1 == s2: %d\n", strings_equal(s1, s2));
    printf("s1 == s3: %d\n", strings_equal(s1, s3));
}

int main(int argc, char const *argv[]) {
    // test_arithmetic();
    // test_swap();
    // test_swap_pairs();
    test_bubble_sort();
    // test_copy_string();
    // test_print_as_binary();
    // test_strings_equal();
    return 0;
}
