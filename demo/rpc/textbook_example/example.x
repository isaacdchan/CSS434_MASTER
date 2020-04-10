const MAX = 1000;
typedef int FileIdentifier;
typedef int FilePointer;
typedef int Length;
struct Data {
	int length;
	char buffer[MAX];
};
struct writeargs {
	FileIdentifier f;
	FilePointer position;
	Data data;
};
struct readargs {
	FileIdentifier f;
	FilePointer position;
	Length length;
};

program FILEREADWRITE {
   version VERSION {
	void WRITE(writeargs)=1;
	Data READ(readargs)=2;
   }=2;
} = 9999;
