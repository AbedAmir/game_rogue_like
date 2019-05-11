# Projet_POO
JABAR Yosra
DOUDOUH Yassin 
ABED Amir 

Mini projet Roguelike

Instruction d'éxécution:

   java -jar rogue-1.0-SNAPSHOT-jar-with-dependencies.jar


Scénario de démonstration:

   - Lancement du jeu
   
   - Start du jeu
   
   - Choix du player. On peut incarner un humain, un zombie ou encore un alien.
   
   - Le player et toutes les composantes de l'univers du jeu seront placés aléatoirement dans la map et sont représentés par un ensemble de cases carrées où chaque cases correspond à un symbole ASCII.
   
   - Le player fera face à 2 types d'adversaires : Des monstres et des dragons
    
   - Si le joueur tue des monstres, son score augmante de 1 et s'il tue un dragon, son score augmante de 2. Son level augmentera d'une unité par palier de 5.         
                                             
   - Si le player est attaqué par un monstre il perd un certains nombres de points de vie entre 0 et 10. Et si c'est un dragon qui attaque le player, ce dernier perdera entre 0 et 20 ponits de vie.
   
   - Il pourra récupérer un certain nombres de points de vie en ramassant une potion de vie en se plaçant sur la case de la potion et en utilisant la commande "G"(20 points de vie).
   
   - Si le player ne possède plus de points de vie, il meurt. 
   
   - Le but étant d'obtenir le score le plus élevé.
   
Description de l'univers du jeu :

	- L'univers sera généré aléatoirement en début de partie.
	
	- Le player sera représenté par la lettre "A" si l'utilisateur décide d'incarner un alien, la lettre "H" s'il décide d'incarner un humain ou la lettre "Z" s'il décide d'incarner un zombie.
	
	- Les murs seront représentés par le symbole "#"
	
	- Le sol sera représenté par le symbole "."
	
	- Les potions de vie seront représentés par la lettre "V".
	
	- Les monstres seront représentés par la lettre "f".
	
	- Les dragons seront représentés par la lettre "D".
	
	- Les Personnages non Joueur seront représetés par la lettre "P".

Manuel d'utilisation :

	- Commencer une parie : Appuyer sur la touche "Entrée"
	
	- Choisir un personnage : Appuyer sur la touche "A" pour incarner un alien, la touche "Z" pour incarer un zombie ou la touche "H" pour incarner un humain

    - Déplacement : Utiliser les flèches (droite, gauche, haut et bas).
     
    - Ramasser une potion de vie : Se placer sur la case de la potion et appuyer sur la touche "G" du clavier.
     
    - Attaquer : Se placer à coté de la case d'un monstre et se diriger vers la case où se trouve le monstre. Attention les monstres sont également en mouvement.
	 
   



