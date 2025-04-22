#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int count_character(char *str, char c) {
    int count = 0;
    while (*str) {
        if (*str == c) count++;
        str++;
    }
    return count;
}

int *count_vowels(char *str) {
    int *vowel_counts = (int *)malloc(sizeof(int) * 5);
    char vowels[] = "aeiou";
    for (int i = 0; i < 5; i++) {
        *(vowel_counts + i) = count_character(str, vowels[i]);
    }
    return vowel_counts;
}

typedef struct Node {
    char *value;
    struct Node *next;
} Node;

Node *init_node(char *str) {
    Node *node = (Node *)malloc(sizeof(Node));
    char *str_copy = (char *)malloc(sizeof(char) * (strlen(str) + 1));
    for (int i = 0; i <= strlen(str); i++) {
        str_copy[i] = str[i];
    }

    node->value = str_copy;
    node->next = NULL;

    return node;
}

Node *array_to_linked_list(char **str, int length) {
    if (length <= 0) return NULL;
    Node *head = init_node(str[0]);

    Node *current = head;
    for (int i = 1; i < length; i++) {
        current->next = init_node(str[i]);
        current = current->next;
    }

    return head;
}

void free_linked_list(Node *head) {
    Node *current = head;
    Node *next;
    while (current->next) {
        next = current->next;
        free(current->value);
        free(current);
    }
}

void print_linked_list(Node *head) {
    Node *current = head;
    while (current) {
        printf("%s\n", current->value);
        current = current->next;
    }
}

void test_linked_list() {
    char *strs[] = {"hello", "world", "foo", "bar"};
    Node *head = array_to_linked_list(strs, 4);
    print_linked_list(head);
    free_linked_list(head);
}

void test_count_vowels() {
    char *str = "This is some text";
    int *vowel_counts = count_vowels(str);
    for (int i = 0; i < 5; i++) {
        printf("%c: %d\n", "aeiou"[i], *(vowel_counts + i));
    }
    free(vowel_counts);
}

void test_arithmetic() {
    double result = 26 / 5 / 5.0 - 5 * 0.2 * 10;
    printf("%lf\n", result);
}

int main(int argc, char const *argv[]) {
    // test_arithmetic();
    // test_count_vowels();
    test_linked_list();
    return 0;
}
