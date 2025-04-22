#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void test_arithmetic() {
    double result = 1.1 * 2 + 4 / 3 - 0.2;
    printf("%lf\n", result);
}

int count_value_sqr(int value, int numbers[], int size) {
    int total = 0;
    for (int i = 0; i < size; i++) {
        if (numbers[i] == value) total++;
    }
    return total;
}

int count_value_ptr(int value, int *numbers, int size) {
    int total = 0;
    for (int i = 0; i < size; i++) {
        if (*(numbers + i) == value) total++;
    }
    return total;
}

typedef struct Node {
    int integer;
    double rational;
    char *char_ptr;
    struct Node *next;
} Node;

Node *init_node(int integer, double rational, char *char_ptr) {
    Node *node = (Node *)malloc(sizeof(Node));
    node->integer = integer;
    node->rational = rational;
    // node->char_ptr = (char *)malloc(sizeof(char) * (strlen(char_ptr) + 1));
    // strcpy(node->char_ptr, char_ptr);
    // use strdup instead of malloc + strcpy
    node->char_ptr = strdup(char_ptr);

    node->next = NULL;

    return node;
}

void free_node(Node *node) {
    free(node->char_ptr);
    free(node);
}

void free_list(Node *head) {
    Node *current = head;
    while (current) {
        Node *next = current->next;
        free_node(current);
        current = next;
    }
}

Node **list_to_array(Node *head) {
    int length = 0;
    Node *current = head;
    while (current) {
        length++;
        current = current->next;
    }

    Node **node_array = (Node **)malloc(sizeof(Node *) * (length + 1));

    current = head;
    Node **current_arr = node_array;
    while (current) {
        *current_arr = current;
        current = current->next;
        current_arr++;
    }
    // extra NULL node to denote end of list
    *current_arr = NULL;

    return node_array;
}

void test_count_value_sqr() {
    int numbers[9] = {1, 5, 3, 4, 5, 5, 7, 8, 9};
    int size = 9;
    int value = 5;
    int result = count_value_sqr(value, numbers, size);
    printf("%d\n", result);
}

void test_count_value_ptr() {
    int numbers[9] = {1, 5, 3, 4, 5, 5, 7, 8, 9};
    int size = 9;
    int value = 5;
    int result = count_value_ptr(value, numbers, size);
    printf("%d\n", result);
}

void test_list_to_array() {
    Node *head = init_node(1, 1.1, "hello");
    Node *node1 = init_node(2, 2.2, "world");
    Node *node2 = init_node(3, 3.3, "foo");
    Node *node3 = init_node(4, 4.4, "bar");

    head->next = node1;
    node1->next = node2;
    node2->next = node3;

    Node **node_array = list_to_array(head);

    Node **current = node_array;
    while (*current) {
        printf("%d %lf %s\n", (*current)->integer, (*current)->rational,
               (*current)->char_ptr);
        current++;
    }

    free_list(head);
    free(node_array);
}

int main(int argc, char const *argv[]) {
    // test_arithmetic();
    // test_count_value_sqr();
    // test_count_value_ptr();
    test_list_to_array();
    return 0;
}
