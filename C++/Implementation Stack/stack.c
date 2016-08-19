#include <stdlib.h>
#include "stack.h"

int init_stack(Stack *S, int n) {
	S->bottom = (float *) malloc(n);
	S->top = S->bottom;
	S->size = n;
}

int resize_stack(Stack *S, int n) {
	S->bottom = (float *) realloc(S->bottom, n);
	S->size = n;
}

int pop_stack(Stack *S) {
	S->top--;
}

int push_stack(Stack *S, float x) {
	*S->top = x;
	S->top++;
}

float top_stack(Stack *S) {
	return *(S->top - 1);
}

bool is_empty_stack(Stack *S) {
	return (S->top == S->bottom);
}
