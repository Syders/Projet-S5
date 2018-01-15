1.Télécharger:
	Si Windows, WampServer sur http://www.wampserver.com/ 32 ou 64 bits selon votre version de Windows.
	Si Linux, Lamp en suivant le tutoriel sur ce lien:https://doc.ubuntu-fr.org/lamp.
	(Si déja installé, passer à l'étape suivante)

2.Démarrer le serveur:
	Si Windows, cliquer sur le raccourci de WampServer a crée et il se lance tout seul. 
	(en bas à droite, dans les icones cachés ou sur la barre de tache, le logo de WampServer s'affiche en vert pour dire que c'est allumé)
	Si linux, Lamp est déja actif après installation. Si vous avez mis Lamp en manuel: faut faire ces deux commandes:
		sudo service mysql start
		sudo service apache2 start

3.Aller sur http://localhost/phpmyadmin/ et ouvrir une session avec le root et votre mot de passe (qui peut être vide) que vous avez mis pour l'installation.
Creer un compte utilisateur avec pour nom d'utilisateur "projet",  mot de passe "projet" et en cochant Prililèges globaux puis décocher administration.

4.Faire nouvelle base de données, créer un base de donnée s'appelant "bddProjet" puis cliquer sur importer et parcourir et mettez la base de donnée qui vous intéresse:
	Script 1: script_non_vide.sql pour une base de donnée pré-construite avec des valeurs.
	Script 2: script_vide.sql pour une base de donnée sans les valeurs.

5.Executer les programmes par la suite.