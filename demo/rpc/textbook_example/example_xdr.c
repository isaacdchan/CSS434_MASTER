/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "example.h"

bool_t
xdr_FileIdentifier (XDR *xdrs, FileIdentifier *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, objp))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_FilePointer (XDR *xdrs, FilePointer *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, objp))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_Length (XDR *xdrs, Length *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, objp))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_Data (XDR *xdrs, Data *objp)
{
	register int32_t *buf;

	int i;
	 if (!xdr_int (xdrs, &objp->length))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->buffer, MAX,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_writeargs (XDR *xdrs, writeargs *objp)
{
	register int32_t *buf;

	 if (!xdr_FileIdentifier (xdrs, &objp->f))
		 return FALSE;
	 if (!xdr_FilePointer (xdrs, &objp->position))
		 return FALSE;
	 if (!xdr_Data (xdrs, &objp->data))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_readargs (XDR *xdrs, readargs *objp)
{
	register int32_t *buf;

	 if (!xdr_FileIdentifier (xdrs, &objp->f))
		 return FALSE;
	 if (!xdr_FilePointer (xdrs, &objp->position))
		 return FALSE;
	 if (!xdr_Length (xdrs, &objp->length))
		 return FALSE;
	return TRUE;
}
