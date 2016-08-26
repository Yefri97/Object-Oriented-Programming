#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main() {
	Stack s; init_stack(&s, 10);
	printf("%d\n", is_empty_stack(&s));
	push_stack(&s, 3.4);
	printf("%d\n", is_empty_stack(&s));
	push_stack(&s, 6.4);
	printf("%f\n", top_stack(&s));
	pop_stack(&s);
	printf("%f\n", top_stack(&s));
	printf("%d\n", s.size);
	resize_stack(&s, 20);
	printf("%d\n", s.size);
	return 0;
}