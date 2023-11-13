openssl pkcs12 -export -in certificate.crt -inkey private.key -out parkseungchul.pfx
openssl pkcs12 -in parkseungchul.pfx -clcerts -nokeys -out parkseungchul.crt
keytool -import -alias parkseungchul -file parkseungchul.crt -keystore trust.jks