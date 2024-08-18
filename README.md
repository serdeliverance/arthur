# Arthur

A minimalistic API written in Java without using frameworks.

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

- create account
- deposit
- withdraw
- transfer