# kafka-example


## Para levantar los container necesarios 
Para levantar los container necesarios
```
docker-compose -f docker-compose.yml up -d
```

## Para crear un topic es necesario conectarse al container
### 
```
sudo docker exec -it kafka /bin/sh
```
Ir a la carpeta donde estan los binarios:
```
cd /opt/kafka
```
Para crear un topic se corre el siguiente comando 
```
./bin/kafka-topics.sh --create --zookeeper "zookeeper:2181" \
 --replication-factor 1 --partitions 1 --topic topic-name 
```
Si se quieren listar los topics creados en el cluster 
```
./bin/kafka-topics.sh --list --zookeeper "zookeeper:2181" 
```


## Autores 💭
* **Gaspar Budó Berra**
* **Bruno Squillari**
* **Facundo Zimbimbakis**
* **Santiago Hadad**
