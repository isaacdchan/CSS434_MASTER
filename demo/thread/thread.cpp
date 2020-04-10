#include <iostream>
#include <string>
using namespace std;

#include <pthread.h>
#include <unistd.h>

void* thread_func( void *param ) {

  for ( int i = 0; i < 5; i++ ) {
    sleep( 2 );
    cout << "I'm a slave: " << *( (string *)param ) << endl;
  }
  return NULL;
}

int main( int argc, char *argv[] )
{
  pthread_t child;
  string arg;

  cout << "enter message: ";
  cin >> arg;
  pthread_create( &child, NULL, thread_func, (void *)&arg );
  for ( int i = 0; i < 3; i++ ) {
    sleep( 1 );
    cout << "I'm a master: " << arg << endl;
  }
  //pthread_join( child, NULL );
  cout << "Master synched with slave" << endl;

  return 0;
}

