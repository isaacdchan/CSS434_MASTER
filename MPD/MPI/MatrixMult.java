����   2 �	 < k	 < l	 < m	 < n	 < o	 < p
 q r	 s t u
 	 v w
 	 x
 	 y z {
 	 |
 	 }
 ~ 
 ? v	 < �	 < �	 � �
 � �
 � �
 < � �
 < � �	 < �	 < �	 < � �
   v � �	 � �
 � �	 � �
 < �
 � � � �
   �
 	 � �
 � �
 � � � � � �	 s �
 ~ � �
 s �
 � �
 � �
 � �	 � � �
 < �
 � � � myrank I nprocs a [D b c averows extra offset [I rows mtype tagFromMaster ConstantValue    tagFromSlave    master     printOption Z init (I)V Code LineNumberTable StackMapTable compute print ([D)V <init> (IZ)V � � J � 
Exceptions � main ([Ljava/lang/String;)V � 
SourceFile MatrixMult.java C D E D F D K J @ A T U � � � � � � java/lang/StringBuilder ^ � [ � � � � ] ] =  � � � � � � � B A I J � � � � � � � � V W array a: \ ] array b: G A H A L A java/util/Date sending   rows to rank  � � � � � � [ W � � 	result c: time elapsed =  � � � �  msec � � � � � rank[ ] at  : multiplication completed java/net/UnknownHostException � � � � .usage: prunjava 1 MatrixMult matrix_size [y|n] � W � � � � � � � � � 
MatrixMult ^ _ � � java/lang/Object mpi/MPIException [Z java/lang/Math sqrt (D)D java/lang/System out Ljava/io/PrintStream; ()V append -(Ljava/lang/String;)Ljava/lang/StringBuilder; (I)Ljava/lang/StringBuilder; (D)Ljava/lang/StringBuilder; toString ()Ljava/lang/String; java/io/PrintStream println (Ljava/lang/String;)V mpi/MPI 
COMM_WORLD Lmpi/Intracomm; mpi/Intracomm Rank ()I Size INT Lmpi/Datatype; Send '(Ljava/lang/Object;IILmpi/Datatype;II)V DOUBLE Recv 2(Ljava/lang/Object;IILmpi/Datatype;II)Lmpi/Status; getTime ()J (J)Ljava/lang/StringBuilder; java/net/InetAddress getLocalHost ()Ljava/net/InetAddress; getHostName err (Ljava/lang/Object;)V exit Init (([Ljava/lang/String;)[Ljava/lang/String; java/lang/Integer parseInt (Ljava/lang/String;)I Bcast &(Ljava/lang/Object;IILmpi/Datatype;I)V BOOLEAN Finalize ! < ?      @ A     B A     C D     E D     F D     G A     H A     I J     K J     L A    M A  N    O  P A  N    Q  R A  N    S   T U     V W  X   �     v=� $>� *� h``�R�������=� $>� *� h`d�R�������=� !>� *� h`R�������    Y   B    5  6  7  6 " 5 ( 8 / 9 6 : D 9 J 8 P ; W < ^ = i < o ; u > Z   , � � � � � � � � � � � �   [ W  X   � 	    S=� N>*� .� <6� -*� h`\1*� h`1*� h`1kcR���ӄ��������    Y   "    F  G  H  J @ H F G L F R L Z    � � � � /� �   \ ]  X   �     l*� � g*� � _+��� �=>� P6� A� � 	Y� 
� � � � � � +h`1� � � ���������    Y   "    S  T  U  V ' X _ V e U k \ Z    � � � C�   ^ _  X  |    *� *� *� *� *� *� *�
� *�
� *� *� � � *� � � *h�� *h�� *h�� *� *� ��*� � � **� � � � **� � **� l� **� p� *� O*� �  Y� !N6*� � �*� *� � *� `� *� O� � 	Y� 
"� *� .� #� � � � � g� *� � $*� � %� *� � $*� � %� *� *� .h*� .h� &*� � %� *� h� &*� � %*� \.*� .`O���8*� '66*� � Y� *� � $*� � (W� *� � $*� � (W� *� *� .h*� .h� &*� � (W�����  Y� !:� )� **� � � � 	Y� 
*� � +-� +e� ,-� � � � �>� *� � $� (W� *� � $� (W� *� *� .h� &� (W� *� h� &� (W*� '� *� � $� %� *� � $� %� *� *� .h� &� %� .N-� /:� � 	Y� 
0� *� � 1� � 2� � � � N� 4-� 5� ��� 3  Y   @   d   	         # $ $ + , 0 e : f D h M i V j _ l d n k r p s x t � u � v � y � z � { � | �  � � � � � � � �" �7 �Z �q �� �� �� �� �� �� �� �� �� �� � �	 �0 �3 �5 �G �Y �r �� �� �� �� �� �� �� �� �� �� � � Z   T � �  ` a  �   ` a  b�   ` a  b� �� � 
� ^� B� �w c d     e 	 f g  X   �     k*�� � 6� � 7*� 8W�
L�M,T� � � +*2� 9O*�� ,T� +� $� :� ,� ;� :� <Y+.,3� =W� >�    Y   B    �  �  �  �  �  �  � # � , � 5 � ; � ? � L � Y � g � j � Z    � , b h d     e  i    j