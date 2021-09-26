#include <stdlib.h>
#include <stdio.h>

#include <./libgcd.h>

int main(int argc, char **argv) {
  graal_isolate_t *isolate = NULL;
  graal_isolatethread_t *thread = NULL;
  
  if (graal_create_isolate(NULL, &isolate, &thread) != 0) {
    fprintf(stderr, "graal_create_isolate error\n");
    return 1;
  }
  
  long a = strtol(argv[1], NULL, 10);
  long b = strtol(argv[2], NULL, 10);
  
  printf("GCD of %ld and %ld is %lld\n", a, b, get_gcd(thread, a, b));

  if (graal_detach_thread(thread) != 0) {
    fprintf(stderr, "graal_detach_thread error\n");
    return 1;
  }
  
  return 0;
}
