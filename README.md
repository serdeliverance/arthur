# arthur

# Endpoints

## Create User

```bash
curl --request POST \
  --url http://localhost:8080/users \
  --header 'Content-Type: application/json' \
  --data '{
	"username": "iamble",
	"email": "iamble@ble.com"
}'
```

## TODO

- create user
- create account
- deposit
- withdraw
- transfer

#### tech TODOs

- add flyway
- add open api
- add jooq
- add guice
- add kafka