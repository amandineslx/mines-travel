Import data

```
./bin/mongoimport --host localhost --db minesTravel --collection hotels --type csv --file data_hotel.csv --headerline

./bin/mongoimport --host localhost --db minesTravel --collection users --type csv --file data_user.csv --headerline
```