#ifndef _STACK_H_
#define _STACK_H_

#include <stdio.h>

typedef struct
{
	float *bottom;
	float *top;
	int size;
} Stack;

int init_stack(Stack *, int);
int resize_stack(Stack *, int);
int pop_stack(Stack *);
int push_stack(Stack *, float);
float top_stack(Stack *);
bool is_empty_stack(Stack *);

#endif