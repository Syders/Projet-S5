1.T�l�charger:
	Si Windows, WampServer sur http://www.wampserver.com/ 32 ou 64 bits selon votre version de Windows.
	Si Linux, Lamp en suivant le tutoriel sur ce lien:https://doc.ubuntu-fr.org/lamp.
	(Si d�ja install�, passer � l'�tape suivante)

2.D�marrer le serveur:
	Si Windows, cliquer sur le raccourci de WampServer a cr�e et il se lance tout seul. 
	(en bas � droite, dans les icones cach�s ou sur la barre de tache, le logo de WampServer s'affiche en vert pour dire que c'est allum�)
	Si linux, Lamp est d�ja actif apr�s installation. Si vous avez mis Lamp en manuel: faut faire ces deux commandes:
		sudo service mysql start
		sudo service apache2 start

3.Aller sur http://localhost/phpmyadmin/ et ouvrir une session avec le root et votre mot de passe (qui peut �tre vide) que vous avez mis pour l'installation.
Creer un compte utilisateur avec pour nom d'utilisateur "projet",  mot de passe "projet" et en cochant Prilil�ges globaux puis d�cocher administration.

4.Faire nouvelle base de donn�es, cr�er un base de donn�e s'appelant "bddProjet" puis cliquer sur importer et parcourir et mettez la base de donn�e qui vous int�resse:
	Script 1: script_non_vide.sql pour une base de donn�e pr�-construite avec des valeurs.
	Script 2: script_vide.sql pour une base de donn�e sans les valeurs.

5.Executer les programmes par la suite.