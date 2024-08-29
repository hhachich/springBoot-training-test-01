
# SPRING BOOT : Améliorer la robustesse de vos applications avec les TESTS UNITAIRES

Ce dépôt contient le code et les exemples présentés dans la vidéo **"SPRING BOOT : Améliorer la robustesse de vos applications avec les TESTS UNITAIRES"**. Ce projet a pour but de montrer comment intégrer des tests unitaires dans une application Spring Boot afin de renforcer sa robustesse et d'assurer une meilleure qualité du code.

## Table des matières
- [Introduction](#introduction)
- [Prérequis](#prérequis)
- [Configuration de la base de données avec Docker](#configuration-de-la-base-de-données-avec-docker)
- [Création de tests unitaires](#création-de-tests-unitaires)
- [Gestion des exceptions](#gestion-des-exceptions)
- [Mocks et tests de services](#mocks-et-tests-de-services)
- [Conclusion](#conclusion)

## Introduction

Les tests unitaires sont essentiels pour garantir que le code de votre application Spring Boot fonctionne correctement, même après des modifications. Ce projet illustre comment :
- Écrire des tests unitaires pour vérifier le bon fonctionnement du code.
- Configurer une base de données pour les tests avec Docker.
- Utiliser JPA pour interagir avec la base de données.
- Tester les exceptions et utiliser des mocks pour simuler des services.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :
- **Java 21** ou supérieur
- **Spring Boot 3.3.3** ou supérieur
- **Maven** ou **Gradle** pour la gestion des dépendances
- **JUnit 5** pour les tests unitaires
- **Docker** pour la gestion de la base de données via des conteneurs
- Une base de données SQL (gérée via Docker)

## Configuration de la base de données avec Docker

Le projet utilise Docker pour simplifier la gestion de la base de données. Voici comment la configurer :

1. Assurez-vous d'avoir Docker installé sur votre machine.

2. Un fichier `docker-compose.yml` est fourni pour lancer la base de données. Exécutez la commande suivante pour démarrer le conteneur :
   ```bash
   docker-compose up -d
   ```

3. Cette commande crée et démarre la base de données dans un conteneur Docker en arrière-plan.

4. La configuration de la base de données (nom, utilisateur, mot de passe) est définie dans le fichier `application.properties`.

5. Lorsque l'application Spring Boot démarre, elle se connecte automatiquement à cette base de données.

## Création de tests unitaires

Les tests unitaires sont créés pour la classe `CustomerService` :
- Les classes de test sont générées avec le suffixe `Test`.
- Nommez les méthodes de test de manière descriptive pour indiquer leur objectif.
- Commencez par écrire un test minimaliste pour vous familiariser avec le processus.

## Gestion des exceptions

Ce segment explique comment tester les exceptions dans un service Spring Boot :
- Testez si l'ID recherché ne correspond à aucun enregistrement dans la base de données.
- Gérer les exceptions dans les tests unitaires en écrivant des méthodes spécifiques pour vérifier ces cas.

## Mocks et tests de services

Utilisez des mocks pour tester les services Spring Boot :
- Remplacez un service par un mock dans les tests unitaires.
- Utilisez des valeurs attendues pour tester les résultats des services.
- Assurez-vous que les tests réussissent après avoir effectué les modifications nécessaires.

## Conclusion

L'intégration des tests unitaires dans votre projet Spring Boot, combinée avec l'utilisation de Docker pour gérer la base de données, permet de renforcer la fiabilité de votre application, d'identifier rapidement les problèmes potentiels, et d'améliorer la qualité générale du code. Ce projet vous guide à travers les étapes essentielles pour mettre en place des tests unitaires efficaces.

# Lien
https://www.youtube.com/watch?v=7-tgpOuFti8