#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node {
    char *string;
    int number;
    struct Node *next;
} Node;

void add_item(Node *head, char *string, int number) {
    Node *node = (Node *)malloc(sizeof(Node));
    node->string = strdup(string);
    node->number = number;
    node->next = NULL;

    Node *current = head;
    while (current->next) current = current->next;
    current->next = node;
}

void filledTriangle(int height) {
    for (int i = 1; i <= height; i++) {
        for (int j = 0; j < i; j++) {
            printf("*");
        }
        printf("\n");
    }
}

// {5, 'h', 'e', 'I', 'I', 'o'} type shit
int str_length(char *str) { return (int)*str; }

char *str_copy(char *str) {
    int length = str_length(str);
    char *copy = (char *)malloc(sizeof(char) * (length + 1));
    for (int i = 0; i <= length; i++) {
        copy[i] = str[i];
    }
    return copy;
}

int count_helper(char *str, int size, char c, int count) {
    if (size <= 0) return count;
    return count_helper(str + 1, size - 1, c, count + ((*str == c) ? 1 : 0));
}

int count(char *str, char c) {
    return count_helper(str + 1, str[0], c, 0);  //
}

void test_arithmetic() {
    double result = 9 / 3 / 2 * 6 + 2 * 1.5;
    printf("%lf\n", result);
}

void test_linked_list() {
    Node *head = (Node *)malloc(sizeof(Node));
    head->next = NULL;

    add_item(head, "hello", 1);
    add_item(head, "world", 2);
    add_item(head, "foo", 3);
    add_item(head, "bar", 4);

    Node *current = head->next;
    while (current) {
        printf("%s: %d\n", current->string, current->number);
        current = current->next;
    }
}

void test_str_copy() {
    char original[] = {
        5,   'h', 'e', 'l',
        'l', 'o'};  // Corrected initialization and corrected the characters
    char *copy = str_copy(original);

    if (copy != NULL) {
        // Verify copy has been successful
        printf("Original: ");
        for (int i = 1; i <= original[0]; i++) {
            printf("%c", original[i]);
        }
        printf("\nCopy: ");
        for (int i = 1; i <= copy[0]; i++) {
            printf("%c", copy[i]);
        }
        printf("\n");

        // Free the memory when done with it
        free(copy);
    } else {
        printf("Failed to allocate memory for copy.\n");
    }
}

void test_count() {
    char str[] = {5, 'h', 'e', 'l', 'l', 'o'};
    printf("Count of 'l' in 'hello': %d\n", count(str, 'l'));
}

int main(int argc, char const *argv[]) {
    // test_arithmetic();
    test_linked_list();
    // filledTriangle(5);
    // test_str_copy();
    // test_count();
    return 0;
}
