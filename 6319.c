#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void usage() {
  printf("USAGE: 6319 ** file name **\n");
}

int main(int argc, char *argv[]) {
  if (argc < 2) {
    printf("You did not pass enough args\n");
    usage();
    return 1;
  } else if (argc > 2) {
    printf("You passed too many args\n");
    usage();
    return 1;
  }

  char cmd[1024] = "java -cp ../bin src.app.Main";
  for (int i = 1; i < argc; i++) {
    strcat(cmd, " ");
    strcat(cmd, argv[i]);
  }

  printf("Running command: %s\n", cmd);

  int ret = system(cmd);
  printf("Command exited with code %d\n", ret);

  return 0;
}
