# 1-Kata-Supermarket-Pricing
La tarification d'un Supermarch�  KATA en java

Ce repo est une impl�mentation java de la tarification d'un Supermarch�  KATA.

Pour le syst�me de tarification dans les supermarch�s il y a deux cas:

1-Certaines produits qui ont des prix simples Par exemple: 
� bo�te de haricots co�te 0,65 $. 

2-D'autres choses ont des prix plus complexes. Par exemple:

� trois pour un dollar (quel est le prix si j'en ach�te 4 ou 5?)

� 1,99 $ / livre (alors que co�te 4 onces?)

� achetez-en deux, obtenez-en un gratuitement (le troisi�me article a-t-il un prix?)

Le programme prend en charge et impl�mente ce syst�me de tarification avec les diff�rents cas.

# 2-R�gles-de-tarifications:
Il y a deux r�gles qui sont impl�ment�es:
### R�gle1:
Lorsqu'un client ach�te x-1 unit� d'un produit,il obtien un x �me produit gratuitement ,du coup la tarification d'un x unit� doit se bas� sur (le prix de l'unit�)*(x-1)
### R�gle2:
Lorsqu'un client ach�te  x unit� d'un produit ,le prix du lot sera y euro.


# 3-Diagramme-de-classe:
Le digramme de classe :
![Alt text](diagrammeDeClasseFinal.PNG?raw=true "Title")
