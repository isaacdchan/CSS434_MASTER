/*
 * example.x - Speicification of some arithmetic/string service.
 * Define 2 procedures:
 *      fact( int n ) returns n!.
 *      power( double x, double y ) returns x^^y.
 *      strconc( struct strings ) concatenates src to dest.
 */

const BUFFER_SIZE = 1024;

struct doubles {
	double a;
	double b;
};

struct strings {
	char src[BUFFER_SIZE];
	char dst[BUFFER_SIZE];
};

program EXAMPLE_PROG {
    version EXAMPLE_VERS {
        int    FACT( int )        = 1;    /* procedure number = 1 */
        double POWER( doubles )    = 2;    /* procedure number = 2 */
	string STRCONC( strings ) = 3;    /* procedure number = 3 */
    } = 1;                                /* version number = 1 */
} = 0x31234567;                           /* program number = 0x31234567 */

