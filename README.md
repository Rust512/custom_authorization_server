# custom_authorization_server
This repository contains a authorization server that uses spring data JPA to store users, authorities and tokens

# Getting Started

## Step 1: generate Authorization code:

sample code verifier: d525782190744b2b59a132033bd560e916c03c46edfbddcf6b535eba
code challenge: DqQg6cYc7LvypsvIFQqWuw5JfUCjVVa9C_FmQG60EDY

The code challenge is the Base 64 encoding of the SHA256 hash of the verifier.

Now, paste this URL on your browser:
http://localhost:8080/oauth2/authorize?client_id=default&response_type=code&redirect_uri=https://example.com/auth&scope=openid&code_challenge=DqQg6cYc7LvypsvIFQqWuw5JfUCjVVa9C_FmQG60EDY&code_challenge_method=S256

It should redirect you to the login page.

Fill in the default credentials:

username: admin
password: Admin@123

On successful login, it should redirect you to the example.com page.
from the URL, carefully copy the part after the substring '?code='.

This is the authorization code.

## Step 2: acquire token:
With the authorization code, send the curl request:

```curl --location --request POST 'http://localhost:8080/oauth2/token?client_id=default&redirect_uri=https%3A%2F%2Fexample.com%2Fauth&grant_type=authorization_code&code=ACQUIRED_AUTHORIZATION_CODE&code_verifier=d525782190744b2b59a132033bd560e916c03c46edfbddcf6b535eba' --header 'Authorization: Basic ZGVmYXVsdDpkZWZhdWx0'```

***Please note that for the basic authentication, the client credentials: {clientId: default, clientSecret: default} are used***

In the response, You will find the "access_token"

You can use this token anywhere in the resource server.

